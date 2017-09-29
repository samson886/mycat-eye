/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  LoginController.java   
 * @Package io.mycat.eye.agent.controller   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年9月20日 上午9:41:03   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mycat.eye.agent.dto.RestResponse;
import io.mycat.eye.agent.service.SysUserService;

/**   
 * @ClassName:  LoginController   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年9月20日 上午9:41:03   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
@RestController
@RequestMapping("/sysuser")
public class SysUserController
{
    @Resource
    private SysUserService sysUserService;
    @RequestMapping("/login")
    @CrossOrigin(origins = "*")
    public RestResponse<String> login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return sysUserService.login(username, password);
    }
    
    @RequestMapping("/modify-password")
    @CrossOrigin(origins = "*")
    public RestResponse<String> modifyPassword(HttpServletRequest request) {
        String username = request.getParameter("username");
        String newPassword = request.getParameter("newPassword");
        return sysUserService.modifyPassword(username, newPassword);
    }
}
