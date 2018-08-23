/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  LoginServiceImpl.java   
 * @Package io.mycat.eye.agent.service.impl   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年9月20日 上午9:43:43   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service.impl;

import io.mycat.eye.agent.bean.Constant;
import io.mycat.eye.agent.bean.SysUser;
import io.mycat.eye.agent.bean.SysUserExample;
import io.mycat.eye.agent.bean.SysUserExample.Criteria;
import io.mycat.eye.agent.dto.RestResponse;
import io.mycat.eye.agent.mapper.SysUserMapper;
import io.mycat.eye.agent.service.SysUserService;
import io.mycat.eye.common.util.Md5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**   
 * @ClassName:  LoginServiceImpl   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年9月20日 上午9:43:43   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
@Service
public class SysUserServiceImpl implements SysUserService
{
    @Resource
    private SysUserMapper sysUserMapper;
    
    /* (non-Javadoc)
     * @see io.mycat.eye.agent.service.LoginService#login()
     */
    @Override
    public RestResponse<String> login(String username, String password)
    {
        RestResponse<String> restResponse = new RestResponse<>();
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        if (sysUsers.isEmpty())
        {
            restResponse.setCode(Constant.FAIL_SYS_USER_NOT_EXIST_CODE);
            restResponse.setMessage(Constant.FAIL_SYS_USER_NOT_EXIST_MESSAGE);
        }
        else
        {
            SysUser sysUser = sysUsers.get(0);
            String md5Password = Md5Util.getMd5(password);
            if (sysUser.getPassword().equals(md5Password))
            {
                restResponse.setCode(Constant.SUCCESS_CODE);
                restResponse.setMessage(Constant.SUCCESS_MESSAGE);
                restResponse.setData(username);
            }
            else
            {
                restResponse.setCode(Constant.FAIL_SYS_USER_PASSWORD_ERROR_CODE);
                restResponse.setMessage(Constant.FAIL_SYS_USER_PASSWORD_ERROR_MESSAGE);
            }
        }
        return restResponse;
    }
    
    @Override
    public RestResponse<String> modifyPassword(String username, String newPassword)
    {
        RestResponse<String> restResponse = new RestResponse<>();
        SysUserExample example = new SysUserExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andUsernameEqualTo(username);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        if (list == null || list.isEmpty())
        {
            restResponse.setCode(Constant.FAIL_SYS_USER_NOT_EXIST_CODE);
            restResponse.setMessage(Constant.FAIL_SYS_USER_NOT_EXIST_MESSAGE);
        }
        else
        {
            try
            {
                SysUser sysUser = list.get(0);
                String passwordMD5 = Md5Util.getMd5(newPassword);
                sysUser.setPassword(passwordMD5);
                sysUserMapper.updateByPrimaryKey(sysUser);
                restResponse.setCode(Constant.SUCCESS_CODE);
                restResponse.setMessage(Constant.SUCCESS_MESSAGE);
                restResponse.setData(username);
            }
            catch (Exception e)
            {
                restResponse.setCode(Constant.FAIL_SYS_USER_MODIFY_PASSWORD_ERROR_CODE);
                restResponse.setMessage(Constant.FAIL_SYS_USER_MODIFY_PASSWORD_ERROR_MESSAGE);
            }
        }
        return restResponse;
    }
}
