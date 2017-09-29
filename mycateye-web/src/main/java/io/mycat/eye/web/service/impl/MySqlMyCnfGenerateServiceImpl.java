package io.mycat.eye.web.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.mycat.eye.web.dto.MyCnfGenerateSettingsDto;
import io.mycat.eye.web.exception.BusinessException;
import io.mycat.eye.web.exception.mycnf.MySqlMyCnfExceptionEnum;
import io.mycat.eye.web.service.MySqlMyCnfGenerateService;

@Service("mySqlMyCnfGenerateService")
public class MySqlMyCnfGenerateServiceImpl implements MySqlMyCnfGenerateService
{
    
    @Override
    public String generate(MyCnfGenerateSettingsDto settingsDto)
    {
        prepare(settingsDto);
        StringBuilder sb = new StringBuilder();
        process(settingsDto, sb);
        return sb.toString();
    }
    
    private void prepare(MyCnfGenerateSettingsDto settingsDto)
    {
        if (settingsDto == null)
        {
            throw new BusinessException(MySqlMyCnfExceptionEnum.DATA_ERROR);
        }
        
        if (StringUtils.isEmpty(settingsDto.getServerHostName()))
        {
            throw new BusinessException(MySqlMyCnfExceptionEnum.SERVER_HOST_NAME_NULL);
        }
        
        if (StringUtils.isEmpty(settingsDto.getServerId()))
        {
            throw new BusinessException(MySqlMyCnfExceptionEnum.SERVER_ID_NULL);
        }
        
        if (null == settingsDto.getPhysicalMemory())
        {
            throw new BusinessException(MySqlMyCnfExceptionEnum.PHYSICAL_MEMORY_NULL);
        }
        
        if (StringUtils.isEmpty(settingsDto.getInstallPath()))
        {
            throw new BusinessException(MySqlMyCnfExceptionEnum.INSTALL_PATH_NULL);
        }
        
        if (StringUtils.isEmpty(settingsDto.getDataFilePath()))
        {
            throw new BusinessException(MySqlMyCnfExceptionEnum.DATA_FILE_PATH_NULL);
        }
        
        if (null == settingsDto.getListenPort())
        {
            throw new BusinessException(MySqlMyCnfExceptionEnum.LISTEN_PORT_NULL);
        }
        
        if (null == settingsDto.getExpectedMaxConnect())
        {
            throw new BusinessException(MySqlMyCnfExceptionEnum.EXPECTED_MAX_CONNECT_NULL);
        }
        
        if (null == settingsDto.getBinlogExpireDays())
        {
            throw new BusinessException(MySqlMyCnfExceptionEnum.BINLOG_EXPIRE_DAYS_NULL);
        }
        
        if (null == settingsDto.getSortAndJoinQuery())
        {
            settingsDto.setSortAndJoinQuery(Boolean.TRUE);
        }
        
        if (null == settingsDto.getRecoverData())
        {
            settingsDto.setRecoverData(Boolean.TRUE);
        }
    }
    
