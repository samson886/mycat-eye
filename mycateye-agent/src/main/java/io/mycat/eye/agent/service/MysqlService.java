/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  MysqlService.java   
 * @Package cn.bqjr.dbeye.service   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年5月3日 上午10:07:06   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service;

import io.mycat.eye.agent.bean.MysqlServer;
import io.mycat.eye.agent.dto.MasterInfoDto;
import io.mycat.eye.agent.dto.MysqlNodeDto;
import io.mycat.eye.agent.dto.PagedDto;
import io.mycat.eye.agent.dto.RestResponse;
import io.mycat.eye.agent.dto.SlaveInfoDto;

/**   
 * @ClassName:  MysqlService   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年5月3日 上午10:07:06   
 *     
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
public interface MysqlService {
    /**
     * 验证MySQL登录身份、版本、内置schema
     * @Title: verify   
     * @param host
     * @param port
     * @param username
     * @param password
     * @return        
     * @throws
     */
    RestResponse<Object> mysqlVerify(String host,Integer port,String username,String password);

    /**
     * 获取MySQL节点的分页列表
     * @Title: getNodeList   
     * @param draw
     * @param startIndex
     * @param pageSize
     * @return        
     * @throws
     */
    PagedDto<MysqlNodeDto> getNodeList(int draw, int startIndex, int pageSize);

    /**
     * @param username TODO
     * @param id TODO
     * 新增节点
     * @Title: addNode   
     * @param host
     * @param port
     * @param password
     * @param tags
     * @param clusterId
     * @return        
     * @throws
     */
    RestResponse<Object> saveNode(String username, Long id, String host, Integer port, String password, String tags, Long clusterId);

    /**
     * 删除节点信息
     * @Title: deleteNode   
     * @param id
     * @return        
     * @throws
     */
    RestResponse<Object> deleteNode(Long id);

    /**
     * 获取MySQL节点信息
     * @Title: getNodeInfo   
     * @param id
     * @return        
     * @throws
     */
    MysqlServer getNodeInfo(Long id);
    
    /**
     * 获取指定服务的二进制文件
     *
     * @param serverId 服务器ID
     * @return
     */
    RestResponse<Object> getBinaryLogs(Long serverId);

    /**
     * 获取指定服务器，指定二进制文件的内容
     *
     * @param serverId 服务器ID
     * @param logName  二进制日志文件名
     * @param begin    开始点
     * @param end      结束点
     * @return
     */
    RestResponse<Object> getBinaryLogData(Long serverId, String logName, Long begin, Long end);

    /**
     * 获取回话变量列表
     *
     * @param serverId
     * @return
     */
    RestResponse<Object> getSessionVariables(Long serverId);

    /**
     * 设置全局变量值
     * @param serverId
     * @param name
     * @param value
     * @return
     */
    RestResponse<Object> setGlobalVariables(Long serverId, String name, String value);

    /**
     * 设置回话变量值
     * @param serverId
     * @param name
     * @param value
     * @return
     */
    RestResponse<Object> setSessionVariables(Long serverId, String name, String value);
    /**
     * 获取数据库列表
     * @Title: getDatabases   
     * @param serverId
     * @return        
     * @throws
     */
    RestResponse<Object> getDatabases(Long serverId);
    /**
     * 获取指定数据库的表信息
     * @Title: getTables   
     * @param serverId
     * @param schema
     * @return        
     * @throws
     */
    RestResponse<Object> getTables(Long serverId,String schema);
    /**
     * 根据schema获取相应的用户权限信息
     * @Title: getUserPriv   
     * @param serverId
     * @param schema
     * @return        
     * @throws
     */
    RestResponse<Object> getUserPriv(Long serverId,String schema);
    
    /**
     * 获取节点概要信息
     * @Title: getOverview   
     * @param serverId
     * @return        
     * @throws
     */
    RestResponse<Object> getOverview(Long serverId);

    /**
     * 根据语句显示二进制文件内容
     * @Title: getShowBinlogEvents   
     * @param serverId
     * @param showBinlogEvents
     * @return        
     * @throws
     */
    RestResponse<Object> getShowBinlogEvents(Long serverId, String showBinlogEvents);

    /**
     * 根据过滤条件获取全局变量
     * @Title: getGlobalVariables   
     * @param serverId
     * @param filter
     * @return        
     * @throws
     */
    RestResponse<Object> getGlobalVariables(Long serverId, String filter);

    /**
     * 通过过滤条件查询状态
     * @Title: getStatus   
     * @param serverId
     * @param filter
     * @return        
     * @throws
     */
    RestResponse<Object> getStatus(Long serverId, String filter);
    /**
     * 获取主库相关信息
     * @Title: getMasterInfo   
     * @param serverId
     * @return        
     * @throws
     */
    RestResponse<MasterInfoDto> getMasterInfo(Long serverId);
    /**
     * 获取从库相关信息
     * @Title: getSlaveInfo   
     * @param serverId
     * @return        
     * @throws
     */
    RestResponse<SlaveInfoDto> getSlaveInfo(Long serverId);
}
