/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  AgentController.java   
 * @Package io.mycat.eye.web.controller   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月11日 上午10:59:59   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  AgentController   
 * @Description:用于获取agent的url，便于前端页面执行ajax请求 
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月11日 上午10:59:59   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
@RestController
public class AgentController
{
    @Value("${agent.host}")
    private String agentUrl;
    
    @RequestMapping("/agent-host")
    public String getAgentUrl() {
        return agentUrl;
    }
}
