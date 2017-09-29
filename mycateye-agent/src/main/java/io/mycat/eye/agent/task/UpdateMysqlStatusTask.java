package io.mycat.eye.agent.task;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.mycat.eye.agent.bean.MysqlServer;
import io.mycat.eye.agent.bean.MysqlServerExample;
import io.mycat.eye.agent.bean.MysqlStatusHistory;
import io.mycat.eye.agent.bean.MysqlStatusHistoryExample;
import io.mycat.eye.agent.dto.QueryResult;
import io.mycat.eye.agent.mapper.MysqlStatusHistoryMapper;

@Component
public class UpdateMysqlStatusTask extends AbstractTask
{
    private static final String ZERO = "0";
    
    public final static long DELAY_TIME = 2000;
    
    // private static final String STATUS_SQL = "select * from global_status
    // where VARIABLE_NAME
    // in('open_tables','threads_connected','threads_running','threads_created','threads_cached','connections','aborted_clients','aborted_connects','bytes_received','bytes_sent','com_select','com_insert','com_update','com_delete','com_commit','com_rollback','questions','transactions','created_tmp_tables','created_tmp_disk_tables','created_tmp_files','innodb_data_reads','innodb_data_writes','innodb_data_fsyncs','innodb_data_read','innodb_data_written','innodb_buffer_pool_pages_dirty','innodb_buffer_pool_pages_flushed','innodb_rows_inserted','innodb_rows_updated','innodb_rows_deleted','slow_queries','slave_delay')";
    private static final String STATUS_SQL =
        "show global status where VARIABLE_NAME in('uptime','open_tables','threads_connected','threads_running','threads_created','threads_cached','connections','aborted_clients','aborted_connects','bytes_received','bytes_sent','com_select','com_insert','com_update','com_delete','com_commit','com_rollback','questions','transactions','created_tmp_tables','created_tmp_disk_tables','created_tmp_files','innodb_data_reads','innodb_data_writes','innodb_data_fsyncs','innodb_data_read','innodb_data_written','innodb_buffer_pool_pages_dirty','innodb_buffer_pool_pages_flushed','innodb_rows_inserted','innodb_rows_updated','innodb_rows_deleted','slow_queries','slave_delay','innodb_buffer_pool_pages_total','innodb_buffer_pool_pages_free','innodb_page_size')";
    
    @Resource
    private MysqlStatusHistoryMapper mysqlStatusHistoryMapper;
    
