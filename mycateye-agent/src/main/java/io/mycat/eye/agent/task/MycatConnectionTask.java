package io.mycat.eye.agent.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by xqy on 18/4/25.
 */
@Component
public class MycatConnectionTask  extends AbstractTask{

    private static final String SHOW_CONNECTION = "show @@connection";
    private static final String SHOW_BACKEND = "show @@backend";

    @Scheduled(fixedDelay = TaskConstant.DELAY_TIME)
    public void execute(){
        System.out.println("execute connection task:"+TaskConstant.DELAY_TIME+" ms");
    }
}
