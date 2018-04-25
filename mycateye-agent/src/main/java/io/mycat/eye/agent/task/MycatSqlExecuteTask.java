package io.mycat.eye.agent.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by xqy on 18/4/25.
 */
@Component
public class MycatSqlExecuteTask extends AbstractTask {

    @Scheduled(fixedDelay = TaskConstant.DELAY_TIME)
    public void execute(){
        System.out.println("execute sql execution task:"+TaskConstant.DELAY_TIME+" ms");
    }
}
