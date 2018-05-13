package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import io.mycat.eye.agent.bean.MycatSqlExecute;
import io.mycat.eye.agent.bean.MycatSqlExecuteExample;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MycatServerMapper;
import io.mycat.eye.agent.mapper.MycatSqlExecuteMapper;
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
public class MycatSqlExecuteTask extends AbstractTask {
    private static final Logger logger = LoggerFactory.getLogger(MycatBackendTask.class);
    private static final String SHOW_SQL = "show @@sql.execute";
    public final static long DELAY_TIME = 1*60*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    @Resource
    MycatSqlExecuteMapper mapper;

    @Scheduled(fixedDelay = DELAY_TIME)
    public void execute(){
        logger.debug(SHOW_SQL+" task:"+DELAY_TIME+" ms");
        MycatServerExample mycatServerExample = new MycatServerExample();
        List<MycatServer> mycatServerList = mycatServerMapper.selectByExample(mycatServerExample);
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
            logger.debug(String.valueOf(statusList.size()));
            MycatSqlExecuteExample example = new MycatSqlExecuteExample();
            MycatSqlExecuteExample.Criteria criteria = example.createCriteria();

            statusList.stream().forEach(o -> {
                MycatSqlExecute sqlExecute = new MycatSqlExecute();
                if(o.get("SQL_ID")!=null){
                    sqlExecute.setSqlId((long) o.get("SQL_ID"));
                }
                if(o.get("EXECUTE")!=null){
                    sqlExecute.setSqlExecute((long) o.get("EXECUTE"));
                }
                if(o.get("TIME")!=null){
                    sqlExecute.setSqlTime((double) o.get("TIME"));
                }
                if(o.get("MAX_TIME")!=null){
                    sqlExecute.setMaxTime((double) o.get("MAX_TIME"));
                }
                if(o.get("MIN_TIME")!=null){
                    sqlExecute.setMinTime((double) o.get("MIN_TIME"));
                }
                sqlExecute.setServerId(server.getId());
                sqlExecute.setCollectTime(System.currentTimeMillis());
                mapper.insertSelective(sqlExecute);
            });
        }
    }
}
