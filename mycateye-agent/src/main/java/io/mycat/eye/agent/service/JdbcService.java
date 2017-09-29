/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  JdbcService.java   
 * @Package cn.bqjr.mysqleye.service   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年4月1日 下午5:19:16   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service;

import java.util.List;
import java.util.Map;

import io.mycat.eye.agent.dto.QueryResult;

/**   
 * @ClassName:  JdbcService   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年4月1日 下午5:19:16   
 *     
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
public interface JdbcService {
	/**
	 * @param user TODO
	 * @param password TODO
	 * 查询数据集
	 * @Title: queryForList   
	 * @param url
	 * @param sql
	 * @return        
	 * @throws
	 */
	public QueryResult<List<Map<Object, Object>>> queryForList(String url, String sql, String user, String password);
	/**
	 * 根据SQL查询记录数
	 * @Title: queryForCount   
	 * @param url
	 * @param sql
	 * @return        
	 * @throws
	 */
	public QueryResult<Integer> queryForCount(String url, String sql);


	/**
	 * 执行sql，返回是否执行成功
	 * @param url
	 * @param sql
	 * @return
	 */
	public QueryResult<Integer> executeSqlForBoolean(String url, String sql);
	
	/**
	 * 执行SQL
	 * @Title: executeSql   
	 * @param url
	 * @param sql        
	 * @throws
	 */
	public void executeSql(String url, String sql);

}
