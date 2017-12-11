/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  LoginServiceImpl.java   
 * @Package cn.bqjr.redis.monitor.service.impl   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月5日 下午2:54:53   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import io.mycat.eye.web.bean.SysUser;
import io.mycat.eye.web.bean.SysUserExample;
import io.mycat.eye.web.bean.SysUserExample.Criteria;
import io.mycat.eye.web.dto.RestResponse;
import io.mycat.eye.web.mapper.SysUserMapper;
import io.mycat.eye.web.service.LoginService;
import io.mycat.eye.web.util.Constant;
import io.mycat.eye.web.util.Md5Util;

/**
 * @ClassName: LoginServiceImpl
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年7月5日 下午2:54:53
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private SysUserMapper sysUserMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.bqjr.redis.monitor.service.LoginService#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public RestResponse<String> login(String username, String password) {
		RestResponse<String> restResponse = new RestResponse<>();
		SysUserExample example = new SysUserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsernameEqualTo(username);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if (list == null || list.isEmpty()) {
			restResponse.setCode(Constant.FAIL_SYS_USER_NOT_EXIST_CODE);
			restResponse.setMessage(Constant.FAIL_SYS_USER_NOT_EXIST_MESSAGE);
		} else {
			SysUser sysUser = list.get(0);
			String passwordMD5 = Md5Util.getMd5(password);
			if (passwordMD5.equals(sysUser.getPassword())) {
				restResponse.setCode(Constant.SUCCESS_CODE);
				restResponse.setMessage(Constant.SUCCESS_MESSAGE);
				restResponse.setData(username);
			} else {
				restResponse.setCode(Constant.FAIL_SYS_USER_PASSWORD_ERROR_CODE);
				restResponse.setMessage(Constant.FAIL_SYS_USER_PASSWORD_ERROR_MESSAGE);
			}
		}
		return restResponse;
	}

	@Override
	public RestResponse<String> modifyPassword(String username, String password) {
		RestResponse<String> restResponse = new RestResponse<>();
		SysUserExample example = new SysUserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsernameEqualTo(username);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if (list == null || list.isEmpty()) {
			restResponse.setCode(Constant.FAIL_SYS_USER_NOT_EXIST_CODE);
			restResponse.setMessage(Constant.FAIL_SYS_USER_NOT_EXIST_MESSAGE);
		} else {
			try {
				SysUser sysUser = list.get(0);
				String passwordMD5 = Md5Util.getMd5(password);
				sysUser.setPassword(passwordMD5);
				sysUserMapper.updateByPrimaryKey(sysUser);
				restResponse.setCode(Constant.SUCCESS_CODE);
				restResponse.setMessage(Constant.SUCCESS_MESSAGE);
				restResponse.setData(username);
			} catch (Exception e) {
				restResponse.setCode(Constant.FAIL_SYS_USER_MODIFY_PASSWORD_ERROR_CODE);
				restResponse.setMessage(Constant.FAIL_SYS_USER_MODIFY_PASSWORD_ERROR_MESSAGE);
			}
		}
		return restResponse;
	}

}
