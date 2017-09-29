package io.mycat.eye.web.dto;

/**
 * @ClassName: MyCnfGenerateSettingsDto
 * @Description:配置文件对象
 * @author: 李平(360841519@qq.com)
 * @date: 2017年3月20日 上午10:16:50
 * 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved.
 */
public class MyCnfGenerateSettingsDto
{
    
    /**
     * MySQL数据库服务器主机名
     */
    private String serverHostName;
    
    /**
     * MySQL数据库ServerId
     */
    private String serverId;
    
    /**
     * 服务器物理内存（单位G）
     */
    private Integer physicalMemory;
    
    /**
     * MySQL安装路径
     */
    private String installPath;
    
    /**
     * MySQL数据文件路径
     */
    private String dataFilePath;
    
    /**
     * MySQL监听的端口
     */
    private Integer listenPort;
    
    /**
     * 该实例预计最大并发连接数
     */
    private Integer expectedMaxConnect;
    
    /**
     * binlog保留多久(单位：天)
     */
    private Integer binlogExpireDays;
    
    /**
     * 排序，表连接等查询是否较多
     */
    private Boolean sortAndJoinQuery;
    
    /**
     * MySQL异常宕机时，不丢失数据
     */
    private Boolean recoverData;
    
    public String getServerHostName()
    {
        return serverHostName;
    }
    
    public void setServerHostName(String serverHostName)
    {
        this.serverHostName = serverHostName;
    }
    
    public String getServerId()
    {
        return serverId;
    }
    
    public void setServerId(String serverId)
    {
        this.serverId = serverId;
    }
    
    public Integer getPhysicalMemory()
    {
        return physicalMemory;
    }
    
    public void setPhysicalMemory(Integer physicalMemory)
    {
        this.physicalMemory = physicalMemory;
    }
    
    public String getInstallPath()
    {
        return installPath;
    }
    
    public void setInstallPath(String installPath)
    {
        this.installPath = installPath;
    }
    
    public String getDataFilePath()
    {
        return dataFilePath;
    }
    
    public void setDataFilePath(String dataFilePath)
    {
        this.dataFilePath = dataFilePath;
    }
    
    public Integer getListenPort()
    {
        return listenPort;
    }
    
    public void setListenPort(Integer listenPort)
    {
        this.listenPort = listenPort;
    }
    
    public Integer getExpectedMaxConnect()
    {
        return expectedMaxConnect;
    }
    
    public void setExpectedMaxConnect(Integer expectedMaxConnect)
    {
        this.expectedMaxConnect = expectedMaxConnect;
    }
    
    public Integer getBinlogExpireDays()
    {
        return binlogExpireDays;
    }
    
    public void setBinlogExpireDays(Integer binlogExpireDays)
    {
        this.binlogExpireDays = binlogExpireDays;
    }
    
    public Boolean getSortAndJoinQuery()
    {
        return sortAndJoinQuery;
    }
    
    public void setSortAndJoinQuery(Boolean sortAndJoinQuery)
    {
        this.sortAndJoinQuery = sortAndJoinQuery;
    }
    
    public Boolean getRecoverData()
    {
        return recoverData;
    }
    
    public void setRecoverData(Boolean recoverData)
    {
        this.recoverData = recoverData;
    }
}
