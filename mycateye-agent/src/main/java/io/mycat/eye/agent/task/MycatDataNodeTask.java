package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.MycatDataNode;
import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MycatDataNodeMapper;
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
public class MycatDataNodeTask extends AbstractTask {
    private static final Logger logger = LoggerFactory.getLogger(MycatDataNodeTask.class);
    private static final String SHOW_SQL = "show @@datanode";
    public final static long DELAY_TIME = 2*60*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    @Resource
    MycatDataNodeMapper mycatDataNodeMapper;

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

            statusList.stream().forEach(o -> {
                MycatDataNode dataNode = new MycatDataNode();
                if(o.get("NAME")!=null){
                    dataNode.setName((String) o.get("NAME"));
                }
                if(o.get("DATHOST")!=null){
                    dataNode.setDatahost((String) o.get("DATHOST"));
                }
                if(o.get("INDEX")!=null){
                    dataNode.setdIdle((int) o.get("INDEX"));
                }
                if(o.get("TYPE")!=null){
                    dataNode.setdType((String) o.get("TYPE"));
                }
                if(o.get("ACTIVE")!=null){
                    dataNode.setdActive((int) o.get("ACTIVE"));
                }
                if(o.get("IDLE")!=null){
                    dataNode.setdIdle((int) o.get("IDLE"));
                }
                if(o.get("SIZE")!=null){
                    dataNode.setdSize((int) o.get("SIZE"));
                }
                if(o.get("EXECUTE")!=null){
                    dataNode.setdExecute((long) o.get("EXECUTE"));
                }
                if(o.get("TOTAL_TIME")!=null){
                    dataNode.setTotalTime((double) o.get("TOTAL_TIME"));
                }
                if(o.get("MAX_TIME")!=null){
                    dataNode.setMaxTime((double) o.get("MAX_TIME"));
                }
                if(o.get("MAX_SQL")!=null){
                    dataNode.setMaxSql((long) o.get("MAX_SQL"));
                }
                if(o.get("RECOVERY_TIME")!=null){
                    dataNode.setRecoveryTime((long) o.get("RECOVERY_TIME"));
                }
                dataNode.setServerId(server.getId());
                dataNode.setCollectTime(System.currentTimeMillis());
                mycatDataNodeMapper.insertSelective(dataNode);
            });
        }
    }
}
