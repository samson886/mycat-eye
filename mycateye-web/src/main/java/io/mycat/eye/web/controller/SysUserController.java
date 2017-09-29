package io.mycat.eye.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mycat.eye.web.bean.SysUser;
import io.mycat.eye.web.dto.RestResponse;
import io.mycat.eye.web.exception.BusinessException;
import io.mycat.eye.web.service.SysUserService;

@RestController
public class SysUserController {

  @Autowired
  private SysUserService sysUserService;

  /**
   * 登录操作
   */
  @PostMapping("/doLogin")
  public RestResponse login(HttpSession httpSession, String userName, String password) {
    return null;
  }

  /**
   * 登出操作
   */
  @GetMapping("/doLoginOut")
  public RestResponse logout(HttpSession httpSession) {
    return null;
  }

  /**
   * 修改密码
   */
  @PostMapping(value = "/sysUser/password", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public RestResponse changePwd(String oldPwd, String newPwd) {
    return null;
  }

  /**
   * 新增用户
   */
  @PostMapping(value = "/sysUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public RestResponse createUser(String userName, String password) {
    try {
      sysUserService.addUser(userName, password);
      return null;
    } catch (BusinessException ex) {
        return null;
    }
  }

  /**
   * 获取当前用户
   */
  @GetMapping(value = "/sysUser/self")
  public RestResponse currentUser() {
    return null;
  }
}
