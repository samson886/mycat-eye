/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  SqlExplainService.java   
 * @Package cn.bqjr.dbeye.service
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年4月19日 下午5:42:46   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service;

/**
 * @ClassName: SqlExplainService
 * @Description:执行计划service
 * @author: 李平(360841519@qq.com)
 * @date: 2017年4月19日 下午5:42:46
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public interface StatementService {
    Object getExplain(Long serverId, String schema, String sql);

    Object getTables(Long serverId, String statementExample);

    Object getShowCreateTable(Long serverId, String schema, String tableName);

    Object getShowIndexFromTable(Long serverId, String schema, String tableName);

    Object getStatementHistory(Long serverId, String orderBy);

    Object getShowTableStatus(Long serverId, String schema, String table);

    Object executeSql(Long serverId, String schema, String sql);

    Object getStatementSlow(Long serverId, String orderBy, Integer pageIndex, Integer pageSize);
}
