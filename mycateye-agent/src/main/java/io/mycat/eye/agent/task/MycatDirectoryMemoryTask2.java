package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.MycatDirectMemory;
import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MycatDirectMemoryMapper;
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
 * Created by xqy on 18/5/11.
 */
@Component
public class MycatDirectoryMemoryTask2 extends AbstractTask{
    Logger logger = LoggerFactory.getLogger(MycatDirectoryMemoryTask2.class);
    private final String SHOW_SQL = "show @@directmemory=2";
    public final long DELAY_TIME = 2*60*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    @Resource
    MycatDirectMemoryMapper mapper;

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
                MycatDirectMemory c = new MycatDirectMemory();
                if(o.get("THREAD_ID")!=null){
                    c.setThreadId((long) o.get("THREAD_ID"));
                }
                if(o.get("MEM_USE_TYPE")!=null){
                    c.setMemUseType((String) o.get("MEM_USE_TYPE"));
                }
                //   SIZE
                if(o.get("SIZE")!=null){
                    c.setmSize((String) o.get("SIZE"));
                }
                if(o.get("MDIRECT_MEMORY_MAXED")!=null){
                    c.setMdirectMemoryMaxed((String) o.get("MDIRECT_MEMORY_MAXED"));
                }
                if(o.get("DIRECT_MEMORY_USED")!=null){
                    c.setDirectMemoryUsed((String) o.get("DIRECT_MEMORY_USED"));
                }
                if(o.get("DIRECT_MEMORY_AVAILABLE")!=null){
                    c.setDirectMemoryAvailable((String) o.get("DIRECT_MEMORY_AVAILABLE"));
                }
                if(o.get("SAFETY_FRACTION")!=null){
                    c.setSafetyFraction(Float.valueOf((String) o.get("SAFETY_FRACTION")));
                }
                if(o.get("DIRECT_MEMORY_RESERVED")!=null){
                    c.setDirectMemoryReserved((String) o.get("DIRECT_MEMORY_RESERVED"));
                }
                c.setServerId(server.getId());
                c.setCollectTime(System.currentTimeMillis());
                mapper.insertSelective(c);
            });
        }
    }
}
