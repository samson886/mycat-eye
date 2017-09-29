/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  SuggestionServiceImpl.java   
 * @Package cn.bqjr.dbeye.agent.service.impl   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年5月11日 上午11:38:06   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import io.mycat.eye.agent.bean.MysqlServer;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.dto.RestResponse;
import io.mycat.eye.agent.dto.Suggestion;
import io.mycat.eye.agent.mapper.MysqlServerMapper;
import io.mycat.eye.agent.service.JdbcService;
import io.mycat.eye.agent.service.SuggestionService;

/**
 * @ClassName: SuggestionServiceImpl
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年5月11日 上午11:38:06
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
@Service
public class SuggestionServiceImpl implements SuggestionService
{
    @Resource
    private MysqlServerMapper mysqlServerMapper;
    
    @Resource
    protected JdbcService jdbcService;
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.bqjr.dbeye.agent.service.SuggestionService#getSuggestion(java.lang.
     * Long)
     */
    @Override
    public Object getSuggestion(Long serverId)
    {
        RestResponse<List<Suggestion>> restResponse = new RestResponse<List<Suggestion>>();
        List<Suggestion> suggestions = new ArrayList<Suggestion>();
        // 获取目标MySQL节点信息
        MysqlServer mysqlServer = mysqlServerMapper.selectByPrimaryKey(serverId);
        if (mysqlServer == null)
        {
            restResponse.setMessage("mysqlServer is null");
            restResponse.setCode(1);
            return restResponse;
        }
        // 获取慢查询数量占比建议
        Suggestion suggestionSlowQueries = getSuggestionBySlowQueries(mysqlServer);
        suggestions.add(suggestionSlowQueries);
        restResponse.setCode(0);
        restResponse.setMessage("success");
        restResponse.setData(suggestions);
        return restResponse;
    }
    
    /**
     * 获取慢查询数量占比建议 @Title: getSuggestionBySlowQueries @param
     * mysqlServer @return @throws
     */
    private Suggestion getSuggestionBySlowQueries(MysqlServer mysqlServer)
    {
        QueryResult<List<Map<Object, Object>>> queryResult = getAllStatus(mysqlServer);
        List<Map<Object, Object>> statusList = queryResult.getData();
        String slowQueries = getStatusValueByVariableName(statusList, "Slow_queries");
        String questions = getStatusValueByVariableName(statusList, "Questions");
        long value = new BigDecimal(slowQueries).divide(new BigDecimal(questions), 2, BigDecimal.ROUND_HALF_UP)
            .multiply(new BigDecimal("100"))
            .longValue();
        Suggestion suggestion = new Suggestion();
        suggestion.setProblem("value:" + value);
        return suggestion;
    }
    
    /**
     * 获取当前状态的所有指标 @Title: getAllStatus @param mysqlServer @return @throws
     */
    private QueryResult<List<Map<Object, Object>>> getAllStatus(MysqlServer mysqlServer)
    {
        String host = mysqlServer.getHost();
        String port = String.valueOf(mysqlServer.getPort());
        String username = mysqlServer.getUsername();
        String password = mysqlServer.getPassword();
        String sql = "show status";
        return getQueryResult(host, port, sql, username, password);
    }
    
    /**
     * 获取查询结果集 @Title: getQueryResult @param host @param port @param sql @param
     * username @param password @return @throws
     */
    private QueryResult<List<Map<Object, Object>>> getQueryResult(String host, String port, String sql, String username,
        String password)
    {
        String dataSourceUrl =
            "jdbc:mysql://" + host + ":" + port + "?user=" + username + "&password=" + password + "&useSSL=false";
        QueryResult<List<Map<Object, Object>>> queryResult =
            jdbcService.queryForList(dataSourceUrl, sql, username, password);
        
        return queryResult;
    }
    
    /**
     * 根据变量名获取变量值 @Title: getStatusValueByVariableName @param statusList @param
     * variableName @return @throws
     */
    private String getStatusValueByVariableName(List<Map<Object, Object>> statusList, String variableName)
    {
        String value = "";
        for (Map<Object, Object> map : statusList)
        {
            String vName = (String)map.get("Variable_name");
            if (vName.equals(variableName))
            {
                value = (String)map.get("Value");
                break;
            }
        }
        return value;
    }
}
