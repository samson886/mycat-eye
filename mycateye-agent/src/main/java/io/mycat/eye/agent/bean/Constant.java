/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  Constant.java   
 * @Package cn.bqjr.redis.agent.bean   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年6月28日 下午2:35:12   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.agent.bean;

/**
 * @ClassName: Constant
 * @Description:常量
 * @author: 李平(360841519@qq.com)
 * @date: 2017年6月28日 下午2:35:12
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class Constant {
    public static final Long ZERO = 0L;
    public static final String SUCCESS_CODE_ZERO = "0";
    public static final Integer SUCCESS_CODE = 200;
    public static final String SUCCESS_MESSAGE = "SUCCESS";
    
    public static final Integer FAIL_CODE = 201;
    public static final String FAIL_MESSAGE = "FAIL";
    
    public static final Integer EMPTY_CODE = 202;
    public static final String EMPTY_MESSAGE = "EMPTY";
    
    public static final Integer MYSQL_SERVER_NOT_EXIST_CODE = 203;
    public static final String MYSQL_SERVER_NOT_EXIST_MESSAGE = "MYSQL_SERVER_NOT_EXIST";
    
    public static final Integer NOT_EXIST_WEAK_PASSWORD_CODE = 204;
    public static final String NOT_EXIST_WEAK_PASSWORD_MESSAGE = "NOT_EXIST_WEAK_PASSWORD";
    
    public static final Integer REST_FAIL_CODE = 205;
    public static final String REST_FAIL_MESSAGE = "接口调用失败";
    
    public static final Integer JDBC_ERROR_CODE = 206;
    public static final String JDBC_ERROR_MESSAGE = "JDBC_ERROR_MESSAGE";
    
    public static final String ABNORMAL="异常";
    
    public static final String OK="OK";
    
    public final static int SAMPLE_COUNT = 100;
    
    public static final Integer DEFAULT_DRAW = 1;
    
    public static final Integer FAIL_SYS_USER_NOT_EXIST_CODE = 207;
    public static final String FAIL_SYS_USER_NOT_EXIST_MESSAGE = "用户不存在";
    
    public static final Integer FAIL_SYS_USER_PASSWORD_ERROR_CODE = 208;
    public static final String FAIL_SYS_USER_PASSWORD_ERROR_MESSAGE = "用户密码错误";
    
    public static final Integer FAIL_SYS_USER_MODIFY_PASSWORD_ERROR_CODE = 209;
    public static final String FAIL_SYS_USER_MODIFY_PASSWORD_ERROR_MESSAGE = "用户密码修改错误";
}
