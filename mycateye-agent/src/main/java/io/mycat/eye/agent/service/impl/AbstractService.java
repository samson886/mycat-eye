/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  AbstractService.java   
 * @Package cn.bqjr.dbeye.agent.service.impl   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年5月16日 下午5:38:27   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.mycat.eye.agent.bean.Constant;
import io.mycat.eye.agent.bean.MysqlServer;
import io.mycat.eye.agent.bean.MysqlServerExample;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.dto.RestResponse;
import io.mycat.eye.agent.mapper.MysqlServerMapper;
import io.mycat.eye.agent.service.JdbcService;

/**
 * @ClassName: AbstractService
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年5月16日 下午5:38:27
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class AbstractService
{
    // 定义Logger
    protected static Logger logger = null;
    
    // 默认获取记录数
    protected static final Integer DEFAULT_LIMIT = 10;
    
    // 内置数据库
    protected static final String BUILT_IN_SCHEMA = "'information_schema','mysql','performance_schema','sys','test'";
    
    protected static final String MIN_SELECTIVITY="0.1";
    // 数据库操作服务
    @Resource
    protected JdbcService jdbcService;
    
    // MySQL服务器Mapper
    @Resource
    protected MysqlServerMapper mysqlServerMapper;
    
    public AbstractService()
    {
        logger = LoggerFactory.getLogger(getClass().getName());
    }
    
    /**
     * 获取MySQL Server列表 @Title: getMysqlServerList @return @throws
     */
    protected List<MysqlServer> getMysqlServers()
    {
        MysqlServerExample example = new MysqlServerExample();
        List<MysqlServer> mysqlServers = mysqlServerMapper.selectByExample(example);
        
        return mysqlServers;
    }
    
    /**
     * 获取数据源URL @Title: getDataSourceUrl @param host @param port @param
     * schema @param username @param password @return @throws
     */
    protected String getDataSourceUrl(String host, String port, String username, String password)
    {
        String url =
            "jdbc:mysql://" + host + ":" + port + "/?user=" + username + "&password=" + password + "&useSSL=false";
        return url;
    }
    
    protected String getDataSourceUrl(String host, String port, String schema, String username, String password)
    {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + schema + "?user=" + username + "&password=" + password
            + "&useSSL=false";
        return url;
    }
    
    /**
     * 检查返回结果中，是否存在数据操作异常信息 @Title: isJdbcException @param list @return @throws
     */
    protected boolean isJdbcException(List<Map<Object, Object>> list)
    {
        boolean isException = false;
        
        // 如果有数据操作异常，则返回
        for (Map<Object, Object> map : list)
        {
            if (map.containsKey("exception"))
            {
                isException = true;
                
                break;
            }
        }
        
        return isException;
    }
    
    protected QueryResult<List<Map<Object, Object>>> getQueryResult(String host, String port, String sql,
        String username, String password)
    {
        String url = getDataSourceUrl(host, port, username, password);
        QueryResult<List<Map<Object, Object>>> queryResult = jdbcService.queryForList(url, sql, username, password);
        return queryResult;
    }
    
    protected Integer getQueryCount(String host, String port, String sql, String username, String password)
    {
        String url = getDataSourceUrl(host, port, username, password);
        QueryResult<Integer> countQueryResult = jdbcService.queryForCount(url, sql);
        return countQueryResult.getData();
    }
    
    protected QueryResult<List<Map<Object, Object>>> getQueryResult(Long serverId, String sql)
    {
        MysqlServer mysqlServer = getMysqlServerById(serverId);
        String host = mysqlServer.getHost();
        String port = String.valueOf(mysqlServer.getPort());
        String username = mysqlServer.getUsername();
        String password = mysqlServer.getPassword();
        String url = getDataSourceUrl(host, port, username, password);
        QueryResult<List<Map<Object, Object>>> queryResult = jdbcService.queryForList(url, sql, username, password);
        return queryResult;
    }
    
    protected QueryResult<List<Map<Object, Object>>> getQueryResult(Long serverId, String schema, String sql)
    {
        MysqlServer mysqlServer = getMysqlServerById(serverId);
        String host = mysqlServer.getHost();
        String port = String.valueOf(mysqlServer.getPort());
        String username = mysqlServer.getUsername();
        String password = mysqlServer.getPassword();
        String url = getDataSourceUrl(host, port, schema, username, password);
        QueryResult<List<Map<Object, Object>>> queryResult = jdbcService.queryForList(url, sql, username, password);
        return queryResult;
    }
    /**
     * 获取指定MySQL节点上执行sql的结果集
     * @Title: getRestResponse   
     * @param serverId
     * @param sql
     * @return        
     * @throws
     */
    protected RestResponse<Object> getRestResponseBySql(Long serverId,String sql)
    {
        RestResponse<Object> restResponse = new RestResponse<>();
        QueryResult<List<Map<Object, Object>>> queryResult = getQueryResult(serverId, sql);
        //如果数据操作失败则返回
        if (!queryResult.isSuccess())
        {
            restResponse.setCode(Constant.JDBC_ERROR_CODE);
            restResponse.setMessage(queryResult.getException());
            return restResponse;
        }
        List<Map<Object, Object>> list = queryResult.getData();
        if (!list.isEmpty())
        {
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
            restResponse.setData(list);
        }
        else
        {
            restResponse.setCode(Constant.EMPTY_CODE);
            restResponse.setMessage(Constant.EMPTY_MESSAGE);
        }
        return restResponse;
    }
    
    public QueryResult<List<Map<Object, Object>>> getQueryResult(String host, String port, String schema, String sql,
        String username, String password)
    {
        String url = getDataSourceUrl(host, port, schema, username, password);
        QueryResult<List<Map<Object, Object>>> queryResult = jdbcService.queryForList(url, sql, username, password);
        return queryResult;
    }
    
    private MysqlServer getMysqlServerById(Long id)
    {
        MysqlServer mysqlServer = mysqlServerMapper.selectByPrimaryKey(id);
        return mysqlServer;
    }
    
    protected  RestResponse<Object> executeSqlForList(Long serverId, String sql) {
        RestResponse<Object> restResponse = new RestResponse<Object>();
        // 获取MySQL服务器信息
        MysqlServer mysqlServer = mysqlServerMapper.selectByPrimaryKey(serverId);
        String host = mysqlServer.getHost();
        String port = String.valueOf(mysqlServer.getPort());
        String username = mysqlServer.getUsername();
        String password = mysqlServer.getPassword();
        String url = "jdbc:mysql://" + host + ":" + port + "/" + "?user=" + username + "&password=" + password
                + "&useSSL=false";
        QueryResult<List<Map<Object, Object>>> queryResult = jdbcService.queryForList(url, sql, username, password);
        if (queryResult.isSuccess() == false) {
            restResponse.setCode(1);
            restResponse.setMessage(queryResult.getException());
            return restResponse;
        }
        restResponse.setCode(Constant.SUCCESS_CODE);
        restResponse.setMessage("SUCCESS");
        restResponse.setData(queryResult.getData());
        return restResponse;
    }
    
    public  RestResponse<Object> executeSqlForBoolean(Long serverId, String sql) {
        RestResponse<Object> restResponse = new RestResponse<Object>();
        // 获取MySQL服务器信息
        MysqlServer mysqlServer = mysqlServerMapper.selectByPrimaryKey(serverId);
        String host = mysqlServer.getHost();
        String port = String.valueOf(mysqlServer.getPort());
        String username = mysqlServer.getUsername();
        String password = mysqlServer.getPassword();
        String url = "jdbc:mysql://" + host + ":" + port + "/" + "?user=" + username + "&password=" + password
                + "&useSSL=false";
        QueryResult<Integer> queryResult = jdbcService.executeSqlForBoolean(url,sql);
        if (queryResult.isSuccess() == false) {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(queryResult.getException());
            return restResponse;
        }
        restResponse.setCode(Constant.SUCCESS_CODE);
        restResponse.setMessage("SUCCESS");
        restResponse.setData(queryResult.getData());
        return restResponse;
    }
}
