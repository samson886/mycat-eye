package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import io.mycat.eye.agent.bean.MycatSqlLarge;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MycatServerMapper;
import io.mycat.eye.agent.mapper.MycatSqlLargeMapper;
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
 * Created by xqy on 18/5/11.
 */
@Component
public class MycatSqlLargeTask extends AbstractTask{
    Logger logger = LoggerFactory.getLogger(MycatSqlLargeTask.class);
    private final String SHOW_SQL = "show @@sql.large";
    public final long DELAY_TIME = 1*60*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    @Resource
    MycatSqlLargeMapper mapper;

    @Scheduled(fixedDelay = DELAY_TIME)
    public void execute() {
        logger.debug(SHOW_SQL + " task:" + DELAY_TIME + " ms");
        MycatServerExample mycatServerExample = new MycatServerExample();
        List<MycatServer> mycatServerList = mycatServerMapper.selectByExample(mycatServerExample);
        for (MycatServer server : mycatServerList) {
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
                MycatSqlLarge sql = new MycatSqlLarge();
                if(o.get("USER")!=null){
                    sql.setSqlUser((String) o.get("USER"));
                }
                if(o.get("ROWS")!=null){
                    sql.setRows((long) o.get("ROWS"));
                }
                if(o.get("START_TIME")!=null){
                    sql.setStartTime((long) o.get("START_TIME"));
                }
                if(o.get("EXECUTE_TIME")!=null){
                    sql.setExecuteTime((long) o.get("EXECUTE_TIME"));
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
