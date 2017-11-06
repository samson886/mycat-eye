/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  DashboardServiceImpl.java   
 * @Package io.mycat.eye.agent.service.impl   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年9月18日 下午4:58:44   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import io.mycat.eye.agent.bean.Constant;
import io.mycat.eye.agent.bean.MysqlStatusHistory;
import io.mycat.eye.agent.bean.MysqlStatusHistoryExample;
import io.mycat.eye.agent.dto.ChartDataDto;
import io.mycat.eye.agent.dto.DashboardOverview;
import io.mycat.eye.agent.dto.PagedDto;
import io.mycat.eye.agent.dto.Processlist;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MysqlServerMapper;
import io.mycat.eye.agent.mapper.MysqlStatusHistoryMapper;
import io.mycat.eye.agent.service.DashboardService;
import io.mycat.eye.agent.util.MiscUtil;
import io.mycat.eye.agent.util.SysSampleUtil;

/**   
 * @ClassName:  DashboardServiceImpl   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年9月18日 下午4:58:44   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
@Service
public class DashboardServiceImpl extends AbstractService implements DashboardService
{
    @Resource
    private MysqlServerMapper mysqlServerMapper;
    
    @Resource
    private MysqlStatusHistoryMapper mysqlStatusHistoryMapper;
    
    /* (non-Javadoc)
     * @see io.mycat.eye.agent.service.DashboardService#getDashboardOverview(java.lang.Long)
     */
    @Override
    public Object getDashboardOverview(Long serverId)
    {
        DashboardOverview dashboardOverview = getUptimeThreadsInnodbBytes(serverId);
        dashboardOverview = getSchemaTotalDataTotal(dashboardOverview, serverId);
        dashboardOverview = getTableTotal(dashboardOverview, serverId);
        dashboardOverview = getUserTotal(dashboardOverview, serverId);
        dashboardOverview = getQpsChatData(dashboardOverview, serverId);
        dashboardOverview = getQueryChatData(dashboardOverview, serverId);
        return dashboardOverview;
    }
    
    /**
     * 获取查询统计图表信息
     * @Title: getQueryChatData   
     * @param dashboardOverview
     * @param serverId
     * @return        
     * @throws
     */
    private DashboardOverview getQueryChatData(DashboardOverview dashboardOverview, Long serverId)
    {
        String sql =
            "select sum(total) as sum_total,statement from sys.user_summary_by_statement_type t GROUP BY t.statement";
        QueryResult<List<Map<Object, Object>>> queryResult = getQueryResult(serverId, sql);
        if (queryResult.isSuccess())
        {
            List<Map<Object, Object>> resultList = queryResult.getData();
            String[] xAxisData = new String[resultList.size()];
            String[] seriesData = new String[resultList.size()];
            for (int i = 0; i < resultList.size(); i++)
            {
                xAxisData[i] = resultList.get(i).get("statement").toString();
                seriesData[i] = resultList.get(i).get("sum_total").toString();
            }
            ChartDataDto chartDataDto=new ChartDataDto();
            chartDataDto.setxAxisData(xAxisData);
            chartDataDto.setSeriesData(seriesData);
            dashboardOverview.setQueryChartData(chartDataDto);
        }
        else
        {
            logger.error(queryResult.getException());
        }
        return dashboardOverview;
    }
    
    /**
     * 获取30分钟内的QPS图表数据
     * @Title: getQpsChatData   
     * @param dashboardOverview
     * @param serverId
     * @return        
     * @throws
     */
    private DashboardOverview getQpsChatData(DashboardOverview dashboardOverview, Long serverId)
    {
        MysqlStatusHistoryExample example = new MysqlStatusHistoryExample();
        example.setOrderByClause("create_time");
        MysqlStatusHistoryExample.Criteria criteria = example.createCriteria();
        criteria.andServerIdEqualTo(serverId);
        //获取30分钟的数据
        criteria.andCreateTimeBetween(org.apache.commons.lang3.time.DateUtils.addMinutes(new Date(), -180), new Date());
        List<MysqlStatusHistory> selectByExample = mysqlStatusHistoryMapper.selectByExample(example);
        //获取系统采样样本
        List<MysqlStatusHistory> sampleList = SysSampleUtil.getSysSample(selectByExample, Constant.SAMPLE_COUNT);
        List<String> xDataList = new ArrayList<String>();
        //qps
        List<String> qpsDataList = new ArrayList<String>();
        for (MysqlStatusHistory mysqlStatusHistory : sampleList)
        {
            xDataList.add(MiscUtil.getFormatDateTime(mysqlStatusHistory.getCreateTime()));
            qpsDataList.add(mysqlStatusHistory.getQuestionsPersecond());
        }
        String[] xAxisData = new String[xDataList.size()];
        String[] seriesData = new String[xDataList.size()];
        xDataList.toArray(xAxisData);
        qpsDataList.toArray(seriesData);
        ChartDataDto chartDataDto = new ChartDataDto();
        chartDataDto.setxAxisData(xAxisData);
        chartDataDto.setSeriesData(seriesData);
        dashboardOverview.setQpsChartData(chartDataDto);
        return dashboardOverview;
    }
    
    /**
     * 获取user总数
     * @Title: getUserTotal   
     * @param dashboardOverview
     * @param serverId
     * @return        
     * @throws
     */
    private DashboardOverview getUserTotal(DashboardOverview dashboardOverview, Long serverId)
    {
        String sql = "select count(DISTINCT user) as user_total from mysql.user";
        QueryResult<List<Map<Object, Object>>> queryResult = getQueryResult(serverId, sql);
        if (queryResult.isSuccess())
        {
            List<Map<Object, Object>> resultList = queryResult.getData();
            dashboardOverview.setUserTotal(resultList.get(0).get("user_total").toString());
        }
        else
        {
            logger.error(queryResult.getException());
        }
        return dashboardOverview;
    }
    
    /**
     * 获取table总数
     * @Title: getTableTotal   
     * @param dashboardOverview
     * @param serverId
     * @return        
     * @throws
     */
    private DashboardOverview getTableTotal(DashboardOverview dashboardOverview, Long serverId)
    {
        String sql = "SELECT count(DISTINCT TABLE_NAME) as table_total FROM information_schema.TABLES";
        QueryResult<List<Map<Object, Object>>> queryResult = getQueryResult(serverId, sql);
        if (queryResult.isSuccess())
        {
            List<Map<Object, Object>> resultList = queryResult.getData();
            dashboardOverview.setTableTotal(resultList.get(0).get("table_total").toString());
        }
        else
        {
            logger.error(queryResult.getException());
        }
        return dashboardOverview;
    }
    
    /**
     * 查询schema总数/数据总量
     * @Title: getSchemaTotal   
     * @param dashboardOverview
     * @param serverId
     * @return        
     * @throws
     */
    private DashboardOverview getSchemaTotalDataTotal(DashboardOverview dashboardOverview, Long serverId)
    {
        String sql =
            "SELECT round((sum(DATA_LENGTH)+sum(INDEX_LENGTH))/1024/1024,0) as size,TABLE_SCHEMA FROM information_schema.TABLES group by TABLE_SCHEMA";
        QueryResult<List<Map<Object, Object>>> queryResult = getQueryResult(serverId, sql);
        if (queryResult.isSuccess())
        {
            List<Map<Object, Object>> resultList = queryResult.getData();
            int schemaTotal = resultList.size();
            dashboardOverview.setSchemaTotal(String.valueOf(schemaTotal));
            Float dataTotal = 0F;
            for (Map<Object, Object> map : resultList)
            {
                dataTotal += new Float(map.get("size").toString());
            }
            dashboardOverview.setDataTotal(dataTotal.toString() + "MB");
        }
        else
        {
            logger.error(queryResult.getException());
        }
        return dashboardOverview;
    }
    
    private DashboardOverview getUptimeThreadsInnodbBytes(Long serverId)
    {
        String sql =
            "show global status where VARIABLE_NAME in('uptime','Threads_running','Innodb_buffer_pool_pages_free','Innodb_buffer_pool_pages_total','Bytes_received','Bytes_sent')";
        QueryResult<List<Map<Object, Object>>> queryResult = getQueryResult(serverId, sql);
        DashboardOverview dashboardOverview=null;
        if (queryResult.isSuccess())
        {
            dashboardOverview = new DashboardOverview();
            List<Map<Object, Object>> resultList = queryResult.getData();
            Long innodbBufferPoolPagesFree = 0L;
            Long innodbBufferPoolPagesTotal = 0L;
			String Variable_name="VARIABLE_NAME";//"Variable_name";
			String Value="VARIABLE_VALUE";//Value;			
			String Variable=(String)resultList.get(0).get(Variable_name);
			if (Variable==null){
				Variable_name="Variable_name";
				Value="Value";				
			}
            for (Map<Object, Object> map : resultList)
            {
                String variableName = (String)map.get(Variable_name);
                if (variableName.equals("Uptime"))
                {
                    dashboardOverview.setUptime(MiscUtil.getHumanTimeBySeconds(new Long(map.get(Value).toString())));
                }
                if (variableName.equals("Bytes_received"))
                {
                    dashboardOverview
                        .setBytesReceived(MiscUtil.getHumanSizeByBytes(new Long(map.get(Value).toString())));
                }
                if (variableName.equals("Bytes_sent"))
                {
                    dashboardOverview.setBytesSent(MiscUtil.getHumanSizeByBytes(new Long(map.get(Value).toString())));
                }
                if (variableName.equals("Innodb_buffer_pool_pages_free"))
                {
                    innodbBufferPoolPagesFree = new Long(map.get(Value).toString());
                }
                if (variableName.equals("Innodb_buffer_pool_pages_total"))
                {
                    innodbBufferPoolPagesTotal = new Long(map.get(Value).toString());
                }
                if (variableName.equals("Threads_running"))
                {
                    dashboardOverview.setThreadsRunning((String)map.get(Value));
                }
            }
            dashboardOverview.setInnoDBBufferPoolSize(MiscUtil
                .getPercentage((innodbBufferPoolPagesTotal - innodbBufferPoolPagesFree), innodbBufferPoolPagesTotal));
        }
        else
        {
            logger.error(queryResult.getException());
        }
        return dashboardOverview;
    }
    
    /* (non-Javadoc)
     * @see io.mycat.eye.agent.service.DashboardService#getDashboardProcesslist(java.lang.Long)
     */
    @Override
    public PagedDto<Processlist> getDashboardProcesslist(Long serverId)
    {
        PagedDto<Processlist> pagedDto=null;
        String sql="show processlist";
        QueryResult<List<Map<Object, Object>>> queryResult = getQueryResult(serverId, sql);
        if (queryResult.isSuccess())
        {
            List<Map<Object,Object>> resultList = queryResult.getData();
            List<Processlist> processlists=new ArrayList<>();
            for (Map<Object, Object> map : resultList)
            {
                Processlist processlist=new Processlist();
                processlist.setCommand(map.get("Command")==null?"":map.get("Command").toString());
                processlist.setDb(map.get("db")==null?"":map.get("db").toString());
                processlist.setHost(map.get("Host")==null?"":map.get("Host").toString());
                processlist.setId(map.get("Id")==null?"":map.get("Id").toString());
                processlist.setInfo(map.get("Info")==null?"":map.get("Info").toString());
                processlist.setState(map.get("State")==null?"":map.get("State").toString());
                processlist.setTime(map.get("Time")==null?"":map.get("Time").toString());
                processlist.setUser(map.get("User")==null?"":map.get("User").toString());
                processlists.add(processlist);
            }
            pagedDto=new PagedDto<>();
            pagedDto.setDraw(Constant.DEFAULT_DRAW);
            pagedDto.setRecordsFiltered(resultList.size());
            pagedDto.setRecordsTotal(resultList.size());
            pagedDto.setData(processlists);
        }
        else
        {
            logger.error(queryResult.getException());
        }
        return pagedDto;
    }
    
}
