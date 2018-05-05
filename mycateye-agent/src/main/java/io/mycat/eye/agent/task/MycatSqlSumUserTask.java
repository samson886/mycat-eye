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
public class MycatSqlSumUserTask extends AbstractTask{
    private static final Logger logger = LoggerFactory.getLogger(MycatSqlHighTask.class);
    private static final String SHOW_SQL = "show @@sql.sum.user";
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
                    sql.setId((int) o.get("ID"));
                }
                if(o.get("USER")!=null){
                    sql.setcUser((String) o.get("USER"));
                }
                if(o.get("R")!=null){
                    sql.setR((int) o.get("R"));
                }
                if(o.get("W")!=null){
                    sql.setW((int) o.get("W"));
                }
                if(o.get("R%")!=null){
                    sql.setrP((float) o.get("R%"));
                }
                if(o.get("MAX")!=null){
                    sql.setSqlMax((int) o.get("MAX"));
                }
                if(o.get("NET_IN")!=null){
                    sql.setNetIn((int) o.get("NET_IN"));
                }
                if(o.get("NET_OUT")!=null){
                    sql.setNetOut((int) o.get("NET_OUT"));
                }
                if(o.get("TIME_COUNT")!=null){
                    String time_count = (String) o.get("TIME_COUNT");
                    time_count = time_count.substring(1,time_count.length() -1);
                    String[] time_counts = time_count.split(", ");
                    sql.setTimeCount(time_count);
                    sql.setTimeCount0(Integer.valueOf(time_counts[0]));
                    sql.setTimeCount1(Integer.valueOf(time_counts[1]));
                    sql.setTimeCount2(Integer.valueOf(time_counts[2]));
                    sql.setTimeCount3(Integer.valueOf(time_counts[3]));
                }
                if(o.get("TTL_COUNT")!=null){
                    String ttl_count = (String) o.get("TTL_COUNT");
                    ttl_count = ttl_count.substring(1,ttl_count.length()-1);
                    String[] ttl_counts = ttl_count.split(", ");
                    sql.setTtlCount(ttl_count);
                    sql.setTtlCount0(Integer.valueOf(ttl_counts[0]));
                    sql.setTtlCount1(Integer.valueOf(ttl_counts[1]));
                    sql.setTtlCount2(Integer.valueOf(ttl_counts[2]));
                    sql.setTtlCount3(Integer.valueOf(ttl_counts[3]));
                }
                if(o.get("LAST_TIME")!=null){
                    sql.setLastTime((long) o.get("LAST_TIME"));
                }
                sql.setCollectType("1");
                mapper.insertSelective(sql);
            });
        }
    }
}
