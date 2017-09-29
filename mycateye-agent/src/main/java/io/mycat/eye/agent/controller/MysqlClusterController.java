/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  MysqlClusterController.java   
 * @Package io.mycat.eye.agent.controller   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月16日 下午2:02:52   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mycat.eye.agent.bean.MysqlCluster;
import io.mycat.eye.agent.dto.ClusterNetworkDto;
import io.mycat.eye.agent.dto.RestResponse;
import io.mycat.eye.agent.service.MysqlClusterService;

/**   
 * @ClassName:  MysqlClusterController   
 * @Description:MySQL集群Controller
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月16日 下午2:02:52   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
@RestController
public class MysqlClusterController
{
    @Autowired
    private MysqlClusterService mysqlClusterService;

    /**
     * 获取所有集群信息
     * @Title: getAllClusters   
     * @return        
     * @throws
     */
    @RequestMapping("/mysql/cluster/all")
    @CrossOrigin(origins = "*")
    public List<MysqlCluster> getAllClusters() {
        return mysqlClusterService.getAllClusters();
    }
    /**
     * 获取指定集群的拓扑节点信息
     * @Title: getClusterNetWorkById   
     * @return        
     * @throws
     */
    @RequestMapping("/mysql/cluster/network")
    @CrossOrigin(origins = "*")
    public ClusterNetworkDto getClusterNetworkById(HttpServletRequest request) {
        //请求数据
        Long clusterId = Long.valueOf(request.getParameter("clusterId"));
        return mysqlClusterService.getClusterNetworkById(clusterId);
    }
    /**
     * 新增集群
     * @Title: addCluster   
     * @param name
     * @return        
     * @throws
     */
    @RequestMapping("/mysql/cluster/save")
    @CrossOrigin(origins = "*")
    public RestResponse<String> saveCluster(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        return mysqlClusterService.saveCluster(id,name);
    }
    /**
     * 删除集群
     * @Title: deleteCluster   
     * @param request
     * @return        
     * @throws
     */
    @RequestMapping("/mysql/cluster/delete")
    @CrossOrigin(origins = "*")
    public RestResponse<String> deleteCluster(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("id"));
        return mysqlClusterService.deleteCluster(id);
    }
}
