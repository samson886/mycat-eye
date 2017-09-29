/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  MysqlClusterServiceImpl.java   
 * @Package io.mycat.eye.agent.service   
 * @Description:    MySQL集群 Service
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月16日 下午2:09:05   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import io.mycat.eye.agent.bean.Constant;
import io.mycat.eye.agent.bean.MysqlCluster;
import io.mycat.eye.agent.bean.MysqlClusterExample;
import io.mycat.eye.agent.bean.MysqlServer;
import io.mycat.eye.agent.bean.MysqlServerExample;
import io.mycat.eye.agent.dto.ClusterNetworkDto;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.dto.Relation;
import io.mycat.eye.agent.dto.RestResponse;
import io.mycat.eye.agent.dto.SlaveStatus;
import io.mycat.eye.agent.mapper.MysqlClusterMapper;
import io.mycat.eye.agent.mapper.MysqlServerMapper;
import io.mycat.eye.agent.service.MysqlClusterService;

/**   
 * @ClassName:  MysqlClusterServiceImpl   
 * @Description:MySQL集群 Service
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月16日 下午2:09:05   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
@Service
public class MysqlClusterServiceImpl extends AbstractService implements MysqlClusterService
{
    @Resource
    private MysqlClusterMapper mysqlClusterMapper;
    @Resource
    private MysqlServerMapper mysqlServerMapper;
    /* (non-Javadoc)
     * @see io.mycat.eye.agent.service.MysqlClusterService#getAllClusters()
     */
    @Override
    public List<MysqlCluster> getAllClusters()
    {
        List<MysqlCluster> list = mysqlClusterMapper.selectByExample(new MysqlClusterExample());
        return list;
    }
    @Override
    public ClusterNetworkDto getClusterNetworkById(Long clusterId)
    {
        ClusterNetworkDto clusterNetworkDto=new ClusterNetworkDto();
        MysqlServerExample mysqlServerExample=new MysqlServerExample();
        mysqlServerExample.createCriteria().andClusterIdEqualTo(clusterId);
        List<MysqlServer> mysqlServers = mysqlServerMapper.selectByExample(mysqlServerExample);
        clusterNetworkDto.setMysqlServers(mysqlServers);
        List<Relation> relations=getRelations(mysqlServers);
        clusterNetworkDto.setRelations(relations);
        return clusterNetworkDto;
    }
    
    /**
     * 获取节点的复制关系
     * @Title: getRelation   
     * @param mysqlServer
     * @return        
     * @throws
     */
    private List<Relation> getRelations(List<MysqlServer> mysqlServers){
        String showSlaveHostsSql="show slave hosts";
        String showVariablesSql="show variables like 'server_id'";
        String showSlaveStatusSql="show slave status";
        List<Relation> relations=new ArrayList<>();
        for (MysqlServer fromMysqlServer : mysqlServers)
        {
            QueryResult<List<Map<Object,Object>>> queryResultSlaveHosts = getQueryResult(fromMysqlServer.getId(), showSlaveHostsSql);
            //当数据库查询异常，继续执行下一个节点
            if (!queryResultSlaveHosts.isSuccess())
            {
                logger.error(queryResultSlaveHosts.getException());
                continue;
            }
            //当数据库查询异常，继续执行下一个节点
            if (queryResultSlaveHosts.getData().isEmpty())
            {
                continue;
            }
            //获取从库节点列表
            List<Map<Object,Object>> listSlaveHosts = queryResultSlaveHosts.getData();
            for (Map<Object, Object> map : listSlaveHosts)
            {
                //检查从库节点是否在已添加的节点当中
                String toServerId = String.valueOf((Long)map.get("Server_id"));
                for (MysqlServer toMysqlServer : mysqlServers)
                {
                    QueryResult<List<Map<Object, Object>>> queryResultVariables = getQueryResult(toMysqlServer.getId(), showVariablesSql);
                    //如果数据库操作异常或结果集为空，则继续检查下一个节点
                    if ((!queryResultVariables.isSuccess())||queryResultVariables.getData().isEmpty())
                    {
                        continue;
                    }
                    List<Map<Object, Object>> listVariables = queryResultVariables.getData();
                    Map<Object, Object> mapVariables = listVariables.get(0);
                    String _toServerId=(String)mapVariables.get("Value");
                    //当被检查到的节点serverid和当前从库的serverid一致时，则保存复制关系
                    if (toServerId.equals(_toServerId))
                    {
                        //查询从库的状态
                        QueryResult<List<Map<Object,Object>>> queryResultSlaveStatus = getQueryResult(toMysqlServer.getId(), showSlaveStatusSql);
                        List<Map<Object,Object>> listSlaveStatus = queryResultSlaveStatus.getData();
                        Map<Object, Object> mapSlaveStatus = listSlaveStatus.get(0);
                        SlaveStatus slaveStatus=new SlaveStatus();
                        slaveStatus.setLastIOError((String) mapSlaveStatus.get("Last_IO_Error"));
                        slaveStatus.setLastSQLError((String) mapSlaveStatus.get("Last_SQL_Error"));
                        slaveStatus.setMasterHost((String) mapSlaveStatus.get("Master_Host"));
                        slaveStatus.setMasterLogFile((String) mapSlaveStatus.get("Master_Log_File"));
                        slaveStatus.setReadMasterLogPos(
                            String.valueOf((BigInteger) mapSlaveStatus.get("Read_Master_Log_Pos")));
                        slaveStatus.setSecondsBehindMaster(
                            String.valueOf((BigInteger) mapSlaveStatus.get("Seconds_Behind_Master")));
                        slaveStatus
                            .setSlaveIORunning((String) mapSlaveStatus.get("Slave_IO_Running"));
                        slaveStatus
                            .setSlaveSQLRunning((String) mapSlaveStatus.get("Slave_SQL_Running"));
                        Relation relation=new Relation(fromMysqlServer, toMysqlServer,slaveStatus);
                        relations.add(relation);
                        break;
                    }
                }
            }
        }
        return relations;
    }
    @Override
    public RestResponse<String> saveCluster(Long id,String name)
    {
        RestResponse<String> restResponse=new RestResponse<>();
        MysqlCluster mysqlCluster=new MysqlCluster();
        try
        {
            //如果id为0，则为插入
            if (id==Constant.ZERO)
            {
                mysqlCluster.setCreateTime(new Date());
                mysqlCluster.setName(name);
                mysqlClusterMapper.insert(mysqlCluster);
            }
            //如果id不为0，则为编辑
            else{
                mysqlCluster.setCreateTime(new Date());
                mysqlCluster.setName(name);
                mysqlCluster.setId(id);
                mysqlClusterMapper.updateByPrimaryKey(mysqlCluster);
            }
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        }
        catch (Exception e)
        {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(e.getMessage());
        }
        return restResponse;
    }
    @Override
    public RestResponse<String> deleteCluster(Long id)
    {
        RestResponse<String> restResponse=new RestResponse<>();
        try
        {
            mysqlClusterMapper.deleteByPrimaryKey(id);
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        }
        catch (Exception e)
        {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(e.getMessage());
        }
        
        return restResponse;
    }
    
}
