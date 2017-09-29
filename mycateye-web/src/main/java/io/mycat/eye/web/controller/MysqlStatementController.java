package io.mycat.eye.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import io.mycat.eye.web.bean.Constant;
import io.mycat.eye.web.dto.ExplainResultDto;
import io.mycat.eye.web.dto.RestResponse;
import io.mycat.eye.web.util.AgentUrlUtil;
import io.mycat.eye.web.util.RestTemplateUtils;

/**
 * All rights Reserved, Designed By www.mycat.io
 *
 * @version V1.0
 * @Package www.mycat.io.controller
 * @Description: 开发者工具（SQL监控、慢查询监控）
 * @author: 李平(360841519@qq.com)
 * @date: 2017/5/2  9:23
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved.
 */
@RestController
@RequestMapping("/mysql/statement")
public class MysqlStatementController extends AbstractController
{
    @Autowired
    private AgentUrlUtil agentUrlUtil;
    
    @Autowired
    private RestTemplateUtils restTemplateUtils;
    /**
     * 获取所有sql语句
     * @Title: getAllSqlStatement   
     * @param request
     * @return        
     * @throws
     */
    @RequestMapping("/getAllSqlStatement")
    public String getAllSqlStatement(HttpServletRequest request)
    {
        //请求数据
        Long serverId = Long.valueOf(request.getParameter(SERVER_ID));
        String order = request.getParameter("order");
        String key = request.getParameter("key");
        //封装查询数据及调用查询
        String orderBy = key + " " + order;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("serverId", serverId);
        paramMap.put("orderBy", orderBy);
        String response = restTemplateUtils.get(agentUrlUtil.getStatement(), paramMap);
        //如果请求agent返回值为空
        if (response.isEmpty())
        {
            Map<String, Object> map = new HashMap<>();
            map.put("total", 0);
            map.put("draw", 1);
            map.put("data", new JSONArray());
            map.put("recordsTotal", 0);
            map.put("recordsFiltered", 0);
            return JSONObject.toJSONStringWithDateFormat(map, "yyyy-MM-dd HH:mm:ss");
        }
        //查询结果处理
        JSONArray data = JSON.parseArray(JSON.parseObject(response).getString("data"));
        
        //最多返回100条数据
        int total = 0;
        if (data.size() > 100)
        {
            total = 100;
        }
        else
        {
            total = data.size();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("data", data);
        map.put("recordsTotal", total);
        map.put("recordsFiltered", total);
        return JSONObject.toJSONStringWithDateFormat(map, "yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 获取所有的慢查询sql
     * @Title: getAllSlowSqlStatement   
     * @param request
     * @return        
     * @throws
     */
    @RequestMapping("/getAllSlowSqlStatement")
    public String getAllSlowSqlStatement(HttpServletRequest request)
    {
        Integer draw = Integer.valueOf(request.getParameter("draw"));
        Long serverId = Long.valueOf(request.getParameter("server_id"));
        Integer pageSize = Integer.valueOf(request.getParameter("length"));
        Integer pageIndex = Integer.valueOf(request.getParameter("start"));
        if (pageIndex != 0)
        {
            pageIndex = pageIndex / pageSize;
        }
        String order = request.getParameter("order");
        String key = request.getParameter("key");
        
        //封装查询数据及调用查询
        String orderBy = key + " " + order;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("serverId", serverId);
        paramMap.put("orderBy", orderBy);
        paramMap.put("pageIndex", pageIndex);
        paramMap.put("pageSize", pageSize);
        String response = restTemplateUtils.get(agentUrlUtil.getSlowStatement(), paramMap);
        System.out.println(response);
        //查询结果处理
        JSONArray data =
            JSON.parseArray(JSON.parseObject(JSON.parseObject(response).getString("data")).getString("rows"));
        Integer total = JSON.parseObject(JSON.parseObject(response).getString("data")).getInteger("total");
        
        //最多返回100条数据
        if (total > 100)
        {
            total = 100;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("draw", draw);
        map.put("recordsTotal", total);
        map.put("recordsFiltered", total);
        map.put("data", data);
        return JSONObject.toJSONStringWithDateFormat(map, "yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 获取创建表的语句
     * Get create table string.
     *
     * @param request the request
     * @return the string
     */
    @RequestMapping("/getCreateTable")
    public String getCreateTable(HttpServletRequest request)
    {
        Long serverId = Long.valueOf(request.getParameter("serverId"));
        String schema = request.getParameter("schema");
        String table = request.getParameter("table");
        
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("serverId", serverId);
        paramMap.put("schema", schema);
        paramMap.put("table", table);
        String response = restTemplateUtils.get(agentUrlUtil.getCreateTable(), paramMap);
        return response;
        
    }
    
    /**
     * 获取表的索引
     * Get table index string.
     *
     * @param request the request
     * @return the string
     */
    @RequestMapping("/getTableIndex")
    public String getTableIndex(HttpServletRequest request)
    {
        Long serverId = Long.valueOf(request.getParameter("serverId"));
        String schema = request.getParameter("schema");
        String table = request.getParameter("table");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("serverId", serverId);
        paramMap.put("schema", schema);
        paramMap.put("table", table);
        String response = restTemplateUtils.get(agentUrlUtil.getTableIndex(), paramMap);
        return response;
    }
    
    /**
     * 获取表的状态
     * Get table status string.
     *
     * @param request the request
     * @return the string
     */
    @RequestMapping("/getTableStatus")
    public String getTableStatus(HttpServletRequest request)
    {
        Long serverId = Long.valueOf(request.getParameter("serverId"));
        String schema = request.getParameter("schema");
        String table = request.getParameter("table");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("serverId", serverId);
        paramMap.put("schema", schema);
        paramMap.put("table", table);
        String response = restTemplateUtils.get(agentUrlUtil.getTableStatus(), paramMap);
        return response;
    }
    
    /**
     * sql建议
     * Sql advistor string.
     *
     * @param request the request
     * @return the string
     */
    @RequestMapping("/sql-advisor")
    public String sqlAdvistor(HttpServletRequest request)
    {
        Long serverId = Long.valueOf(request.getParameter("serverId"));
        String schema = request.getParameter("schema");
        String sql = request.getParameter("sql");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("serverId", serverId);
        paramMap.put("schema", schema);
        paramMap.put("sql", sql);
        String response = restTemplateUtils.get(agentUrlUtil.getNewSqlAdvisor(), paramMap);
        System.out.println(response);
        return response;
    }
    
    /**
     * 在线执行SQL语句
     * Execute sql string.
     *
     * @param request the request
     * @return the string
     */
    @RequestMapping("/executeSql")
    public String executeSql(HttpServletRequest request)
    {
        Long serverId = Long.valueOf(request.getParameter(SERVER_ID));
        String schema = request.getParameter("schema");
        String sql = request.getParameter("sql");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("serverId", serverId);
        paramMap.put("schema", schema);
        paramMap.put("sql", sql);
        String response = restTemplateUtils.get(agentUrlUtil.executeSql(), paramMap);
        return response;
    }
    
    @RequestMapping("/explain")
    public RestResponse<Object> explainSql(HttpServletRequest request)
    {
        Long serverId = Long.valueOf(request.getParameter("serverId"));
        String schema = request.getParameter("schema");
        String exeSql = request.getParameter("exeSql");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("serverId", serverId);
        paramMap.put("schema", schema);
        paramMap.put("sql", exeSql);
        String response = restTemplateUtils.get(agentUrlUtil.getMySqlExplain(), paramMap);
        if (response.isEmpty())
        {
            return RestResponse.buildExceptionResponse(Constant.REST_FAIL_CODE,Constant.REST_FAIL_MESSAGE);
        }
        
        RestResponse<Object> restResponse = JSON.parseObject(response, RestResponse.class);
        if (restResponse == null)
        {
            return RestResponse.buildExceptionResponse(Constant.REST_FAIL_CODE,Constant.REST_FAIL_MESSAGE);
        }
        
        if (restResponse.getCode() != Constant.ZERO)
        {
            return restResponse;
        }
        
        restResponse
            .setData(JSONArray.parseArray(((JSONArray)restResponse.getData()).toJSONString(), ExplainResultDto.class));
        return restResponse;
    }
}
