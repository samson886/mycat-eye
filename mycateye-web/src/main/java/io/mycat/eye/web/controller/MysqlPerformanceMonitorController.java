package io.mycat.eye.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import io.mycat.eye.web.service.MysqlStatusHistoryService;

/**
 * All rights Reserved, Designed By www.mycat.io
 *
 * @version V1.0
 * @Package io.mycat.eye.web.controller
 * @Description: Mysql监控Controller
 * @author: 李平(360841519@qq.com)
 * @date: 2017/5/24  9:48
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved.
 */
@RestController
public class MysqlPerformanceMonitorController extends AbstractController
{
    @Autowired
    private MysqlStatusHistoryService mysqlStatusHistoryService;
    
    /**
     * mysql性能监控
     * @Title: performanceMonitor   
     * @param request
     * @return        
     * @throws
     */
    @RequestMapping("/mysql/performance/monitor")
    @CrossOrigin(origins = "*")
    public JSONObject performanceMonitor(HttpServletRequest request)
    {
        //获取请求参数
        Long serverId = Long.valueOf(request.getParameter(SERVER_ID));
        String timeRange = request.getParameter(TIME_RANGE);
        //返回性能图表数据
        return JSON.parseObject(mysqlStatusHistoryService.performanceMonitor(serverId, timeRange));
    }
}
