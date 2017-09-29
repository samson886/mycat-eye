/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  MysqlNodeDto.java   
 * @Package io.mycat.eye.agent.dto   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年9月7日 下午4:26:47   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.dto;

import io.mycat.eye.agent.bean.MysqlServer;

/**   
 * @ClassName:  MysqlNodeDto   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年9月7日 下午4:26:47   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public class MysqlNodeDto
{
    private MysqlServer mysqlServer;
    
    private String clusterName = "";
    
    /**
     * @return the mysqlServer
     */
    public MysqlServer getMysqlServer()
    {
        return mysqlServer;
    }
    
    /**
     * @param mysqlServer the mysqlServer to set
     */
    public void setMysqlServer(MysqlServer mysqlServer)
    {
        this.mysqlServer = mysqlServer;
    }
    
    /**
     * @return the clusterName
     */
    public String getClusterName()
    {
        return clusterName;
    }
    
    /**
     * @param clusterName the clusterName to set
     */
    public void setClusterName(String clusterName)
    {
        this.clusterName = clusterName;
    }
    
}
