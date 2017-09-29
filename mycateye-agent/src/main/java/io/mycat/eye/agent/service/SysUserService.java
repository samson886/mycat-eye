/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  LoginService.java   
 * @Package io.mycat.eye.agent.service   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年9月20日 上午9:42:52   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service;

import io.mycat.eye.agent.dto.RestResponse;

/**   
 * @ClassName:  LoginService   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年9月20日 上午9:42:52   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public interface SysUserService
{

    /**
     * @param username TODO
     * @param password TODO
     * 登录
     * @Title: login   
     * @return        
     * @throws
     */
    RestResponse<String> login(String username, String password);
    /**
     * 修改密码
     * @Title: modifyPassword   
     * @param username
     * @param newPassword
     * @return        
     * @throws
     */
    RestResponse<String> modifyPassword(String username, String newPassword);
    
}
