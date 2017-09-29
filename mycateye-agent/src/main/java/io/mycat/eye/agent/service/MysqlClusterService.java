/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  MysqlClusterService.java   
 * @Package io.mycat.eye.web.service   
 * @Description:    MySQL集群 Service
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月16日 下午2:04:27   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service;

import java.util.List;

import io.mycat.eye.agent.bean.MysqlCluster;
import io.mycat.eye.agent.dto.ClusterNetworkDto;
import io.mycat.eye.agent.dto.RestResponse;

/**   
 * @ClassName:  MysqlClusterService   
 * @Description:MySQL集群 Service
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月16日 下午2:04:27   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public interface MysqlClusterService
{
    /**
     * 获取所有MySQL集群
     * @Title: getAllClusters   
     * @return        
     * @throws
     */
    public List<MysqlCluster> getAllClusters();
    
    /**
     * 获取指定集群的拓扑节点信息
     * @Title: getClusterNetworkById   
     * @param clusterId
     * @return        
     * @throws
     */
    public ClusterNetworkDto getClusterNetworkById(Long clusterId);

    /**
     * 保存集群
     * @Title: saveCluster   
     * @param id
     * @param name
     * @return        
     * @throws
     */
    public RestResponse<String> saveCluster(Long id,String name);

    /**
     * 删除集群
     * @Title: deleteCluster   
     * @param id
     * @return        
     * @throws
     */
    public RestResponse<String> deleteCluster(Long id);
}