    //TODO
    @Scheduled(fixedDelay = DELAY_TIME)
    public void execute()
    {
        // 获取MySQL服务器信息
        MysqlServerExample mysqlServerExample = new MysqlServerExample();
        List<MysqlServer> mysqlServers = mysqlServerMapper.selectByExample(mysqlServerExample);
        
        for (MysqlServer mysqlServer : mysqlServers)
        {
            Long serverId = mysqlServer.getId();
            String host = mysqlServer.getHost();
            String port = String.valueOf(mysqlServer.getPort());
            String username = mysqlServer.getUsername();
            String password = mysqlServer.getPassword();
            QueryResult<List<Map<Object, Object>>> statusQueryResult =
                getQueryResult(host, port, STATUS_SQL, username, password);
            
            // 如果数据库操作异常，则返回
            if (!statusQueryResult.isSuccess())
            {
                continue;
            }
            
            List<Map<Object, Object>> statusList = statusQueryResult.getData();
            MysqlStatusHistory statusHistory = new MysqlStatusHistory();
            statusHistory.setServerId(serverId);
            statusHistory.setCreateTime(new Date());
            
            // 设置各属性
            for (Map<Object, Object> map : statusList)
            {
                if ("Aborted_clients".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setAbortedClients(new Integer(map.get("Value").toString()));
                }
                
                if ("Aborted_connects".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setAbortedConnects(new Integer(map.get("Value").toString()));
                }
                
                if ("Bytes_received".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setBytesReceived(new Long(map.get("Value").toString()));
                }
                
                if ("Bytes_sent".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setBytesSent(new Long(map.get("Value").toString()));
                }
                
                if ("Com_commit".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setComCommit(new Long(map.get("Value").toString()));
                }
                
                if ("Com_delete".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setComDelete(new Long(map.get("Value").toString()));
                }
                
                if ("Com_insert".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setComInsert(new Long(map.get("Value").toString()));
                }
                
                if ("Com_rollback".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setComRollback(new Long(map.get("Value").toString()));
                }
                
                if ("Com_select".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setComSelect(new Long(map.get("Value").toString()));
                }
                
                if ("Com_update".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setComUpdate(new Long(map.get("Value").toString()));
                }
                
                if ("Connections".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setConnections(new Integer(map.get("Value").toString()));
                }
                
                if ("Created_tmp_disk_tables".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setCreatedTmpDiskTables(new Long(map.get("Value").toString()));
                }
                
                if ("Created_tmp_files".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setCreatedTmpFiles(new Long(map.get("Value").toString()));
                }
                
                if ("Created_tmp_tables".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setCreatedTmpTables(new Long(map.get("Value").toString()));
                }
                
                if ("Innodb_buffer_pool_pages_dirty".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbBufferPoolPagesDirty(new Long(map.get("Value").toString()));
                }
                
                if ("Innodb_buffer_pool_pages_flushed".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbBufferPoolPagesFlushed(new Long(map.get("Value").toString()));
                }
                
                if ("Innodb_buffer_pool_pages_free".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbBufferPoolPagesFree(new Long(map.get("Value").toString()));
                }
                
                if ("Innodb_buffer_pool_pages_total".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbBufferPoolPagesTotal(new Long(map.get("Value").toString()));
                }
                
                if ("Innodb_data_fsyncs".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbDataFsyncs(new Long(map.get("Value").toString()));
                }
                
                if ("Innodb_data_read".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbDataRead(new Long(map.get("Value").toString()));
                }
                
                if ("Innodb_data_reads".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbDataReads(new Long(map.get("Value").toString()));
                }
                
                if ("Innodb_data_writes".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbDataWrites(new Long(map.get("Value").toString()));
                }
                
                if ("Innodb_data_written".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbDataWritten(new Long(map.get("Value").toString()));
                }
                
                if ("Innodb_page_size".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbPageSize(new Integer(map.get("Value").toString()));
                }
                
                if ("Innodb_rows_deleted".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbRowsDeleted(new Long(map.get("Value").toString()));
                }
                
                if ("Innodb_rows_inserted".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbRowsInserted(new Long(map.get("Value").toString()));
                }
                
                if ("Innodb_rows_updated".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setInnodbRowsInserted(new Long(map.get("Value").toString()));
                }
                
                if ("Open_tables".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setOpenTables(new Integer(map.get("Value").toString()));
                }
                
                if ("Questions".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setQuestions(new Long(map.get("Value").toString()));
                }
                
                if ("Slow_queries".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setSlowQueries(new Integer(map.get("Value").toString()));
                }
                
                if ("Threads_cached".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setThreadsCached(new Integer(map.get("Value").toString()));
                }
                
                if ("Threads_connected".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setThreadsConnected(new Integer(map.get("Value").toString()));
                }
                
                if ("Threads_created".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setThreadsCreated(new Integer(map.get("Value").toString()));
                }
                
                if ("Threads_running".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setThreadsRunning(new Integer(map.get("Value").toString()));
                }
                
                if ("Uptime".equals((String)map.get("Variable_name")))
                {
                    statusHistory.setUptime(map.get("Value").toString());
                }
            }
            
            MysqlStatusHistoryExample mysqlStatusHistoryExample = new MysqlStatusHistoryExample();
            mysqlStatusHistoryExample.createCriteria().andServerIdEqualTo(serverId);
            
            Long lastId = mysqlStatusHistoryMapper.maxByExample(mysqlStatusHistoryExample);
            mysqlStatusHistoryMapper.insertSelective(statusHistory);
            
            // 根据上一个记录的指标值，做增量计算，再做平均值计算
            MysqlStatusHistory lastStatusHistory = mysqlStatusHistoryMapper.selectByPrimaryKey(lastId);
            
            if (lastStatusHistory != null)
            {
                // 计算QPS
                statusHistory.setQuestionsPersecond(getQuestionsPersecond(statusHistory, lastStatusHistory));
                // 计算每秒接受数据大小
                statusHistory.setBytesReceivedPersecond(getBytesReceivedPersecond(statusHistory, lastStatusHistory));
                // 计算每秒发送数据大小
                statusHistory.setBytesSentPersecond(getBytesSentPersecond(statusHistory, lastStatusHistory));
                // 计算每秒select语句的数量
                statusHistory.setComSelectPersecond(getComSelectPersecond(statusHistory, lastStatusHistory));
                // 计算每秒insert语句的数量
                statusHistory.setComInsertPersecond(getComInsertPersecond(statusHistory, lastStatusHistory));
                // 计算每秒update语句的数量
                statusHistory.setComUpdatePersecond(getComUpdatePersecond(statusHistory, lastStatusHistory));
                // 计算每秒delete语句的数量
                statusHistory.setComDeletePersecond(getComDeletePersecond(statusHistory, lastStatusHistory));
                // 计算每秒commit语句的数量
                statusHistory.setComCommitPersecond(getComCommitPersecond(statusHistory, lastStatusHistory));
                // 计算每秒rollback的数量
                statusHistory.setComRollbackPersecond(getComRollbackPersecond(statusHistory, lastStatusHistory));
                // 计算每秒事务数量
                statusHistory.setTransactionsPersecond(getTransactionsPersecond(statusHistory, lastStatusHistory));
                // 计算每秒创建临时表数量
                statusHistory
                    .setCreatedTmpTablesPersecond(getCreatedTmpTablesPersecond(statusHistory, lastStatusHistory));
                // 计算每秒创建磁盘表数量
                statusHistory.setCreatedTmpDiskTablesPersecond(
                    getCreatedTmpDiskTablesPersecond(statusHistory, lastStatusHistory));
                // 计算每秒创建临时文件数量
                statusHistory
                    .setCreatedTmpFilesPersecond(getCreatedTmpFilesPersecond(statusHistory, lastStatusHistory));
                // 计算每秒从文件中读取的次数
                statusHistory
                    .setInnodbDataReadsPersecond(getInnodbDataReadsPersecond(statusHistory, lastStatusHistory));
                // 计算每秒从文件中写入的次数
                statusHistory
                    .setInnodbDataWritesPersecond(getInnodbDataWritesPersecond(statusHistory, lastStatusHistory));
                // 计算每秒进行fsync()操作的次数
                statusHistory
                    .setInnodbDataFsyncsPersecond(getInnodbDataFsyncsPersecond(statusHistory, lastStatusHistory));
                // 计算每秒读取的数据量，单位为KB
                statusHistory.setInnodbDataReadPersecond(getInnodbDataReadPersecond(statusHistory, lastStatusHistory));
                // 计算每秒写入的数据量，单位为KB
                statusHistory
                    .setInnodbDataWrittenPersecond(getInnodbDataWrittenPersecond(statusHistory, lastStatusHistory));
                // 计算每秒缓存池中生成脏页的数目-单位page
                statusHistory.setInnodbBufferPoolPagesDirtyPersecond(
                    getInnodbBufferPoolPagesDirtyPersecond(statusHistory, lastStatusHistory));
                // 计算每秒缓存池中刷新页请求的数目-单位page
                statusHistory.setInnodbBufferPoolPagesFlushedPersecond(
                    getInnodbBufferPoolPagesFlushedPersecond(statusHistory, lastStatusHistory));
                // 计算每秒从innodb表插入的行数
                statusHistory
                    .setInnodbRowsInsertedPersecond(getInnodbRowsInsertedPersecond(statusHistory, lastStatusHistory));
                // 计算每秒从innodb表更新的行数
                statusHistory
                    .setInnodbRowsUpdatedPersecond(getInnodbRowsUpdatedPersecond(statusHistory, lastStatusHistory));
                // 计算每秒从innodb表删除的行数
                statusHistory
                    .setInnodbRowsDeletedPersecond(getInnodbRowsDeletedPersecond(statusHistory, lastStatusHistory));
                mysqlStatusHistoryMapper.updateByPrimaryKeySelective(statusHistory);
            }
            
        }
    }
    
