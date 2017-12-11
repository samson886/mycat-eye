/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  Constant.java   
 * @Package cn.bqjr.mysqleye.util   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年3月21日 下午4:59:26   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.web.util;

/**   
 * @ClassName:  Constant   
 * @Description:常量
 * @author: 李平(360841519@qq.com)
 * @date:   2017年3月21日 下午4:59:26   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public class Constant {
	public static final String ERROR = "error";
	
	public static final String STATUS_UNKNOWN = "未知";
	
	
	public static final Long ZERO = 0L;
    public static final String STRING_ZERO = "0";
    public static final Integer SUCCESS_CODE = 200;
    public static final String SUCCESS_MESSAGE = "SUCCESS";
    
    public static final Integer FAIL_CODE = 201;
    public static final String FAIL_MESSAGE = "FAIL";
    
    public static final Integer FAIL_REDIS_CONN_CODE = 202;
    public static final String FAIL_REDIS_CONN_MESSAGE = "Redis连接失败";
    
    public static final Integer FAIL_REDIS_EXIST_CODE = 203;
    public static final String FAIL_REDIS_EXIST_MESSAGE = "Redis节点已经存在";
    
    public static final Integer FAIL_SYS_USER_NOT_EXIST_CODE = 204;
    public static final String FAIL_SYS_USER_NOT_EXIST_MESSAGE = "用户不存在";
    
    public static final Integer FAIL_SYS_USER_PASSWORD_ERROR_CODE = 205;
    public static final String FAIL_SYS_USER_PASSWORD_ERROR_MESSAGE = "用户密码错误";
    
    public static final Integer FAIL_SYS_USER_MODIFY_PASSWORD_ERROR_CODE = 206;
    public static final String FAIL_SYS_USER_MODIFY_PASSWORD_ERROR_MESSAGE = "用户密码修改错误";
    
    public static final String REDIS_PONG = "PONG";
    
    public static final String REDIS_MASTER = "master";
    
    public static final String REDIS_SLAVE = "slave";
    
    public static final String REDIS_DISCONNECTED = "DISCONNECTED";
    
    public static final int REDIS_MAX_DISCONNECT_COUNT=3;
    
    public static final String MYSQL = "mysql";
    public static final String REDIS = "redis";
    public static final String MONGODB = "mongodb";
    
    public static final Long REALERT_SECONDS_LATER=600L;
    
    public static final String ABNORMAL="异常";
    
    public static final String OK="OK";
    
    public static final int SAMPLE_COUNT=200;
    public static final Integer DEFAULT_MAX_KEYS_COUNT = 100;
}
