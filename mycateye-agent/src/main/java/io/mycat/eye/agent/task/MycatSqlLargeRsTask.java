package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import io.mycat.eye.agent.bean.MycatSqlLargeRs;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MycatServerMapper;
import io.mycat.eye.agent.mapper.MycatSqlLargeRsMapper;
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
public class MycatSqlLargeRsTask extends AbstractTask{
    Logger logger = LoggerFactory.getLogger(MycatSqlLargeRsTask.class);
    private final String SHOW_SQL = "show @@sql.resultset";
    public final long DELAY_TIME = 1*60*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    @Resource
    MycatSqlLargeRsMapper mapper;

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
                MycatSqlLargeRs sql = new MycatSqlLargeRs();
                if(o.get("ID")!=null){
                    sql.setId((long) o.get("ID"));
                }
                if(o.get("USER")!=null){
                    sql.setSqlUser((String) o.get("USER"));
                }
                if(o.get("FREQUENCY")!=null){
                    sql.setFrequency((long) o.get("FREQUENCY"));
                }
                if(o.get("SQL")!=null){
                    String s = (String) o.get("SQL");
                    s = StringEscapeUtils.escapeCsv(s);
                    sql.setcSql(s);
                }
                if(o.get("RESULTSET_SIZE")!=null){
                    sql.setResultsetSize((long) o.get("RESULTSET_SIZE"));
                }
                sql.setServerId(server.getId());
                sql.setCollectTime(System.currentTimeMillis());
                sql.setStartupTime(server.getStartup());
                mapper.insertSelective(sql);
            });
        }
    }
}