    /**
     * 获取QPS @Title: getQuestionsPersecond @param currentStatusHistory @param
     * lastStatusHistory @return @throws
     */
    private String getQuestionsPersecond(MysqlStatusHistory currentStatusHistory, MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentQuestions = currentStatusHistory.getQuestions();
        Long lastQuestions = lastStatusHistory.getQuestions();
        String questionsPersecond = getAverage(currentCreateTime, lastCreateTime, currentQuestions, lastQuestions);
        
        return questionsPersecond;
    }
    
    /**
     * 获取每秒接受数据大小 单位：字节 @Title: getBytesReceivedPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getBytesReceivedPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentBytesReceived = currentStatusHistory.getBytesReceived();
        Long lastBytesReceived = lastStatusHistory.getBytesReceived();
        String bytesReceivedPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentBytesReceived, lastBytesReceived);
        
        return bytesReceivedPersecond;
        
        // 转换为KB
        // return new BigDecimal(bytesReceivedPersecond).divide(new
        // BigDecimal("1024"), 2, BigDecimal.ROUND_HALF_EVEN).toString();
    }
    
    /**
     * 获取每秒发送数据大小 单位字节 @Title: getBytesSentPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getBytesSentPersecond(MysqlStatusHistory currentStatusHistory, MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentBytesSent = currentStatusHistory.getBytesSent();
        Long lastBytesSent = lastStatusHistory.getBytesSent();
        String bytesSentPersecond = getAverage(currentCreateTime, lastCreateTime, currentBytesSent, lastBytesSent);
        
        return bytesSentPersecond;
    }
    
    /**
     * 获取每秒select语句的数量 @Title: getComSelectPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getComSelectPersecond(MysqlStatusHistory currentStatusHistory, MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentComSelect = currentStatusHistory.getComSelect();
        Long lastComSelect = lastStatusHistory.getComSelect();
        String comSelectPersecond = getAverage(currentCreateTime, lastCreateTime, currentComSelect, lastComSelect);
        
        return comSelectPersecond;
    }
    
    /**
     * 获取每秒insert语句的数量 @Title: getComInsertPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getComInsertPersecond(MysqlStatusHistory currentStatusHistory, MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentComInsert = currentStatusHistory.getComInsert();
        Long lastComInsert = lastStatusHistory.getComInsert();
        String comInsertPersecond = getAverage(currentCreateTime, lastCreateTime, currentComInsert, lastComInsert);
        
        return comInsertPersecond;
    }
    
    /**
     * 获取每秒update的数量 @Title: getComUpdatePersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getComUpdatePersecond(MysqlStatusHistory currentStatusHistory, MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentComUpdate = currentStatusHistory.getComUpdate();
        Long lastComUpdate = lastStatusHistory.getComUpdate();
        String comUpdatePersecond = getAverage(currentCreateTime, lastCreateTime, currentComUpdate, lastComUpdate);
        
        return comUpdatePersecond;
    }
    
    /**
     * 获取每秒delete的数量 @Title: getComDeletePersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getComDeletePersecond(MysqlStatusHistory currentStatusHistory, MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentComDelete = currentStatusHistory.getComDelete();
        Long lastComDelete = lastStatusHistory.getComDelete();
        String comDeletePersecond = getAverage(currentCreateTime, lastCreateTime, currentComDelete, lastComDelete);
        
        return comDeletePersecond;
    }
    
    /**
     * 获取每秒commit的数量 @Title: getComCommitPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getComCommitPersecond(MysqlStatusHistory currentStatusHistory, MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentComCommit = currentStatusHistory.getComCommit();
        Long lastComCommit = lastStatusHistory.getComCommit();
        String comCommitPersecond = getAverage(currentCreateTime, lastCreateTime, currentComCommit, lastComCommit);
        
        return comCommitPersecond;
    }
    
    /**
     * 获取每秒rollback的数量 @Title: getComRollbackPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getComRollbackPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentComRollback = currentStatusHistory.getComRollback();
        Long lastComRollback = lastStatusHistory.getComRollback();
        String comRollbackPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentComRollback, lastComRollback);
        
        return comRollbackPersecond;
    }
    
    /**
     * 获取每秒事务数 @Title: getTransactionsPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getTransactionsPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentTransactions = currentStatusHistory.getTransactions();
        Long lastTransactions = lastStatusHistory.getTransactions();
        String transactionsPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentTransactions, lastTransactions);
        
        return transactionsPersecond;
    }
    
    /**
     * 获取每秒创建临时表的数量 @Title: getCreatedTmpTablesPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getCreatedTmpTablesPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentCreatedTmpTables = currentStatusHistory.getCreatedTmpTables();
        Long lastCreatedTmpTables = lastStatusHistory.getCreatedTmpTables();
        String createdTmpTablesPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentCreatedTmpTables, lastCreatedTmpTables);
        
        return createdTmpTablesPersecond;
    }
    
    /**
     * 获取每秒创建临时 @Title: getCreatedTmpDiskTablesPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getCreatedTmpDiskTablesPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentCreatedTmpDiskTables = currentStatusHistory.getCreatedTmpDiskTables();
        Long lastCreatedTmpDiskTables = lastStatusHistory.getCreatedTmpDiskTables();
        String createdTmpTablesPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentCreatedTmpDiskTables, lastCreatedTmpDiskTables);
        
        return createdTmpTablesPersecond;
    }
    
    /**
     * 获取每秒创建临时文件数量 @Title: getCreatedTmpFilesPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getCreatedTmpFilesPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentCreatedTmpFiles = currentStatusHistory.getCreatedTmpFiles();
        Long lastCreatedTmpFiles = lastStatusHistory.getCreatedTmpFiles();
        String createdTmpFilesPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentCreatedTmpFiles, lastCreatedTmpFiles);
        
        return createdTmpFilesPersecond;
    }
    
    /**
     * 获取每秒innodb从文件中读取的次数 @Title: getInnodbDataReadsPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getInnodbDataReadsPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentInnodbDataReads = currentStatusHistory.getInnodbDataReads();
        Long lastInnodbDataReads = lastStatusHistory.getInnodbDataReads();
        String innodbDataReadsPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentInnodbDataReads, lastInnodbDataReads);
        
        return innodbDataReadsPersecond;
    }
    
    /**
     * 获取每秒从文件中写入的次数 @Title: getInnodbDataWritesPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getInnodbDataWritesPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentInnodbDataWrites = currentStatusHistory.getInnodbDataWrites();
        Long lastInnodbDataWrites = lastStatusHistory.getInnodbDataWrites();
        String innodbDataWritesPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentInnodbDataWrites, lastInnodbDataWrites);
        
        return innodbDataWritesPersecond;
    }
    
    /**
     * 获取每秒进行fsync()操作的次数 @Title: getInnodbDataFsyncsPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getInnodbDataFsyncsPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentInnodbDataFsyncs = currentStatusHistory.getInnodbDataFsyncs();
        Long lastInnodbDataFsyncs = lastStatusHistory.getInnodbDataFsyncs();
        String innodbDataFsyncsPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentInnodbDataFsyncs, lastInnodbDataFsyncs);
        
        return innodbDataFsyncsPersecond;
    }
    
    /**
     * 获取每秒读取的数据量，单位为KB @Title: getInnodbDataReadPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getInnodbDataReadPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentInnodbDataRead = currentStatusHistory.getInnodbDataRead();
        Long lastInnodbDataRead = lastStatusHistory.getInnodbDataRead();
        String innodbDataReadPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentInnodbDataRead, lastInnodbDataRead);
        
        return innodbDataReadPersecond;
    }
    
    /**
     * 获取每秒写入的数据量，单位为KB @Title: getInnodbDataWrittenPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getInnodbDataWrittenPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentInnodbDataWritten = currentStatusHistory.getInnodbDataWritten();
        Long lastInnodbDataWritten = lastStatusHistory.getInnodbDataWritten();
        String innodbDataWrittenPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentInnodbDataWritten, lastInnodbDataWritten);
        
        return innodbDataWrittenPersecond;
    }
    
    /**
     * 获取每秒缓存池中生成脏页的数目-单位page @Title:
     * getInnodbBufferPoolPagesDirtyPersecond @param currentStatusHistory @param
     * lastStatusHistory @return @throws
     */
    private String getInnodbBufferPoolPagesDirtyPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentInnodbBufferPoolPagesDirty = currentStatusHistory.getInnodbBufferPoolPagesDirty();
        Long lastInnodbBufferPoolPagesDirty = lastStatusHistory.getInnodbBufferPoolPagesDirty();
        String innodbBufferPoolPagesDirtyPersecond = getAverage(currentCreateTime,
            lastCreateTime,
            currentInnodbBufferPoolPagesDirty,
            lastInnodbBufferPoolPagesDirty);
        
