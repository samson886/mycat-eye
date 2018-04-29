package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.MycatConnection;
import io.mycat.eye.agent.bean.MycatConnectionExample;
import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MycatConnectionMapper;
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
 * Created by xqy on 18/4/25.
 */
@Component
public class MycatConnectionTask  extends AbstractTask{
    private static final Logger logger = LoggerFactory.getLogger(MycatConnectionTask.class);
    private static final String SHOW_SQL = "show @@connection";
    public final static long DELAY_TIME = 1*60*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    @Resource
    MycatConnectionMapper mapper;

    @Scheduled(fixedDelay = DELAY_TIME)
    public void execute(){
        System.out.println(SHOW_SQL+" task:"+DELAY_TIME+" ms");
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
            MycatConnectionExample example = new MycatConnectionExample();
            statusList.stream().forEach(o -> {
                MycatConnection c = new MycatConnection();
                c.setcType("frontend");
                if(o.get("PROCESSOR")!=null){
                    c.setProcessor((String) o.get("PROCESSOR"));
                }
                if(o.get("ID")!=null){
                    c.setId((int) o.get("ID"));
                }

                if(o.get("HOST")!=null){
                    c.setcHost((String) o.get("HOST"));
                }
                if(o.get("PORT")!=null){
                    c.setcPort((int) o.get("PORT"));
                }
                if(o.get("LOCAL_PORT")!=null){
                    c.setlPort((int) o.get("LOCAL_PORT"));
                }
                if(o.get("USER")!=null){
                    c.setcUser((String) o.get("USER"));
                }
                if(o.get("SCHEMA")!=null){
                    c.setcSchema((String) o.get("SCHEMA"));
                }
                if(o.get("CHARSET")!=null){
                    c.setcCharset((String) o.get("CHARSET"));
                }
                if(o.get("net_in")!=null){
                    c.setNetIn((long) o.get("net_in"));
                }
                if(o.get("net_out")!=null){
                    c.setNetOut((long) o.get("net_out"));
                }
                if(o.get("ALIVE_TIME(S)")!=null){
                    c.setLife((long) o.get("ALIVE_TIME(S)"));
                }
                if(o.get("RECV_BUFFER")!=null){
                    c.setRecvBuffer((int) o.get("RECV_BUFFER"));
                }

                if(o.get("SEND_QUEUE")!=null){
                    c.setSendQueue((int) o.get("SEND_QUEUE"));
                }

                if(o.get("txlevel")!=null){
                    c.setTxlevel((String) o.get("txlevel"));//String
                }
                if(o.get("autocommit")!=null){
                    c.setAutocommit((String) o.get("autocommit"));
                }
//                mapper.insertSelective(c);
                MycatConnectionExample.Criteria criteria = example.createCriteria();
                criteria.andIdEqualTo(c.getId());
                List<MycatConnection> cc = mapper.selectByExample(example);
                if(cc.size()==0) {
                    mapper.insertSelective(c);
                }
            });
        }
    }
}
