/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  DashboardOverview.java   
 * @Package io.mycat.eye.agent.dto   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年9月18日 下午5:03:18   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.dto;

/**   
 * @ClassName:  DashboardOverview   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年9月18日 下午5:03:18   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public class DashboardOverview
{
    private String uptime;
    private String threadsRunning;
    private String dataTotal;
    private String innoDBBufferPoolSize;
    private ChartDataDto qpsChartData;
    private ChartDataDto queryChartData;
    private String bytesReceived;
    private String bytesSent;
    private String schemaTotal;
    private String tableTotal;
    private String userTotal;
    private String binlogTotal;
    /**
     * @return the uptime
     */
    public String getUptime()
    {
        return uptime;
    }
    /**
     * @param uptime the uptime to set
     */
    public void setUptime(String uptime)
    {
        this.uptime = uptime;
    }
    /**
     * @return the threadsRunning
     */
    public String getThreadsRunning()
    {
        return threadsRunning;
    }
    /**
     * @param threadsRunning the threadsRunning to set
     */
    public void setThreadsRunning(String threadsRunning)
    {
        this.threadsRunning = threadsRunning;
    }
    /**
     * @return the dataTotal
     */
    public String getDataTotal()
    {
        return dataTotal;
    }
    /**
     * @param dataTotal the dataTotal to set
     */
    public void setDataTotal(String dataTotal)
    {
        this.dataTotal = dataTotal;
    }
    /**
     * @return the innoDBBufferPoolSize
     */
    public String getInnoDBBufferPoolSize()
    {
        return innoDBBufferPoolSize;
    }
    /**
     * @param innoDBBufferPoolSize the innoDBBufferPoolSize to set
     */
    public void setInnoDBBufferPoolSize(String innoDBBufferPoolSize)
    {
        this.innoDBBufferPoolSize = innoDBBufferPoolSize;
    }
    
    /**
     * @return the qpsChartData
     */
    public ChartDataDto getQpsChartData()
    {
        return qpsChartData;
    }
    /**
     * @param qpsChartData the qpsChartData to set
     */
    public void setQpsChartData(ChartDataDto qpsChartData)
    {
        this.qpsChartData = qpsChartData;
    }
    /**
     * @return the queryChartData
     */
    public ChartDataDto getQueryChartData()
    {
        return queryChartData;
    }
    /**
     * @param queryChartData the queryChartData to set
     */
    public void setQueryChartData(ChartDataDto queryChartData)
    {
        this.queryChartData = queryChartData;
    }
    /**
     * @return the bytesReceived
     */
    public String getBytesReceived()
    {
        return bytesReceived;
    }
    /**
     * @param bytesReceived the bytesReceived to set
     */
    public void setBytesReceived(String bytesReceived)
    {
        this.bytesReceived = bytesReceived;
    }
    /**
     * @return the bytesSent
     */
    public String getBytesSent()
    {
        return bytesSent;
    }
    /**
     * @param bytesSent the bytesSent to set
     */
    public void setBytesSent(String bytesSent)
    {
        this.bytesSent = bytesSent;
    }
    /**
     * @return the schemaTotal
     */
    public String getSchemaTotal()
    {
        return schemaTotal;
    }
    /**
     * @param schemaTotal the schemaTotal to set
     */
    public void setSchemaTotal(String schemaTotal)
    {
        this.schemaTotal = schemaTotal;
    }
    /**
     * @return the tableTotal
     */
    public String getTableTotal()
    {
        return tableTotal;
    }
    /**
     * @param tableTotal the tableTotal to set
     */
    public void setTableTotal(String tableTotal)
    {
        this.tableTotal = tableTotal;
    }
    /**
     * @return the userTotal
     */
    public String getUserTotal()
    {
        return userTotal;
    }
    /**
     * @param userTotal the userTotal to set
     */
    public void setUserTotal(String userTotal)
    {
        this.userTotal = userTotal;
    }
    /**
     * @return the binlogTotal
     */
    public String getBinlogTotal()
    {
        return binlogTotal;
    }
    /**
     * @param binlogTotal the binlogTotal to set
     */
    public void setBinlogTotal(String binlogTotal)
    {
        this.binlogTotal = binlogTotal;
    }
    
}
