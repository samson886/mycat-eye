/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  LoginService.java   
 * @Package cn.bqjr.redis.monitor.service   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月5日 下午2:53:38   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.web.service;

import io.mycat.eye.web.dto.RestResponse;

/**
 * @ClassName: LoginService
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年7月5日 下午2:53:38
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public interface LoginService {
    /**
     * 登录验证
     * @Title: login   
     * @param username
     * @param password
     * @return        
     * @throws
     */
    public RestResponse<String> login(String username, String password);
    
    /**
     * 修改密码
     * @Title: modifyPassword   
     * @param username
     * @param password
     * @return        
     * @throws
     */
    public RestResponse<String> modifyPassword(String username, String password);
}
