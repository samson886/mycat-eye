package io.mycat.eye.agent.task;

import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import io.mycat.eye.agent.bean.MycatServerStatusExample;
import io.mycat.eye.agent.mapper.MycatServerMapper;
import io.mycat.eye.agent.mapper.MycatServerStatusMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xqy on 18/4/25.
 */
@Component
public class MycatServerStatusTask{

    private static final String SHOW_SERVER = "show @@server";

    @Resource
    MycatServerMapper mycatServerMapper;

    @Scheduled(fixedDelay = TaskConstant.DELAY_TIME)
    public void execute(){
        System.out.println("execute my server task:"+TaskConstant.DELAY_TIME+" ms");
        MycatServerExample mycatServerExample = new MycatServerExample();
        List<MycatServer> mycatServerList = mycatServerMapper.selectByExample(mycatServerExample);
        for(MycatServer server:mycatServerList){
            System.out.println(server.toString());
        }
    }

}