    private void process(MyCnfGenerateSettingsDto settingsDto, StringBuilder sb)
    {
        sb.append("#\n");
        sb.append("## dbeye auto generate\n");
        sb.append("#\n");
        sb.append("[client]\n");
        sb.append("port	= ").append(settingsDto.getListenPort()).append("\n");
        sb.append("\n");
        sb.append("[mysql]\n");
        sb.append("prompt=\"\\u@").append(settingsDto.getServerHostName()).append(" \\R:\\m:\\s [\\d]> \"\n");
        sb.append("no-auto-rehash\n");
        sb.append("\n");
        sb.append("[mysqld]\n");
        
        sb.append("########基础设置########\n");
        sb.append("user	= mysql\n");
        sb.append("port	= ").append(settingsDto.getListenPort()).append("\n");
        sb.append("basedir	= ").append(settingsDto.getInstallPath()).append("\n");
        sb.append("datadir	= ").append(settingsDto.getDataFilePath()).append("\n");
        sb.append("#默认编码设置为utf8mb4\n");
        sb.append("character-set-server = utf8mb4\n");
        sb.append("#该参数目的是不再进行反解析，可以加快数据库的反应时间\n");
        sb.append("skip_name_resolve = 1\n");
        sb.append("#允许的最大连接数\n");
        sb.append("max_connections = ").append(settingsDto.getExpectedMaxConnect()).append("\n");
        sb.append("#允许的最大错误连接数，超过该值客户端将被屏蔽，默认为100，一般将该值设的较大避免客户端被屏蔽引发难以预料的问题\n");
        sb.append("max_connect_errors = 1000000\n");
        sb.append("#接受的数据包大小，有时大的插入和更新会失败，将max_allowed_packet设置适当避免该问题\n");
        sb.append("max_allowed_packet = 32M\n");
        sb.append("#排序缓存大小，在排序大量数据时该值将影响order by子句的执行效率\n");
        sb.append("sort_buffer_size = ").append(settingsDto.getSortAndJoinQuery() ? "32M" : "4M").append("\n");
        sb.append("#连接缓存大小，在连接大表时，该值将影响连接查询的效率\n");
        sb.append("join_buffer_size = ").append(settingsDto.getSortAndJoinQuery() ? "128M" : "4M").append("\n");
        sb.append("#使用MySQL客户端连接超时时间设为3分钟\n");
        sb.append("interactive_timeout = 1800\n");
        sb.append("#使用JDBC连接超时时间设为3分钟\n");
        sb.append("wait_timeout = 1800\n");
        sb.append("#临时表大小，在排序和连接较多时，适当\n");
        sb.append("tmp_table_size = ").append(settingsDto.getSortAndJoinQuery() ? "64M" : "32M").append("\n");
        sb.append("#MySQL读入缓冲区大小\n");
        sb.append("read_buffer_size = 16M\n");
        sb.append("#MySQL随机读缓冲区大小\n");
        sb.append("read_rnd_buffer_size = 32M\n");
        sb.append("#设置处理TIMESTAMP列的方式，详见官方文档说明 \n");
        sb.append("explicit_defaults_for_timestamp = 1\n");
        
        sb.append("########日志设置########\n");
        sb.append("#开启慢查询日志\n");
        sb.append("slow_query_log = 1\n");
        sb.append("#慢查询日志存放位置\n");
        sb.append("slow_query_log_file = ").append("slow.log\n");
        sb.append("#错误日志存放位置\n");
        sb.append("log-error = ").append("error.log\n");
        sb.append("#超过多少秒的查询，被视为慢查询\n");
        sb.append("long_query_time = 1\n");
        
        sb.append("########复制设置########\n");
        sb.append("#开启binlog，指定日志名称\n");
        sb.append("log_bin = ").append("bin\n");
        sb.append("#当每进行1次事务提交之后，MySQL将进行一次fsync磁盘同步，以此来保证无损复制\n");
        sb.append("sync_binlog = 1\n");
        sb.append("#二进制日志过期时间\n");
        sb.append("expire_logs_days = ").append(settingsDto.getBinlogExpireDays()).append("\n");
        sb.append("#master.info保存在表中\n");
        sb.append("master_info_repository = TABLE\n");
        sb.append("#relay.info保存在表中\n");
        sb.append("relay_log_info_repository = TABLE\n");
        sb.append("#启动GTID模式\n");
        sb.append("gtid_mode = on\n");
        sb.append("#启动GTID模式\n");
        sb.append("enforce_gtid_consistency = 1\n");
        sb.append("#从服务器的更新写入二进制日志,便于主从切换时，从服务器已经开启二进制日志\n");
        sb.append("log_slave_updates\n");
        sb.append("#以row格式记录binlog\n");
        sb.append("binlog_format = row\n");
        sb.append("#允许从库宕机后，重新从master上获取日志，保证relay-log的完整性\n");
        sb.append("relay_log_recovery = 1\n");
        sb.append("#开启半同步无损复制\n");
        sb.append("[mysqld-5.7]\n");
        sb.append("plugin-load = \"rpl_semi_sync_master=semisync_master.so;rpl_semi_sync_slave=semisync_slave.so\"\n");
        sb.append("rpl-semi-sync-master-enabled = 1\n");
        sb.append("rpl-semi-sync-slave-enabled = 1\n");
        sb.append("#server-id\n");
        sb.append("server-id = ").append(settingsDto.getServerId() + "\n");
        
        sb.append("########innodb设置########\n");
        sb.append("#锁等待时间\n");
        sb.append("lock_wait_timeout = 3600\n");
        sb.append("#并发运行的线程数，设置为0表示不限制\n");
        sb.append("innodb_thread_concurrency = 0\n");
        sb.append("\n");
        sb.append("#将事务隔离级别设置为READ-COMMITTED\n");
        sb.append("transaction_isolation = READ-COMMITTED\n");
        sb.append("#InnoDB缓存池大小\n");
        sb.append("innodb_buffer_pool_size = ")
            .append(((Double)(settingsDto.getPhysicalMemory() * 1000 * 0.75)).intValue())
            .append("M\n");
        sb.append("#InnoDB缓存池实例数\n");
        sb.append("innodb_buffer_pool_instances = 8\n");
        sb.append("#在启动时把热数据加载到内存\n");
        sb.append("innodb_buffer_pool_load_at_startup = 1\n");
        sb.append("#数据库关闭时自动dump数据\n");
        sb.append("innodb_buffer_pool_dump_at_shutdown = 1\n");
        sb.append("#每次提交事务都写入日志，保证数据安全\n");
        sb.append("innodb_flush_log_at_trx_commit = ").append(settingsDto.getRecoverData() ? 1 : 2).append("\n");
        sb.append("#尚未执行的事务分配的缓存，如果事务比较大，适当调整该值\n");
        sb.append("innodb_log_buffer_size = 16M\n");
        sb.append("#redo日志的大小\n");
        sb.append("innodb_log_file_size = 2G\n");
        sb.append("#当超过这个阀值（默认是1G），会触发truncate回收（收缩）动作，truncate后空间缩小到10M\n");
        sb.append("innodb_max_undo_log_size = 4G\n");
        sb.append("\n");
        sb.append("# 根据您的服务器IOPS能力适当调整\n");
        sb.append("# 一般配普通SSD盘的话，可以调整到 10000 - 20000\n");
        sb.append("# 配置高端PCIe SSD卡的话，则可以调整的更高，比如 50000 - 80000\n");
        sb.append("innodb_io_capacity = 4000\n");
        sb.append("innodb_io_capacity_max = 8000\n");
        sb.append("\n");
        sb.append("#innodb其他配置\n");
        sb.append("innodb_write_io_threads = 8\n");
        sb.append("innodb_read_io_threads = 8\n");
        sb.append("innodb_purge_threads = 4\n");
        sb.append("innodb_page_cleaners = 4\n");
        sb.append("innodb_open_files = 65535\n");
        sb.append("innodb_max_dirty_pages_pct = 50\n");
        sb.append("innodb_flush_method = O_DIRECT\n");
        sb.append("innodb_lru_scan_depth = 4000\n");
        sb.append("innodb_checksum_algorithm = crc32\n");
        sb.append("innodb_file_format = Barracuda\n");
        sb.append("innodb_file_format_max = Barracuda\n");
        sb.append("innodb_lock_wait_timeout = 10\n");
        sb.append("innodb_rollback_on_timeout = 1\n");
        sb.append("innodb_print_all_deadlocks = 1\n");
        sb.append("innodb_file_per_table = 1\n");
        sb.append("innodb_online_alter_log_max_size = 4G\n");
        sb.append("internal_tmp_disk_storage_engine = InnoDB\n");
        sb.append("#将保存在permanforce_schema中的SQL语句长度设置的足够长，便于查看\n");
        sb.append("performance_schema_max_sql_text_length = 4048\n");
    }
}