        return innodbBufferPoolPagesDirtyPersecond;
    }
    
    /**
     * 获取每秒缓存池中刷新页请求的数目-单位page @Title:
     * getInnodbBufferPoolPagesFlushedPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getInnodbBufferPoolPagesFlushedPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentInnodbBufferPoolPagesFlushed = currentStatusHistory.getInnodbBufferPoolPagesFlushed();
        Long lastInnodbBufferPoolPagesFlushed = lastStatusHistory.getInnodbBufferPoolPagesFlushed();
        String innodbBufferPoolPagesFlushedPersecond = getAverage(currentCreateTime,
            lastCreateTime,
            currentInnodbBufferPoolPagesFlushed,
            lastInnodbBufferPoolPagesFlushed);
        
        return innodbBufferPoolPagesFlushedPersecond;
    }
    
    /**
     * 获取每秒从innodb表插入的行数 @Title: getInnodbRowsInsertedPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getInnodbRowsInsertedPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentInnodbRowsInserted = currentStatusHistory.getInnodbRowsInserted();
        Long lastInnodbRowsInserted = lastStatusHistory.getInnodbRowsInserted();
        String innodbRowsInsertedPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentInnodbRowsInserted, lastInnodbRowsInserted);
        
        return innodbRowsInsertedPersecond;
    }
    
    /**
     * 获取每秒从innodb表更新的行数 @Title: getInnodbRowsUpdatedPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getInnodbRowsUpdatedPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentInnodbRowsUpdated = currentStatusHistory.getInnodbRowsUpdated();
        Long lastInnodbRowsUpdated = lastStatusHistory.getInnodbRowsUpdated();
        String innodbRowsUpdatedPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentInnodbRowsUpdated, lastInnodbRowsUpdated);
        
        return innodbRowsUpdatedPersecond;
    }
    
    /**
     * 获取每秒从innodb表删除的行数 @Title: getInnodbRowsDeletedPersecond @param
     * currentStatusHistory @param lastStatusHistory @return @throws
     */
    private String getInnodbRowsDeletedPersecond(MysqlStatusHistory currentStatusHistory,
        MysqlStatusHistory lastStatusHistory)
    {
        Date currentCreateTime = currentStatusHistory.getCreateTime();
        Date lastCreateTime = lastStatusHistory.getCreateTime();
        Long currentInnodbRowsDeleted = currentStatusHistory.getInnodbRowsDeleted();
        Long lastInnodbRowsDeleted = lastStatusHistory.getInnodbRowsDeleted();
        String innodbRowsDeletedPersecond =
            getAverage(currentCreateTime, lastCreateTime, currentInnodbRowsDeleted, lastInnodbRowsDeleted);
        
        return innodbRowsDeletedPersecond;
    }
    
    /**
     * 计算平均值 @Title: getCountPersecond @param currentTime @param lastTime @param
     * currentCount @param lastCount @return @throws
     */
    private String getAverage(Date currentTime, Date lastTime, Long currentCount, Long lastCount)
    {
        if ((currentCount == null) || (lastCount == null))
        {
            return ZERO;
        }
        
        if (new BigDecimal(currentCount).compareTo(new BigDecimal(lastCount)) == 1)
        {
            Long second = diffSecond(lastTime, currentTime);
            Long count = currentCount - lastCount;
            BigDecimal resultBigDecimal =
                new BigDecimal(count).divide(new BigDecimal(second), 2, BigDecimal.ROUND_HALF_EVEN);
            
            String result = resultBigDecimal.toString();
            // 如果为负数则设为零
            if (result.indexOf("-") != -1)
            {
                result = ZERO;
            }
            return result;
        }
        else
        {
            return ZERO;
        }
    }
    
    /**
     * 获取两个时间的秒数差 @Title: diffSecond @param beginTime @param
     * endTime @return @throws
     */
    private Long diffSecond(Date beginTime, Date endTime)
    {
        long second = (endTime.getTime() - beginTime.getTime()) / 1000;
        //如果秒数相差为0，则置为1
        if (second == 0)
        {
            second = 1L;
        }
        return second;
    }
    
}
