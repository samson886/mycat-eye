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
 * Created by xqy on 18/4/28.
 */
@Component
public class MycatBackendTask extends AbstractTask {
    private static final Logger logger = LoggerFactory.getLogger(MycatBackendTask.class);
    private static final String SHOW_SQL = "show @@backend";
    public final static long DELAY_TIME = 30*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    @Resource
    MycatConnectionMapper mapper;

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
            MycatConnectionExample example = new MycatConnectionExample();
            statusList.stream().forEach(o -> {
                MycatConnection c = new MycatConnection();
                c.setcSchema("backend");
                if(o.get("processor")!=null){
                    c.setProcessor((String) o.get("processor"));
                }
                if(o.get("id")!=null){
                    c.setId((int) o.get("id"));
                }
                if(o.get("mysqlId")!=null){
                    c.setMysqlid((int) o.get("mysqlId"));
                }
                if(o.get("host")!=null){
                    c.setcHost((String) o.get("host"));
                }
                if(o.get("port")!=null){
                    c.setcPort((int) o.get("port"));
                }
                if(o.get("l_port")!=null){
                    c.setlPort((int) o.get("l_port"));
                }
                if(o.get("net_in")!=null){
                    c.setNetIn((long) o.get("net_in"));
                }
                if(o.get("net_out")!=null){
                    c.setNetOut((long) o.get("net_out"));
                }
                if(o.get("life")!=null){
                    c.setLife((long) o.get("life"));
                }
                if(o.get("closed")!=null){
                    c.setClosed((String) o.get("closed"));
                }
                if(o.get("borrowed")!=null){
                    c.setBorrowed((String) o.get("borrowed"));
                }
                if(o.get("SEND_QUEUE")!=null){
                    c.setSendQueue((int) o.get("SEND_QUEUE"));
                }
                if(o.get("schema")!=null){
                    c.setcSchema((String) o.get("schema"));
                }
                if(o.get("charset")!=null){
                    c.setcCharset((String) o.get("charset"));
                }
                if(o.get("txlevel")!=null){
                    c.setTxlevel((String) o.get("txlevel"));
                }
                if(o.get("autocommit")!=null){
                    c.setAutocommit((String) o.get("autocommit"));
                }
                mapper.insertSelective(c);
//                MycatConnectionExample.Criteria criteria = example.createCriteria();
//                criteria.andIdEqualTo(c.getId());
//                List<MycatConnection> cc = mapper.selectByExample(example);
//                if(cc.size()==0) {
//                    mapper.insertSelective(c);
//                }
            });
        }
    }
}
