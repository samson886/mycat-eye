/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  HealthCheckServiceImpl.java   
 * @Package io.mycat.eye.agent.service.impl   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月8日 下午5:50:26   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import io.mycat.eye.agent.bean.Constant;
import io.mycat.eye.agent.bean.MysqlWeakPassword;
import io.mycat.eye.agent.bean.MysqlWeakPasswordExample;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.dto.RestResponse;
import io.mycat.eye.agent.mapper.MysqlWeakPasswordMapper;
import io.mycat.eye.agent.service.HealthCheckService;

/**   
 * @ClassName:  HealthCheckServiceImpl   
 * @Description:健康检查Service
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月8日 下午5:50:26   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
@Service
public class HealthCheckServiceImpl extends AbstractService implements HealthCheckService
{
    @Resource
    private MysqlWeakPasswordMapper mysqlWeakPasswordMapper;
    
    /* (non-Javadoc)
     * @see io.mycat.eye.agent.service.HealthCheckService#superPriv(java.lang.Long)
     */
    @Override
    public RestResponse<Object> superPriv(Long serverId)
    {
        //查询具有超级权限的远程用户
        String sql = "select * from mysql.user where Super_priv='Y' and host <>'localhost'";
        return getRestResponseBySql(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> weakPassword(Long serverId)
    {
        RestResponse<Object> restResponse = new RestResponse<>();
        String sql = "select User,authentication_string from mysql.user";
        QueryResult<List<Map<Object, Object>>> weekPasswordQueryResult = getQueryResult(serverId, sql);
        if (!weekPasswordQueryResult.isSuccess())
        {
            restResponse.setCode(Constant.JDBC_ERROR_CODE);
            restResponse.setMessage(weekPasswordQueryResult.getException());
            return restResponse;
        }
        //定义一个list，用于保存弱密码的用户和密码明文
        List<Map<String, String>> userPlaintextList = new ArrayList<>();
        //获取节点数据库中用户、密码信息
        List<Map<Object, Object>> userPasswordList = weekPasswordQueryResult.getData();
        //每个用户依次比对，是否存在弱密码
        boolean isWeakPassword = false;
        for (Map<Object, Object> map : userPasswordList)
        {
            String user = (String)map.get("User");
            String authentication = (String)map.get("authentication_string");
            //查询该用户的密码是否在弱密码库中存在
            MysqlWeakPasswordExample mysqlWeakPasswordExample = new MysqlWeakPasswordExample();
            mysqlWeakPasswordExample.createCriteria().andCiphertextEqualTo(authentication);
            
            List<MysqlWeakPassword> weakPasswords = mysqlWeakPasswordMapper.selectByExample(mysqlWeakPasswordExample);
            //如果存在则将用户、密码、明文保存到表中
            if ((weakPasswords != null) && (!weakPasswords.isEmpty()))
            {
                //明文
                String plaintext = weakPasswords.get(0).getPlaintext();
                Map<String, String> userPlaintextMap = new HashMap<>();
                userPlaintextMap.put("user", user);
                userPlaintextMap.put("plaintext", plaintext);
                userPlaintextList.add(userPlaintextMap);
                isWeakPassword = true;
            }
        }
        //如果存在弱密码
        if (isWeakPassword)
        {
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
            restResponse.setData(userPlaintextList);
        }
        else
        {
            restResponse.setCode(Constant.NOT_EXIST_WEAK_PASSWORD_CODE);
            restResponse.setMessage(Constant.NOT_EXIST_WEAK_PASSWORD_MESSAGE);
        }
        return restResponse;
    }
    
    @Override
    public RestResponse<Object> lockWait(Long serverId)
    {
        //通过sys库查找是否存在锁等待的记录
        String sql = "select * from sys.x$innodb_lock_waits";
        return getRestResponseBySql(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> transaction(Long serverId)
    {
        //通过performance_schema库查找是否存在未完成的事务
        String sql = "select * from performance_schema.events_transactions_current";
        return getRestResponseBySql(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> slow(Long serverId)
    {
        //通过mysql库查找是否存在慢查询
        String sql = "select * from mysql.slow_log limit 10";
        return getRestResponseBySql(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> charset(Long serverId)
    {
        //查询在非系统数据库中是否存在不是utf8(utf8mb4)的编码表
        String sql =
            "SELECT CONCAT(TABLE_SCHEMA,'.',TABLE_NAME) as TABLE_NAME,COLUMN_NAME,CHARACTER_SET_NAME FROM information_schema.COLUMNS WHERE data_type IN ('varchar','longtext','text','mediumtext','char') AND character_set_name not in ('utf8','utf8mb4') AND table_schema NOT IN ("
                + BUILT_IN_SCHEMA + ")";
        return getRestResponseBySql(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> connections(Long serverId)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public RestResponse<Object> replication(Long serverId)
    {
        //查询节点的复制状态（从库）
        String sql = "show slave status";
        return getRestResponseBySql(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> unusedIndex(Long serverId)
    {
        //查询无用索引
        String sql =
            "SELECT * FROM sys.schema_unused_indexes WHERE object_schema NOT IN (" + BUILT_IN_SCHEMA + ") LIMIT "+DEFAULT_LIMIT;
        return getRestResponseBySql(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> noPrimaryKey(Long serverId)
    {
        //查询没有设置主键的表
        String sql =
            "SELECT * FROM information_schema.TABLES t LEFT JOIN information_schema.STATISTICS s ON t.table_schema = s.table_schema AND t.table_name = s.table_name AND s.index_name = 'PRIMARY'WHERE t.table_schema NOT IN ("
                + BUILT_IN_SCHEMA + ") AND table_type = 'BASE TABLE' AND s.index_name IS NULL";
        return getRestResponseBySql(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> indexCardinality(Long serverId)
    {
        //查询索引选择度较低的索引
        String sql =
            "select * from (SELECT CONCAT(t.TABLE_SCHEMA,'.',t.TABLE_NAME) table_name,INDEX_NAME,CARDINALITY,TABLE_ROWS, CARDINALITY/TABLE_ROWS AS SELECTIVITY FROM information_schema.TABLES t, (SELECT table_schema,table_name,index_name,cardinality FROM information_schema.STATISTICS WHERE seq_in_index=1  ) s WHERE t.table_schema = s.table_schema AND t.table_name = s.table_name AND t.table_rows != 0 AND t.table_schema NOT IN ("
                + BUILT_IN_SCHEMA + ")) as t where t.SELECTIVITY<" + MIN_SELECTIVITY;
        return getRestResponseBySql(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> redundantIndex(Long serverId)
    {
      //查询冗余索引
        String sql =
            "SELECT * FROM sys.schema_redundant_indexes WHERE table_schema NOT IN ("+BUILT_IN_SCHEMA+") LIMIT "+DEFAULT_LIMIT;
        return getRestResponseBySql(serverId, sql);
    }
    
}
