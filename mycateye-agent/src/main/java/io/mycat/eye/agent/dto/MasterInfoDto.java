/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  MasterInfoDto.java   
 * @Package io.mycat.eye.agent.dto   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月25日 上午10:53:25   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.dto;

/**   
 * @ClassName:  MasterInfoDto   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月25日 上午10:53:25   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public class MasterInfoDto
{
    private Object masterStatus;
    private Object slaveHosts;
    /**
     * @return the masterStatus
     */
    public Object getMasterStatus()
    {
        return masterStatus;
    }
    /**
     * @param masterStatus the masterStatus to set
     */
    public void setMasterStatus(Object masterStatus)
    {
        this.masterStatus = masterStatus;
    }
    /**
     * @return the slaveHosts
     */
    public Object getSlaveHosts()
    {
        return slaveHosts;
    }
    /**
     * @param slaveHosts the slaveHosts to set
     */
    public void setSlaveHosts(Object slaveHosts)
    {
        this.slaveHosts = slaveHosts;
    }
    
}
