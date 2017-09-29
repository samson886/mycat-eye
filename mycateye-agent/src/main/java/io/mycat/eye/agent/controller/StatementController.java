package io.mycat.eye.agent.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mycat.eye.agent.service.StatementService;

@RestController
@RequestMapping("/statement")
public class StatementController
{
    @Resource
    private StatementService statementService;
    
    /**
     * 获取近期SQL语句
     * @Title: getStatementHistory   
     * @param serverId
     * @param orderBy
     * @return        
     * @throws
     */
    @RequestMapping(value = "/history/{serverId}/{orderBy}", method = {RequestMethod.POST, RequestMethod.GET})
    public Object getStatementHistory(@PathVariable Long serverId, @PathVariable String orderBy)
    {
        return statementService.getStatementHistory(serverId, orderBy);
    }
    
    /**
     * 获取慢查询SQL语句
     * @Title: getStatementSlow   
     * @param serverId
     * @param orderBy
     * @param pageIndex
     * @param pageSize
     * @return        
     * @throws
     */
    @RequestMapping(value = "/slow/{serverId}/{orderBy}/{pageIndex}/{pageSize}", method = {RequestMethod.POST,
        RequestMethod.GET})
    public Object getStatementSlow(@PathVariable Long serverId, @PathVariable String orderBy,
        @PathVariable Integer pageIndex, @PathVariable Integer pageSize)
    {
        return statementService.getStatementSlow(serverId, orderBy, pageIndex, pageSize);
    }
    
    /**
     * 获取对应数据库表的建表语句
     * @Title: getShowCreateTable   
     * @param serverId
     * @param schema
     * @param table
     * @return        
     * @throws
     */
    @RequestMapping(value = "/show-create-table/{serverId}/{schema}/{table}", method = {RequestMethod.POST,
        RequestMethod.GET})
    public Object getShowCreateTable(@PathVariable Long serverId, @PathVariable String schema,
        @PathVariable String table)
    {
        return statementService.getShowCreateTable(serverId, schema, table);
    }
    
    /**
     * 获取对应数据库表的状态信息
     * @Title: getShowTableStatus   
     * @param serverId
     * @param schema
     * @param table
     * @return        
     * @throws
     */
    @RequestMapping(value = "/show-table-status/{serverId}/{schema}/{table}", method = {RequestMethod.POST,
        RequestMethod.GET})
    public Object getShowTableStatus(@PathVariable Long serverId, @PathVariable String schema,
        @PathVariable String table)
    {
        return statementService.getShowTableStatus(serverId, schema, table);
    }
    
    /**
     * 获取对应数据库表的索引信息
     * @Title: getShowIndexFromTable   
     * @param serverId
     * @param schema
     * @param table
     * @return        
     * @throws
     */
    @RequestMapping(value = "/show-index-from-table/{serverId}/{schema}/{table}", method = {RequestMethod.POST,
        RequestMethod.GET})
    public Object getShowIndexFromTable(@PathVariable Long serverId, @PathVariable String schema,
        @PathVariable String table)
    {
        return statementService.getShowIndexFromTable(serverId, schema, table);
    }
    
    /**
     * 执行sql
     * @Title: executeSql   
     * @param request
     * @return        
     * @throws
     */
    @RequestMapping(value = "/execute", method = {RequestMethod.POST, RequestMethod.GET})
    public Object executeSql(HttpServletRequest request)
    {
        Long serverId = Long.valueOf(request.getParameter("serverId"));
        String schema = request.getParameter("schema");
        String sql = request.getParameter("sql");
        return statementService.executeSql(serverId, schema, sql);
    }
}
