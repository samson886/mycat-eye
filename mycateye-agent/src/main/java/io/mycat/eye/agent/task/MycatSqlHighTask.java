package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import io.mycat.eye.agent.bean.MycatSqlExecuteExample;
import io.mycat.eye.agent.bean.MycatSqlHigh;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MycatServerMapper;
import io.mycat.eye.agent.mapper.MycatSqlHighMapper;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * Created by xqy on 18/4/29.
 */
@Component
public class MycatSqlHighTask extends AbstractTask {
    private static final Logger logger = LoggerFactory.getLogger(MycatSqlHighTask.class);
    private static final String SHOW_SQL = "show @@sql.high";
    public final static long DELAY_TIME = 1*60*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    @Resource
    MycatSqlHighMapper mapper;


    @Scheduled(fixedDelay = DELAY_TIME)
    public void execute() {
        logger.debug(SHOW_SQL + " task:" + DELAY_TIME + " ms");
        MycatServerExample mycatServerExample = new MycatServerExample();
        List<MycatServer> mycatServerList = mycatServerMapper.selectByExample(mycatServerExample);
        for (MycatServer server : mycatServerList) {
            logger.debug("server " + server.toString());
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
                MycatSqlHigh sql = new MycatSqlHigh();

                if(o.get("ID")!=null){
                    sql.setId((long) o.get("ID"));
                }
                if(o.get("USER")!=null){
                    sql.setcUser((String) o.get("USER"));
                }
                if(o.get("FREQUENCY")!=null){
                    sql.setFrequency((long) o.get("FREQUENCY"));
                }
                if(o.get("AVG_TIME")!=null){
                    sql.setAvgTime((long) o.get("AVG_TIME"));
                }
                if(o.get("MAX_TIME")!=null){
                    sql.setMaxTime((long) o.get("MAX_TIME"));
                }
                if(o.get("MIN_TIME")!=null){
                    sql.setMinTime((long) o.get("MIN_TIME"));
                }
                if(o.get("EXECUTE_TIME")!=null){
                    sql.setExecuteTime((long) o.get("EXECUTE_TIME"));
                }
                if(o.get("LAST_TIME")!=null){
                    sql.setLastTime((long) o.get("LAST_TIME"));
                }
                if(o.get("SQL")!=null){
                    String s = (String) o.get("SQL");
                    s = StringEscapeUtils.escapeCsv(s);
                    sql.setcSql(s);
                }
                sql.setServerId(server.getId());
                sql.setCollectTime(System.currentTimeMillis());
                sql.setStartupTime(server.getStartup());
                mapper.insertSelective(sql);
            });
        }
    }
}
