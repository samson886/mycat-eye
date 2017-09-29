/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  Relation.java   
 * @Package io.mycat.eye.web.dto   
 * @Description:    MySQL节点的复制关系
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月16日 下午3:01:29   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.dto;

import io.mycat.eye.agent.bean.MysqlServer;

/**   
 * @ClassName:  Relation   
 * @Description:MySQL节点的复制关系
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月16日 下午3:01:29   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public class Relation
{
    private MysqlServer from;
    private MysqlServer to;
    private SlaveStatus slaveStatus;
    
    public Relation(MysqlServer from,MysqlServer to,SlaveStatus slaveStatus){
        this.from=from;
        this.to=to;
        this.slaveStatus=slaveStatus;
    }
    /**
     * @return the from
     */
    public MysqlServer getFrom()
    {
        return from;
    }
    /**
     * @param from the from to set
     */
    public void setFrom(MysqlServer from)
    {
        this.from = from;
    }
    /**
     * @return the to
     */
    public MysqlServer getTo()
    {
        return to;
    }
    /**
     * @param to the to to set
     */
    public void setTo(MysqlServer to)
    {
        this.to = to;
    }
    /**
     * @return the slaveStatus
     */
    public SlaveStatus getSlaveStatus()
    {
        return slaveStatus;
    }
    /**
     * @param slaveStatus the slaveStatus to set
     */
    public void setSlaveStatus(SlaveStatus slaveStatus)
    {
        this.slaveStatus = slaveStatus;
    }
}
