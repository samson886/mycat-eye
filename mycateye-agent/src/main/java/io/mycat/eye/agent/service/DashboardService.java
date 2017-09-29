/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  DashboardService.java   
 * @Package io.mycat.eye.agent.service   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年9月18日 下午4:57:31   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service;

import io.mycat.eye.agent.dto.PagedDto;
import io.mycat.eye.agent.dto.Processlist;

/**   
 * @ClassName:  DashboardService   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年9月18日 下午4:57:31   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public interface DashboardService
{
    /**
     * 获取控制台概要信息
     * @Title: getDashboardOverview   
     * @param serverId
     * @return        
     * @throws
     */
    public Object getDashboardOverview(Long serverId);
    /**
     * 获取控制台显示数据
     * @Title: getDashboardProcesslist   
     * @param serverId
     * @return        
     * @throws
     */
    public PagedDto<Processlist> getDashboardProcesslist(Long serverId);
}
