package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import io.mycat.eye.agent.bean.MycatServerExample.Criteria;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MycatServerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * Created by xqy on 18/4/28.
 */
@Component
public class MycatServerStartupTask extends AbstractTask {
    private static final Logger logger = LoggerFactory.getLogger(MycatServerStartupTask.class);
    private static final String SHOW_SQL = "show @@time.startup";
    public final static long DELAY_TIME = 2*60*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    // 两分钟拉取一次
    @Scheduled(fixedDelay = DELAY_TIME)
    public void execute(){
        logger.info(SHOW_SQL+" task:"+DELAY_TIME+" ms\n");
        MycatServerExample mycatServerExample = new MycatServerExample();
        List<MycatServer> mycatServerList = mycatServerMapper.selectByExample(mycatServerExample);
        MycatServer mycatServer = new MycatServer();
        for(MycatServer server:mycatServerList) {
            logger.debug("server "+server.toString());
            String host = server.getServerHost();
            String port = server.getManagerPort().toString();
            String username = server.getUser();
            String password = new String(Base64.getDecoder().decode(server.getPassword()));
            QueryResult<List<Map<Object, Object>>> statusQueryResult = getQueryResult(host, port, SHOW_SQL, username, password);

            if (!statusQueryResult.isSuccess()) {
                continue;
            }

            List<Map<Object, Object>> statusList = statusQueryResult.getData();
            statusList.stream().forEach(o -> {
                logger.debug("########## "+server.getStartup()+" "+o.get("TIMESTAMP")+" "+(o.entrySet().contains("TIMESTAMP"))+" -- \n");
                if(o.get("TIMESTAMP") != null){
                    long ts = (long) o.get("TIMESTAMP");
                    if(server.getStartup() == null || server.getStartup() != ts){
                        logger.debug("=========="+server.getStartup()+" "+o.get("TIMESTAMP")+" -- \n");
                        mycatServer.setStartup(ts);
                        if(mycatServer.getStartupHistory()!=null) {
                            mycatServer.setStartupHistory(mycatServer.getStartupHistory() + "," + String.valueOf(ts));
                        }else{
                            mycatServer.setStartupHistory(String.valueOf(ts));
                        }
                        Criteria criteria = mycatServerExample.createCriteria();
                        criteria.andIdEqualTo(server.getId());
                        mycatServerMapper.updateByExampleSelective(mycatServer,mycatServerExample);
                    }
                }
            });
        }
    }
}
