/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  MysqlOverview.java   
 * @Package io.mycat.eye.agent.dto   
 * @Description:    MySQL节点概要信息
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月17日 下午3:38:31   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.dto;

/**   
 * @ClassName:  MysqlOverview   
 * @Description:MySQL节点概要信息
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月17日 下午3:38:31   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public class MysqlOverview
{
    private Long id;
    
    private String host;
    
    private Integer port;
    
    private String tags;
    
    private String basedir;
    
    private String datadir;
    
    private String generalLog;
    
    private String generalLogFile;
    
    private String innodbBufferPoolSize;
    
    private String logError;
    
    private String slowQueryLog;
    
    private String slowQueryLogFile;
    
    private String version;
    
    private String performanceSchema;
    
    private String characterSetDatabase;
    
    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }
    
    /**
     * @return the host
     */
    public String getHost()
    {
        return host;
    }
    
    /**
     * @param host the host to set
     */
    public void setHost(String host)
    {
        this.host = host;
    }
    
    /**
     * @return the port
     */
    public Integer getPort()
    {
        return port;
    }
    
    /**
     * @param port the port to set
     */
    public void setPort(Integer port)
    {
        this.port = port;
    }
    
    /**
     * @return the tags
     */
    public String getTags()
    {
        return tags;
    }
    
    /**
     * @param tags the tags to set
     */
    public void setTags(String tags)
    {
        this.tags = tags;
    }
    
    /**
     * @return the basedir
     */
    public String getBasedir()
    {
        return basedir;
    }
    
    /**
     * @param basedir the basedir to set
     */
    public void setBasedir(String basedir)
    {
        this.basedir = basedir;
    }
    
    /**
     * @return the datadir
     */
    public String getDatadir()
    {
        return datadir;
    }
    
    /**
     * @param datadir the datadir to set
     */
    public void setDatadir(String datadir)
    {
        this.datadir = datadir;
    }
    
    /**
     * @return the generalLog
     */
    public String getGeneralLog()
    {
        return generalLog;
    }
    
    /**
     * @param generalLog the generalLog to set
     */
    public void setGeneralLog(String generalLog)
    {
        this.generalLog = generalLog;
    }
    
    /**
     * @return the generalLogFile
     */
    public String getGeneralLogFile()
    {
        return generalLogFile;
    }
    
    /**
     * @param generalLogFile the generalLogFile to set
     */
    public void setGeneralLogFile(String generalLogFile)
    {
        this.generalLogFile = generalLogFile;
    }
    
    /**
     * @return the innodbBufferPoolSize
     */
    public String getInnodbBufferPoolSize()
    {
        return innodbBufferPoolSize;
    }
    
    /**
     * @param innodbBufferPoolSize the innodbBufferPoolSize to set
     */
    public void setInnodbBufferPoolSize(String innodbBufferPoolSize)
    {
        this.innodbBufferPoolSize = innodbBufferPoolSize;
    }
    
    /**
     * @return the logError
     */
    public String getLogError()
    {
        return logError;
    }
    
    /**
     * @param logError the logError to set
     */
    public void setLogError(String logError)
    {
        this.logError = logError;
    }
    
    /**
     * @return the slowQueryLog
     */
    public String getSlowQueryLog()
    {
        return slowQueryLog;
    }
    
    /**
     * @param slowQueryLog the slowQueryLog to set
     */
    public void setSlowQueryLog(String slowQueryLog)
    {
        this.slowQueryLog = slowQueryLog;
    }
    
    /**
     * @return the slowQueryLogFile
     */
    public String getSlowQueryLogFile()
    {
        return slowQueryLogFile;
    }
    
    /**
     * @param slowQueryLogFile the slowQueryLogFile to set
     */
    public void setSlowQueryLogFile(String slowQueryLogFile)
    {
        this.slowQueryLogFile = slowQueryLogFile;
    }
    
    /**
     * @return the version
     */
    public String getVersion()
    {
        return version;
    }
    
    /**
     * @param version the version to set
     */
    public void setVersion(String version)
    {
        this.version = version;
    }
    
    /**
     * @return the performanceSchema
     */
    public String getPerformanceSchema()
    {
        return performanceSchema;
    }
    
    /**
     * @param performanceSchema the performanceSchema to set
     */
    public void setPerformanceSchema(String performanceSchema)
    {
        this.performanceSchema = performanceSchema;
    }

    /**
     * @return the characterSetDatabase
     */
    public String getCharacterSetDatabase()
    {
        return characterSetDatabase;
    }

    /**
     * @param characterSetDatabase the characterSetDatabase to set
     */
    public void setCharacterSetDatabase(String characterSetDatabase)
    {
        this.characterSetDatabase = characterSetDatabase;
    }
    
}
