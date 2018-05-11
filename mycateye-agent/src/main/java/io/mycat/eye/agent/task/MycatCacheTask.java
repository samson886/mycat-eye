package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.MycatCache;
import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MycatCacheMapper;
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
 * Created by xqy on 18/5/10.
 */
@Component
public class MycatCacheTask extends AbstractTask{
    Logger logger = LoggerFactory.getLogger(MycatCacheTask.class);
    private final String SHOW_SQL = "show @@cache";
    public final long DELAY_TIME = 1*60*1000;

    @Resource
    MycatServerMapper mycatServerMapper;

    @Resource
    MycatCacheMapper mapper;

    @Scheduled(fixedDelay = DELAY_TIME)
    public void execute() {
        logger.debug(SHOW_SQL + " task:" + DELAY_TIME + " ms");
        MycatServerExample mycatServerExample = new MycatServerExample();
        List<MycatServer> mycatServerList = mycatServerMapper.selectByExample(mycatServerExample);
        for(MycatServer server:mycatServerList) {
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
                MycatCache c = new MycatCache();
                if(o.get("CACHE")!=null){
                    c.setCache((String) o.get("CACHE"));
                }
                if(o.get("MAX")!=null){
                    c.setcMax((int) o.get("MAX"));
                }
                if(o.get("CUR")!=null){
                    c.setCur((int) o.get("CUR"));
                }
                if(o.get("ACCESS")!=null){
                    c.setAccess((int) o.get("ACCESS"));
                }
                if(o.get("HIT")!=null){
                    c.setHit((int) o.get("HIT"));
                }
                if(o.get("PUT")!=null){
                    c.setPut((int) o.get("PUT"));
                }
                if(o.get("LAST_ACCESS")!=null){
                    c.setLastAccess((int) o.get("LAST_ACCESS"));
                }
                if(o.get("LAST_PUT")!=null){
                    c.setLastPut((int) o.get("LAST_PUT"));
                }
                c.setServerId(server.getId());
                c.setCollectTime(System.currentTimeMillis());
                mapper.insertSelective(c);
            });
        }
    }
}
