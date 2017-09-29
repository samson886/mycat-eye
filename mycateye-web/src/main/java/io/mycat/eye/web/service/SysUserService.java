package io.mycat.eye.web.service;

import io.mycat.eye.web.bean.SysUser;

/**
 * 用户信息维护
 * Created by BQ0082 on 2017/3/31.
 */
public interface SysUserService {
    SysUser addUser(String userName, String password);

    boolean checkUser(String userName, String password);

    void delUser(String userName);

    boolean changePassword(String userName, String oldPwd, String newPwd);

    SysUser getUser(String userName);
}
