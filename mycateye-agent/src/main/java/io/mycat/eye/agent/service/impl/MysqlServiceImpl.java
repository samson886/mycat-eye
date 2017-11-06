/**
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  MysqlServiceImpl.java
 * @Package cn.bqjr.dbeye.service.impl
 * @Description:    TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年5月3日 上午10:30:05
 * @version V1.0
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
package io.mycat.eye.agent.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import io.mycat.eye.agent.bean.Constant;
import io.mycat.eye.agent.bean.MysqlCluster;
import io.mycat.eye.agent.bean.MysqlServer;
import io.mycat.eye.agent.bean.MysqlServerExample;
import io.mycat.eye.agent.dto.MasterInfoDto;
import io.mycat.eye.agent.dto.MysqlNodeDto;
import io.mycat.eye.agent.dto.MysqlOverview;
import io.mycat.eye.agent.dto.PagedDto;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.dto.RestResponse;
import io.mycat.eye.agent.dto.SlaveInfoDto;
import io.mycat.eye.agent.dto.UserPriv;
import io.mycat.eye.agent.mapper.MysqlClusterMapper;
import io.mycat.eye.agent.service.JdbcService;
import io.mycat.eye.agent.service.MysqlService;
import io.mycat.eye.agent.util.MiscUtil;

/**
 * @ClassName: MysqlServiceImpl
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年5月3日 上午10:30:05
 *
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
@Service
public class MysqlServiceImpl extends AbstractService implements MysqlService
{
    
    @Resource
    protected JdbcService jdbcService;
    
    @Resource
    private MysqlClusterMapper mysqlClusterMapper;
    
    /*
     * (non-Javadoc)
     *
     * @see cn.bqjr.dbeye.service.MysqlService#verify(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public RestResponse<Object> mysqlVerify(String host, Integer port, String username, String password)
    {
        RestResponse<Object> restResponse = new RestResponse<Object>();
        String dataSourceUrl =
            "jdbc:mysql://" + host + ":" + port + "?user=" + username + "&password=" + password + "&useSSL=false";
        //查看版本
        String sqlVersion = "select version() as version";
        QueryResult<List<Map<Object, Object>>> queryResultVersion =
            jdbcService.queryForList(dataSourceUrl, sqlVersion, username, password);
        //开启慢查询
        String sqlSlow = "set global slow_query_log=ON";
        QueryResult<List<Map<Object, Object>>> queryResultSlow =
            jdbcService.queryForList(dataSourceUrl, sqlSlow, username, password);
        if (!queryResultSlow.isSuccess())
        {
            logger.error("开启慢查询失败");
        }
        else
        {
            logger.error("开启慢查询");
        }
        //将日志输出到表，方便查询慢查询日志
        String sqlLogOutput = "set global log_output='TABLE'";
        QueryResult<List<Map<Object, Object>>> queryLogOutput =
            jdbcService.queryForList(dataSourceUrl, sqlLogOutput, username, password);
        if (!queryLogOutput.isSuccess())
        {
            logger.error("设置日志输出到表失败");
        }
        else
        {
            logger.error("设置日志输出到表");
        }
        
        //数据库操作失败，则返回
        if (queryResultVersion.isSuccess() == false)
        {
            restResponse.setCode(1);
            restResponse.setMessage(queryResultVersion.getException());
            
            return restResponse;
        }
        
        String version = (String)queryResultVersion.getData().get(0).get("version");
        
        //版本不为5.7+，则返回
        /*
        if (!version.startsWith("5.7"))
        {
            restResponse.setCode(1);
            restResponse.setMessage("目前仅支持MySQL 5.7+版本，你的MySQL版本为：" + version);
            
            return restResponse;
        }
        */
        //查看内置数据库是否存在
        String sqlShowDatabases = "show databases";
        QueryResult<List<Map<Object, Object>>> queryResultShowDatabases =
            jdbcService.queryForList(dataSourceUrl, sqlShowDatabases, username, password);
        List<Map<Object, Object>> data = queryResultShowDatabases.getData();
        List<String> allDatabases = new ArrayList<String>();
        for (Map<Object, Object> map : data)
        {
            String database = (String)map.get("Database");
            allDatabases.add(database);
        }
        //如全部数据库中不包括内置数据库，则返回
        if (!allDatabases.containsAll(defaultDatabases()))
        {
            restResponse.setCode(1);
            restResponse.setMessage("你的内置数据库被删除，请确保你的MySQL上存在：information_schema、mysql、performance_schema、sys内置数据库");
        }
        //如验证通过，则返回成功
        restResponse.setCode(Constant.SUCCESS_CODE);
        restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        restResponse.setData(version);
        return restResponse;
    }
    
    @Override
    public PagedDto<MysqlNodeDto> getNodeList(int draw, int startIndex, int pageSize)
    {
        PagedDto<MysqlNodeDto> pagedDto = null;
        MysqlServerExample mysqlServerExample = new MysqlServerExample();
        mysqlServerExample.setLimitStart(startIndex);
        mysqlServerExample.setPageSize(pageSize);
        mysqlServerExample.setOrderByClause("id desc");
        List<MysqlServer> mysqlServers = mysqlServerMapper.selectByExample(mysqlServerExample);
        List<MysqlNodeDto> mysqlNodeDtos = new ArrayList<>();
        for (MysqlServer mysqlServer : mysqlServers)
        {
            MysqlNodeDto mysqlNodeDto = new MysqlNodeDto();
            Long clusterId = mysqlServer.getClusterId();
            MysqlCluster mysqlCluster = mysqlClusterMapper.selectByPrimaryKey(clusterId);
            if (mysqlCluster != null)
            {
                mysqlNodeDto.setClusterName(mysqlCluster.getName());
            }
            mysqlNodeDto.setMysqlServer(mysqlServer);
            mysqlNodeDtos.add(mysqlNodeDto);
        }
        int count = mysqlServerMapper.countByExample(null);
        pagedDto = new PagedDto<>();
        pagedDto.setData(mysqlNodeDtos);
        pagedDto.setDraw(draw);
        pagedDto.setRecordsFiltered(count);
        pagedDto.setRecordsTotal(count);
        return pagedDto;
    }
    
    @Override
    public RestResponse<Object> saveNode(String username, Long id, String host, Integer port, String password,
        String tags, Long clusterId)
    {
        RestResponse<Object> restResponse = new RestResponse<>();
        //验证MySQL主机、端口、用户名、密码
        RestResponse<Object> mysqlVerifyRestResponse = mysqlVerify(host, port, username, password);
        if (mysqlVerifyRestResponse.getCode() != Constant.SUCCESS_CODE)
        {
            return mysqlVerifyRestResponse;
        }
        MysqlServer mysqlServer = new MysqlServer();
        mysqlServer.setClusterId(clusterId);
        mysqlServer.setCreateTime(new Date());
        mysqlServer.setHost(host);
        mysqlServer.setPassword(password);
        mysqlServer.setPort(port);
        mysqlServer.setTags(tags);
        mysqlServer.setUsername(username);
        mysqlServer.setVer((String)mysqlVerifyRestResponse.getData());
        try
        {
            //如果id为0，这为新增
            if (id == Constant.ZERO)
            {
                mysqlServerMapper.insert(mysqlServer);
            }
            //如果id不为0，则为编辑
            else
            {
                mysqlServer.setId(id);
                mysqlServerMapper.updateByPrimaryKey(mysqlServer);
            }
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(e.getMessage());
        }
        
        return restResponse;
    }
    
    @Override
    public RestResponse<Object> deleteNode(Long id)
    {
        RestResponse<Object> restResponse = new RestResponse<>();
        try
        {
            mysqlServerMapper.deleteByPrimaryKey(id);
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(e.getMessage());
        }
        
        return restResponse;
    }
    
    @Override
    public MysqlServer getNodeInfo(Long id)
    {
        MysqlServer mysqlServer = mysqlServerMapper.selectByPrimaryKey(id);
        return mysqlServer;
    }
    
    @Override
    public RestResponse<Object> getBinaryLogs(Long serverId)
    {
        String sql = "SHOW BINARY LOGS;";
        return executeSqlForList(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> getBinaryLogData(Long serverId, String logName, Long begin, Long end)
    {
        begin = begin == null ? 0 : begin;
        end = end == null ? 25 : end;
        String sql = "SHOW BINLOG EVENTS IN '" + logName + "' LIMIT " + begin + ", " + end + " ;";
        return executeSqlForList(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> getSessionVariables(Long serverId)
    {
        String sql = "SHOW VARIABLES;";
        return executeSqlForList(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> setSessionVariables(Long serverId, String name, String value)
    {
        String sql = "SET " + name + "=" + value + ";";
        return executeSqlForBoolean(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> setGlobalVariables(Long serverId, String name, String value)
    {
        String sql = "SET GLOBAL " + name + "=" + value + ";";
        return executeSqlForBoolean(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> getDatabases(Long serverId)
    {
        String sql =
            "SELECT concat(round((sum(DATA_LENGTH)+sum(INDEX_LENGTH))/1024/1024,2),'MB') as size,TABLE_SCHEMA FROM information_schema.TABLES group by TABLE_SCHEMA";
        return executeSqlForList(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> getUserPriv(Long serverId, String schema)
    {
        RestResponse<Object> restResponse = new RestResponse<>();
        List<UserPriv> userPrivs = new ArrayList<>();
        // 查询mysql.user表获取全局用户权限信息
        String sqlUser = "select * from mysql.user where Select_priv='Y'";
        QueryResult<List<Map<Object, Object>>> userResult = getQueryResult(serverId, sqlUser);
        List<Map<Object, Object>> userData = userResult.getData();
        for (Map<Object, Object> map : userData)
        {
            UserPriv userPriv = new UserPriv();
            userPriv.setHost((String)map.get("Host"));
            userPriv.setUser((String)map.get("User"));
            userPriv.setType("全局");
            userPriv.setGrant((String)map.get("Grant_priv"));
            String privs = getPrivs(map);
            userPriv.setPriv(privs);
            userPrivs.add(userPriv);
        }
        
        // 查询mysql.db表获取schema对应的权限信息
        String sqlDb = "select * from mysql.db where Db='" + schema + "'";
        QueryResult<List<Map<Object, Object>>> dbResult = getQueryResult(serverId, sqlDb);
        List<Map<Object, Object>> dbData = dbResult.getData();
        for (Map<Object, Object> map : dbData)
        {
            UserPriv userPriv = new UserPriv();
            userPriv.setHost((String)map.get("Host"));
            userPriv.setUser((String)map.get("User"));
            userPriv.setType("按数据库指定");
            userPriv.setGrant((String)map.get("Grant_priv"));
            String privs = getPrivs(map);
            userPriv.setPriv(privs);
            userPrivs.add(userPriv);
        }
        restResponse.setCode(0);
        restResponse.setData(userPrivs);
        restResponse.setMessage("success");
        return restResponse;
    }
    
    private String getPrivs(Map<Object, Object> map)
    {
        StringBuffer stringBuffer = new StringBuffer();
        if ("Y".equals((String)map.get("Select_priv")))
        {
            stringBuffer.append("SELECT;");
        }
        if ("Y".equals((String)map.get("Insert_priv")))
        {
            stringBuffer.append("INSERT;");
        }
        if ("Y".equals((String)map.get("Update_priv")))
        {
            stringBuffer.append("UPDATE;");
        }
        if ("Y".equals((String)map.get("Delete_priv")))
        {
            stringBuffer.append("DELETE;");
        }
        if ("Y".equals((String)map.get("Create_priv")))
        {
            stringBuffer.append("CREATE;");
        }
        if ("Y".equals((String)map.get("Drop_priv")))
        {
            stringBuffer.append("DROP");
        }
        return stringBuffer.toString();
    }
    
    @Override
    public RestResponse<Object> getTables(Long serverId, String schema)
    {
        RestResponse<Object> restResponse = new RestResponse<>();
        String tablesSql =
            "select t1.TABLE_SCHEMA,t1.TABLE_NAME,concat(round((t1.DATA_LENGTH+t1.INDEX_LENGTH)/1024/1024,2),'MB') as size,t3.io_total from information_schema.TABLES t1 left join (select t2.table_schema,t2.table_name,io_read_requests+io_write_requests as io_total from sys.schema_table_statistics t2) as t3 on  t1.TABLE_SCHEMA=t3.table_schema and t1.TABLE_NAME=t3.TABLE_NAME where t1.table_schema='"
                + schema + "'";
        QueryResult<List<Map<Object, Object>>> tablesResult = getQueryResult(serverId, tablesSql);
        if (tablesResult.isSuccess())
        {
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage("success");
            restResponse.setData(tablesResult.getData());
        }
        else
        {
            restResponse.setCode(1);
            restResponse.setMessage("fail");
        }
        return restResponse;
    }
    
    @Override
    public RestResponse<Object> getOverview(Long serverId)
    {
        RestResponse<Object> restResponse = new RestResponse<>();
        MysqlServer mysqlServer = mysqlServerMapper.selectByPrimaryKey(serverId);
        MysqlOverview mysqlOverview = new MysqlOverview();
        mysqlOverview.setHost(mysqlServer.getHost());
        mysqlOverview.setPort(mysqlServer.getPort());
        mysqlOverview.setTags(mysqlServer.getTags());
        String overviewSql =
            "show variables where Variable_name in ('log_error','general_log','general_log_file','slow_query_log','slow_query_log_file','datadir','basedir','innodb_buffer_pool_size','performance_schema','version','character_set_database')";
        QueryResult<List<Map<Object, Object>>> queryResult = getQueryResult(serverId, overviewSql);
        
        if (queryResult.isSuccess())
        {
            List<Map<Object, Object>> list = queryResult.getData();
			String Variable_name="VARIABLE_NAME";//"Variable_name";
			String Value="VARIABLE_VALUE";//Value;
			
			String Variable=(String)list.get(0).get(Variable_name);
			if (Variable==null){
				Variable_name="Variable_name";
				Value="Value";				
			}
            for (Map<Object, Object> map : list)
            {
                String variableName = (String)map.get(Variable_name);
                if (variableName.equals("basedir"))
                {
                    mysqlOverview.setBasedir((String)map.get(Value));
                }
                if (variableName.equals("datadir"))
                {
                    mysqlOverview.setDatadir((String)map.get(Value));
                }
                if (variableName.equals("general_log"))
                {
                    mysqlOverview.setGeneralLog((String)map.get(Value));
                }
                if (variableName.equals("general_log_file"))
                {
                    mysqlOverview.setGeneralLogFile((String)map.get(Value));
                }
                if (variableName.equals("innodb_buffer_pool_size"))
                {
                    Long innodbBufferPoolSize = Long.valueOf((String)map.get(Value));
                    mysqlOverview.setInnodbBufferPoolSize(MiscUtil.getHumanSizeByBytes(innodbBufferPoolSize));
                }
                if (variableName.equals("log_error"))
                {
                    mysqlOverview.setLogError((String)map.get(Value));
                }
                if (variableName.equals("performance_schema"))
                {
                    mysqlOverview.setPerformanceSchema((String)map.get(Value));
                }
                if (variableName.equals("slow_query_log"))
                {
                    mysqlOverview.setSlowQueryLog((String)map.get(Value));
                }
                if (variableName.equals("slow_query_log_file"))
                {
                    mysqlOverview.setSlowQueryLogFile((String)map.get(Value));
                }
                if (variableName.equals("version"))
                {
                    mysqlOverview.setVersion((String)map.get(Value));
                }
                if (variableName.equals("character_set_database"))
                {
                    mysqlOverview.setCharacterSetDatabase((String)map.get(Value));
                }
            }
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
            restResponse.setData(mysqlOverview);
        }
        else
        {
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(queryResult.getException());
            restResponse.setData(mysqlOverview);
        }
        return restResponse;
    }
    
    @Override
    public RestResponse<Object> getShowBinlogEvents(Long serverId, String showBinlogEvents)
    {
        return executeSqlForList(serverId, showBinlogEvents);
    }
    
    @Override
    public RestResponse<Object> getGlobalVariables(Long serverId, String filter)
    {
        String sql = "SHOW GLOBAL VARIABLES like '%" + filter + "%'";
        return executeSqlForList(serverId, sql);
    }
    
    @Override
    public RestResponse<Object> getStatus(Long serverId, String filter)
    {
        RestResponse<Object> restResponse = new RestResponse<>();
        String sql = "show status like '%" + filter + "%'";
        QueryResult<List<Map<Object, Object>>> result = getQueryResult(serverId, sql);
        if (result.isSuccess())
        {
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage("success");
            restResponse.setData(result.getData());
        }
        else
        {
            restResponse.setCode(1);
            restResponse.setMessage("fail");
        }
        return restResponse;
    }
    
    @Override
    public RestResponse<MasterInfoDto> getMasterInfo(Long serverId)
    {
        RestResponse<MasterInfoDto> restResponse = new RestResponse<>();
        MasterInfoDto masterInfoDto = new MasterInfoDto();
        //查询master status
        String sqlMasterStatus = "show master status";
        QueryResult<List<Map<Object, Object>>> resultMasterStatus = getQueryResult(serverId, sqlMasterStatus);
        if (resultMasterStatus.isSuccess())
        {
            masterInfoDto.setMasterStatus(resultMasterStatus.getData());
        }
        //查询slave hosts
        String sqlSlaveHosts = "show slave hosts";
        QueryResult<List<Map<Object, Object>>> resultSlaveHosts = getQueryResult(serverId, sqlSlaveHosts);
        if (resultSlaveHosts.isSuccess())
        {
            masterInfoDto.setSlaveHosts(resultSlaveHosts.getData());
        }
        restResponse.setCode(Constant.SUCCESS_CODE);
        restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        restResponse.setData(masterInfoDto);
        return restResponse;
    }
    
    @Override
    public RestResponse<SlaveInfoDto> getSlaveInfo(Long serverId)
    {
        RestResponse<SlaveInfoDto> restResponse = new RestResponse<>();
        SlaveInfoDto slaveInfoDto = new SlaveInfoDto();
        //查询slave status
        String sqlSlaveStatus = "show slave status";
        QueryResult<List<Map<Object, Object>>> resultSlaveStatus = getQueryResult(serverId, sqlSlaveStatus);
        if (resultSlaveStatus.isSuccess())
        {
            slaveInfoDto.setSlaveStatus(resultSlaveStatus.getData());
        }
        restResponse.setCode(Constant.SUCCESS_CODE);
        restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        restResponse.setData(slaveInfoDto);
        return restResponse;
    }
    /**
     * 内置数据库
     * @Title: defaultDatabases   
     * @return        
     * @throws
     */
    private List<String> defaultDatabases()
    {
        List<String> defaultDatabases = new ArrayList<String>();
        defaultDatabases.add("information_schema");
        defaultDatabases.add("mysql");
        defaultDatabases.add("performance_schema");
        defaultDatabases.add("sys");
        return defaultDatabases;
    }
}
