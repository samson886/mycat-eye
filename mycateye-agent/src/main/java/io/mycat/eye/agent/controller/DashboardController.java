/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  DashboardController.java   
 * @Package io.mycat.eye.agent.controller   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年9月18日 下午4:51:54   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mycat.eye.agent.service.DashboardService;

/**   
 * @ClassName:  DashboardController   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年9月18日 下午4:51:54   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController
{
    @Resource
    private DashboardService dashboardService;
    /**
     * 获取控制台概要信息
     * @Title: getDashboardOverview   
     * @param serverId
     * @return        
     * @throws
     */
    @RequestMapping(value = "/{serverId}/dashboard-overview", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public Object getDashboardOverview(@PathVariable Long serverId) {
        return dashboardService.getDashboardOverview(serverId);
    }
    
    /**
     * 获取控制台显示数据
     * @Title: getDashboardProcesslist   
     * @param serverId
     * @return        
     * @throws
     */
    @RequestMapping(value = "/{serverId}/processlist", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public Object getDashboardProcesslist(@PathVariable Long serverId) {
        return dashboardService.getDashboardProcesslist(serverId);
    }
}
