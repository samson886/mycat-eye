package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import io.mycat.eye.agent.bean.MycatSqlExecuteExample;
import io.mycat.eye.agent.bean.MycatSqlSum;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MycatServerMapper;
import io.mycat.eye.agent.mapper.MycatSqlSumMapper;
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
public class MycatSqlSumTableTask extends AbstractTask {
    private static final Logger logger = LoggerFactory.getLogger(MycatSqlHighTask.class);
    private static final String SHOW_SQL = "show @@sql.sum.table";
    public final static long DELAY_TIME = 1*60*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    @Resource
    MycatSqlSumMapper mapper;


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
                MycatSqlSum sql = new MycatSqlSum();
                if(o.get("ID")!=null){
                    sql.setId((long) o.get("ID"));
                }
                if(o.get("TABLE")!=null){
                    sql.setSqlTable((String) o.get("TABLE"));
                }
                if(o.get("R")!=null){
                    sql.setR((long) o.get("R"));
                }
                if(o.get("W")!=null){
                    sql.setW((long) o.get("W"));
                }
                if(o.get("R%")!=null){
                    sql.setrP(Float.valueOf((String) o.get("R%")));
                }

                if(o.get("RELATABLE")!=null){
                    sql.setRelatable((String) o.get("RELATABLE"));
                }
                if(o.get("RELACOUNT")!=null){
                    sql.setRelacount((String) o.get("RELACOUNT"));
                }
                if(o.get("LAST_TIME")!=null){
                    sql.setLastTime((long) o.get("LAST_TIME"));
                }
                sql.setCollectType("2");
                sql.setServerId(server.getId());
                sql.setCollectTime(System.currentTimeMillis());
                mapper.insertSelective(sql);
            });
        }
    }
}
