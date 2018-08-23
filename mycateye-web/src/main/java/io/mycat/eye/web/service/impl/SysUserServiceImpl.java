package io.mycat.eye.web.service.impl;

import io.mycat.eye.common.util.Md5Util;
import io.mycat.eye.web.bean.SysUser;
import io.mycat.eye.web.bean.SysUserExample;
import io.mycat.eye.web.exception.BusinessException;
import io.mycat.eye.web.exception.sys.user.SysUserExceptionEnum;
import io.mycat.eye.web.mapper.SysUserMapper;
import io.mycat.eye.web.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by BQ0082 on 2017/3/31.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

  @Autowired
  private SysUserMapper sysUserMapper;

  @Override
  @Transactional
  public SysUser addUser(String userName, String password) {
    SysUser user = createNew(userName, password);
    SysUser oldUser = getUser(userName);
    if (oldUser != null) {
      throw new BusinessException(SysUserExceptionEnum.USER_ALREADY_EXISTS);
    }
    sysUserMapper.insertSelective(user);
    return user;
  }

  @Override
  public boolean checkUser(String userName, String password) {
    SysUser user = getUser(userName);
    return user == null ? false : checkPassword(user, password);
  }

  @Override
  @Transactional
  public void delUser(String userName) {
    SysUserExample example = new SysUserExample();
    example.createCriteria().andUsernameEqualTo(userName);
    sysUserMapper.deleteByExample(example);
  }

  @Override
  @Transactional
  public boolean changePassword(String userName, String oldPwd, String newPwd) {
    SysUser user = getUser(userName);
    if (user == null) {
      throw new BusinessException(SysUserExceptionEnum.USER_NOT_EXISTS);
    }
    changePassword(user, oldPwd, newPwd);
    sysUserMapper.updateByPrimaryKeySelective(user);
    return true;
  }

  @Override
  public SysUser getUser(String userName) {
    SysUserExample example = new SysUserExample();
    example.createCriteria().andUsernameEqualTo(userName);
    List<SysUser> users = sysUserMapper.selectByExample(example);
    return users.isEmpty() ? null : users.get(0);
  }

  /**
   * 创建新用户
   */
  private SysUser createNew(String userName, String password){
    if (StringUtils.isEmpty(userName)) {
      throw new BusinessException(SysUserExceptionEnum.USER_NAME_NOT_NULL);
    }
    if (StringUtils.isEmpty(password)) {
      throw new BusinessException(SysUserExceptionEnum.PASSWORD_NOT_NULL);
    }

    SysUser sysUser = new SysUser();
    sysUser.setUsername(userName);
    sysUser.setPassword(Md5Util.getMd5(password));
    Date now = new Date();
    sysUser.setCreateTime(now);
    sysUser.setModifyTime(now);
    return sysUser;
  }

  /**
   * 检查密码
   */
  private boolean checkPassword(SysUser user, String password) {
    if (StringUtils.isEmpty(password)) {
      throw new BusinessException(SysUserExceptionEnum.PASSWORD_NOT_NULL);
    }
    return user.getPassword().equals(Md5Util.getMd5(password));
  }

  /**
   * 修改密码
   */
  private void changePassword(SysUser user, String oldPwd, String newPwd) {
    if (StringUtils.isEmpty(oldPwd) || StringUtils.isEmpty(newPwd)) {
      throw new BusinessException(SysUserExceptionEnum.PASSWORD_NOT_NULL);
    }

    if (!checkPassword(user, oldPwd)) {
      throw new BusinessException(SysUserExceptionEnum.PASSWORD_VERIFY_FAIL);
    }

    user.setPassword(Md5Util.getMd5(newPwd));
    user.setModifyTime(new Date());
  }
}
