/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  SlaveStatus.java   
 * @Package io.mycat.eye.agent.dto   
 * @Description:    从库状态 
 * @author: 李平
 * @date:   2017年6月7日 上午10:36:59   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.dto;

/**   
 * @ClassName:  SlaveStatus   
 * @Description:从库状态
 * @author: 李平
 * @date:   2017年6月7日 上午10:36:59   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public class SlaveStatus {
    //主库主机名
    private String masterHost;
    //二进制文件
    private String masterLogFile;
    //二进制文件位置
    private String readMasterLogPos;
    //IO线程状态
    private String slaveIORunning;
    //SQL线程状态
    private String slaveSQLRunning;
    //复制延时
    private String secondsBehindMaster;
    //最近一次IO线程错误信息
    private String lastIOError;
    //最近一次SQL线程错误信息
    private String lastSQLError;
    
    /**
     * @return the masterHost
     */
    public String getMasterHost() {
        return masterHost;
    }
    /**
     * @param masterHost the masterHost to set
     */
    public void setMasterHost(String masterHost) {
        this.masterHost = masterHost;
    }
    /**
     * @return the masterLogFile
     */
    public String getMasterLogFile() {
        return masterLogFile;
    }
    /**
     * @param masterLogFile the masterLogFile to set
     */
    public void setMasterLogFile(String masterLogFile) {
        this.masterLogFile = masterLogFile;
    }
    /**
     * @return the readMasterLogPos
     */
    public String getReadMasterLogPos() {
        return readMasterLogPos;
    }
    /**
     * @param readMasterLogPos the readMasterLogPos to set
     */
    public void setReadMasterLogPos(String readMasterLogPos) {
        this.readMasterLogPos = readMasterLogPos;
    }
    /**
     * @return the slaveIORunning
     */
    public String getSlaveIORunning() {
        return slaveIORunning;
    }
    /**
     * @param slaveIORunning the slaveIORunning to set
     */
    public void setSlaveIORunning(String slaveIORunning) {
        this.slaveIORunning = slaveIORunning;
    }
    /**
     * @return the slaveSQLRunning
     */
    public String getSlaveSQLRunning() {
        return slaveSQLRunning;
    }
    /**
     * @param slaveSQLRunning the slaveSQLRunning to set
     */
    public void setSlaveSQLRunning(String slaveSQLRunning) {
        this.slaveSQLRunning = slaveSQLRunning;
    }
    /**
     * @return the secondsBehindMaster
     */
    public String getSecondsBehindMaster() {
        return secondsBehindMaster;
    }
    /**
     * @param secondsBehindMaster the secondsBehindMaster to set
     */
    public void setSecondsBehindMaster(String secondsBehindMaster) {
        this.secondsBehindMaster = secondsBehindMaster;
    }
    /**
     * @return the lastIOError
     */
    public String getLastIOError() {
        return lastIOError;
    }
    /**
     * @param lastIOError the lastIOError to set
     */
    public void setLastIOError(String lastIOError) {
        this.lastIOError = lastIOError;
    }
    /**
     * @return the lastSQLError
     */
    public String getLastSQLError() {
        return lastSQLError;
    }
    /**
     * @param lastSQLError the lastSQLError to set
     */
    public void setLastSQLError(String lastSQLError) {
        this.lastSQLError = lastSQLError;
    }
}
