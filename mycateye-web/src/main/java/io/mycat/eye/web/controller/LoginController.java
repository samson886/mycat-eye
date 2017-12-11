/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  LoginController.java   
 * @Package cn.org.openwork.nosql.controller   
 * @Description:    登录Controller 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月4日 下午5:26:08   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mycat.eye.web.service.LoginService;


/**   
 * @ClassName:  LoginController   
 * @Description:登录Controller 
 * @author: 李平(360841519@qq.com)
 * @date:   2017年7月4日 下午5:26:08   
 *     
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
@RestController
@RequestMapping(value = "/api")
public class LoginController
{
    @Resource
    private LoginService loginService;
    
    /**
     * 登录
     * @Title: login   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/login")
    public Object login(HttpServletRequest request, HttpServletResponse response)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return loginService.login(username, password);
    }
    
    /**
     * 修改密码
     * @Title: modifyPassword   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/modify-password")
    public Object modifyPassword(HttpServletRequest request, HttpServletResponse response)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return loginService.modifyPassword(username, password);
    }
}
