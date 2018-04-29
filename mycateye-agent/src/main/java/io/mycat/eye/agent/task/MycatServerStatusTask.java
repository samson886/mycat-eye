package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import io.mycat.eye.agent.bean.MycatServerStatus;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MycatServerMapper;
import io.mycat.eye.agent.mapper.MycatServerStatusMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * Created by xqy on 18/4/25.
 */
@Component
public class MycatServerStatusTask extends AbstractTask{

    private static final Logger logger = LoggerFactory.getLogger(MycatServerStatus.class);

    private static final String SHOW_SQL = "show @@server";
    public final static long DELAY_TIME = 1*60*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    @Resource
    MycatServerStatusMapper mycatServerStatusMapper;

    // 1分钟拉取一次
    @Scheduled(fixedDelay = DELAY_TIME)
    public void execute(){
        logger.info(SHOW_SQL+" task:"+DELAY_TIME+" ms");
        MycatServerExample mycatServerExample = new MycatServerExample();
        List<MycatServer> mycatServerList = mycatServerMapper.selectByExample(mycatServerExample);
        for(MycatServer server:mycatServerList){
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
            logger.debug(String.valueOf(statusList.size()));

            statusList.stream().forEach(o -> {
                MycatServerStatus mycatServerStatus = new MycatServerStatus();
                if(o.get("UPTIME")!=null){
                    mycatServerStatus.setUptime((String) o.get("UPTIME"));
                }
                if(o.get("USED_MEMORY")!=null){
                    mycatServerStatus.setUsedMemory((long) o.get("USED_MEMORY"));
                }
                if(o.get("TOTAL_MEMORY")!=null){
                    mycatServerStatus.setTotalMemory((long) o.get("TOTAL_MEMORY"));
                }
                if(o.get("MAX_MEMORY")!=null){
                    mycatServerStatus.setMaxMemory((long) o.get("MAX_MEMORY"));
                }
                if(o.get("RELOAD_TIME")!=null){
                    mycatServerStatus.setReloadTime((long) o.get("RELOAD_TIME"));
                }
                if(o.get("ROLLBACK_TIME")!=null){
                    mycatServerStatus.setRollbackTime((long) o.get("ROLLBACK_TIME"));
                }
                if(o.get("CHARSET")!=null){
                    mycatServerStatus.setCharset((String) o.get("CHARSET"));
                }
                if(o.get("STATUS")!=null){
                    mycatServerStatus.setStatus((String) o.get("STATUS"));
                }
                mycatServerStatus.setCollectTime(System.currentTimeMillis());
                mycatServerStatus.setMycatId(server.getId());
                mycatServerStatusMapper.insertSelective(mycatServerStatus);
            });
        }
    }

}
