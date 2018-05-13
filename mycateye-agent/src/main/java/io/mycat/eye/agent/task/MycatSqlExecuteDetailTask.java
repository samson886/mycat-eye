package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.*;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MycatServerMapper;
import io.mycat.eye.agent.mapper.MycatSqlDetailMapper;
import io.mycat.eye.agent.mapper.MycatSqlExecuteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * Created by xqy on 18/4/28.
 */
@Component
public class MycatSqlExecuteDetailTask extends AbstractTask {
    private static final Logger logger = LoggerFactory.getLogger(MycatSqlExecuteDetailTask.class);
    private static final String SHOW_SQL = "show @@sql.detail where id = ";
    public final static long DELAY_TIME = 1*60*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    @Resource
    MycatSqlDetailMapper mapper;

    @Resource
    MycatSqlExecuteMapper executeMapper;

    @Scheduled(fixedDelay = DELAY_TIME)
    public void execute(){
        logger.debug(SHOW_SQL+" task:"+DELAY_TIME+" ms");
        MycatServerExample mycatServerExample = new MycatServerExample();
        List<MycatServer> mycatServerList = mycatServerMapper.selectByExample(mycatServerExample);
        List<MycatSqlExecute> executes = executeMapper.selectByExample(new MycatSqlExecuteExample());

        for(MycatSqlExecute exec:executes) {
            for (MycatServer server : mycatServerList) {
                logger.debug("server " + server.toString());
                String host = server.getServerHost();
                String port = server.getManagerPort().toString();
                String username = server.getUser();
                String password = new String(Base64.getDecoder().decode(server.getPassword()));

                QueryResult<List<Map<Object, Object>>> statusQueryResult = getQueryResult(host, port, SHOW_SQL + exec.getSqlId(), username, password);

                if (!statusQueryResult.isSuccess()) {
                    continue;
                }

                List<Map<Object, Object>> statusList = statusQueryResult.getData();

                logger.debug(String.valueOf(statusList.size()));

                statusList.stream().forEach(o -> {
                    MycatSqlDetail sql = new MycatSqlDetail();
                    if (o.get("DATA_SOURCE") != null) {
                        sql.setDataSource((String) o.get("DATA_SOURCE"));
                    }
                    if (o.get("EXECUTE") != null) {
                        sql.setExecute((long) o.get("EXECUTE"));
                    }
                    if (o.get("TIME") != null) {
                        sql.setTime((double) o.get("TIME"));
                    }
                    if (o.get("LAST_EXECUTE_TIMESTAMP") != null) {
                        sql.setLastExecuteTimestamp((long) o.get("LAST_EXECUTE_TIMESTAMP"));
                    }
                    if (o.get("LAST_TIME") != null) {
                        sql.setLastTime((double) o.get("LAST_TIME"));
                    }
                    sql.setSqlId(exec.getSqlId());
                    sql.setServerId(server.getId());
                    sql.setCollectTime(System.currentTimeMillis());
                    mapper.insertSelective(sql);
                });
            }
        }
    }
}
