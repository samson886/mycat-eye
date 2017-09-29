/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  ClusterNetWorkDto.java   
 * @Package io.mycat.eye.agent.dto   
 * @Description:    集群拓扑节点数据对象
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月16日 下午2:39:15   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.dto;

import java.util.List;

import io.mycat.eye.agent.bean.MysqlServer;

/**   
 * @ClassName:  ClusterNetWorkDto   
 * @Description:集群拓扑节点数据对象
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月16日 下午2:39:15   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public class ClusterNetworkDto
{
    private List<MysqlServer> mysqlServers;
    private List<Relation> relations;
    
    /**
     * @return the mysqlServers
     */
    public List<MysqlServer> getMysqlServers()
    {
        return mysqlServers;
    }

    /**
     * @param mysqlServers the mysqlServers to set
     */
    public void setMysqlServers(List<MysqlServer> mysqlServers)
    {
        this.mysqlServers = mysqlServers;
    }

    /**
     * @return the relations
     */
    public List<Relation> getRelations()
    {
        return relations;
    }

    /**
     * @param relations the relations to set
     */
    public void setRelations(List<Relation> relations)
    {
        this.relations = relations;
    }
}
