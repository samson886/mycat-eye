-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 120.24.54.175    Database: mycat_eye
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mycat_backend`
--

DROP TABLE IF EXISTS `mycat_backend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_backend` (
  `id` int(11) NOT NULL,
  `processor` varchar(45) DEFAULT NULL,
  `mysqlId` int(11) DEFAULT NULL,
  `c_host` varchar(45) DEFAULT NULL,
  `c_port` int(11) DEFAULT NULL,
  `l_port` int(11) DEFAULT NULL COMMENT '本地端口',
  `net_in` bigint(22) DEFAULT NULL,
  `net_out` bigint(22) DEFAULT NULL,
  `life` bigint(22) DEFAULT NULL,
  `closed` varchar(10) DEFAULT NULL,
  `borrowed` varchar(10) DEFAULT NULL,
  `send_queue` int(11) DEFAULT NULL,
  `c_schema` varchar(100) DEFAULT NULL,
  `c_charset` varchar(45) DEFAULT NULL,
  `txlevel` varchar(2) DEFAULT NULL,
  `autocommit` varchar(10) DEFAULT NULL,
  `mycat_id` int(11) DEFAULT NULL,
  `collect_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_cache`
--

DROP TABLE IF EXISTS `mycat_cache`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_cache` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cache` varchar(100) DEFAULT NULL COMMENT 'CACHE',
  `c_max` int(11) DEFAULT NULL COMMENT 'MAX',
  `cur` int(11) DEFAULT NULL COMMENT 'CUR',
  `access` int(11) DEFAULT NULL COMMENT 'ACCESS',
  `hit` int(11) DEFAULT NULL COMMENT 'HIT',
  `put` int(11) DEFAULT NULL COMMENT 'PUT',
  `last_access` int(11) DEFAULT NULL COMMENT 'LAST_ACCESS',
  `last_put` int(11) DEFAULT NULL COMMENT 'LAST_PUT',
  `server_id` int(11) DEFAULT NULL,
  `collect_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_cluster`
--

DROP TABLE IF EXISTS `mycat_cluster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_cluster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cluster_name` varchar(100) DEFAULT NULL,
  `cluster_host` varchar(100) DEFAULT NULL,
  `cluster_port` int(11) DEFAULT NULL,
  `create_time` bigint(22) DEFAULT NULL,
  `last_update_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_connection`
--

DROP TABLE IF EXISTS `mycat_connection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_connection` (
  `id` int(11) NOT NULL,
  `processor` varchar(45) DEFAULT NULL,
  `c_host` varchar(45) DEFAULT NULL,
  `c_port` int(11) DEFAULT NULL,
  `l_port` int(11) DEFAULT NULL COMMENT '本地端口',
  `net_in` bigint(22) DEFAULT NULL,
  `net_out` bigint(22) DEFAULT NULL,
  `c_user` varchar(45) DEFAULT NULL,
  `c_schema` varchar(100) DEFAULT NULL,
  `c_charset` varchar(45) DEFAULT NULL,
  `alive_time` bigint(22) DEFAULT NULL,
  `recv_buffer` int(11) DEFAULT NULL,
  `send_queue` int(11) DEFAULT NULL,
  `txlevel` varchar(2) DEFAULT NULL,
  `autocommit` varchar(10) DEFAULT NULL,
  `mycat_id` int(11) DEFAULT NULL,
  `collect_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_datanode`
--

DROP TABLE IF EXISTS `mycat_datanode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_datanode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `datahost` varchar(100) DEFAULT NULL,
  `d_index` int(11) DEFAULT NULL,
  `d_type` varchar(45) DEFAULT NULL,
  `d_active` int(11) DEFAULT NULL,
  `d_idle` int(11) DEFAULT NULL,
  `d_size` int(11) DEFAULT NULL,
  `d_execute` bigint(22) DEFAULT NULL,
  `total_time` double DEFAULT NULL,
  `max_time` double DEFAULT NULL,
  `max_sql` bigint(22) DEFAULT NULL,
  `recovery_time` bigint(22) DEFAULT NULL,
  `collect_time` bigint(20) DEFAULT NULL,
  `server_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=366 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_directmemory`
--

DROP TABLE IF EXISTS `mycat_directmemory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_directmemory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `thread_id` bigint(22) DEFAULT NULL COMMENT 'THREAD_ID',
  `mem_use_type` varchar(45) DEFAULT NULL COMMENT 'MEM_USE_TYPE',
  `m_size` varchar(45) DEFAULT NULL COMMENT 'SIZE',
  `mdirect_memory_maxed` varchar(45) DEFAULT NULL COMMENT 'MDIRECT_MEMORY_MAXED',
  `direct_memory_used` varchar(45) DEFAULT NULL COMMENT 'DIRECT_MEMORY_USED',
  `direct_memory_available` varchar(45) DEFAULT NULL COMMENT 'DIRECT_MEMORY_AVAILABLE',
  `safety_fraction` float DEFAULT NULL COMMENT 'SAFETY_FRACTION',
  `direct_memory_reserved` varchar(45) DEFAULT NULL COMMENT 'DIRECT_MEMORY_RESERVED',
  `server_id` int(11) DEFAULT NULL,
  `collect_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_server`
--

DROP TABLE IF EXISTS `mycat_server`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_server` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `server_name` varchar(100) DEFAULT NULL,
  `server_host` varchar(100) DEFAULT NULL,
  `manager_port` int(11) DEFAULT NULL,
  `server_port` int(11) DEFAULT NULL,
  `startup` bigint(20) DEFAULT NULL COMMENT '启动时间(时间戳)',
  `user` varchar(45) DEFAULT NULL,
  `password` varchar(62) DEFAULT NULL,
  `cluster_id` int(11) DEFAULT NULL,
  `is_cluster_node` tinyint(4) DEFAULT NULL,
  `create_time` bigint(22) DEFAULT NULL,
  `last_update_time` bigint(22) DEFAULT NULL,
  `startup_history` tinytext COMMENT '逗号分割的时间戳，记录历史启动时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_server_status`
--

DROP TABLE IF EXISTS `mycat_server_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_server_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mycat_id` int(11) DEFAULT NULL,
  `uptime` varchar(45) DEFAULT NULL COMMENT '16h 32m 55s',
  `used_memory` bigint(22) DEFAULT NULL,
  `total_memory` bigint(22) DEFAULT NULL,
  `max_memory` bigint(22) DEFAULT NULL,
  `reload_time` bigint(20) DEFAULT NULL COMMENT 'TIMESTAMP',
  `rollback_time` bigint(20) DEFAULT NULL COMMENT 'TIMESTAMP',
  `charset` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL COMMENT 'ON|OFF',
  `collect_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_sql`
--

DROP TABLE IF EXISTS `mycat_sql`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_sql` (
  `sid` bigint(22) NOT NULL AUTO_INCREMENT,
  `id` bigint(22) DEFAULT NULL,
  `c_user` varchar(45) DEFAULT NULL,
  `start_time` bigint(20) DEFAULT NULL COMMENT '时间戳',
  `execute_time` bigint(22) DEFAULT NULL,
  `c_sql` longtext,
  `server_id` int(11) DEFAULT NULL,
  `collect_time` bigint(22) DEFAULT NULL,
  `startup_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=1816 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_sql_detail`
--

DROP TABLE IF EXISTS `mycat_sql_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_sql_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_source` varchar(45) DEFAULT NULL,
  `execute` bigint(22) DEFAULT NULL,
  `time` double DEFAULT NULL,
  `last_execute_timestamp` bigint(20) DEFAULT NULL COMMENT '时间戳',
  `last_time` double DEFAULT NULL,
  `sql_id` bigint(22) DEFAULT NULL,
  `server_id` int(11) DEFAULT NULL,
  `collect_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1983 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_sql_execute`
--

DROP TABLE IF EXISTS `mycat_sql_execute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_sql_execute` (
  `sql_id` bigint(22) NOT NULL,
  `sql_execute` bigint(22) DEFAULT NULL,
  `sql_time` double DEFAULT NULL,
  `max_time` double DEFAULT NULL,
  `min_time` double DEFAULT NULL,
  `server_id` int(11) DEFAULT NULL COMMENT '服务节点ID',
  `collect_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`sql_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_sql_high`
--

DROP TABLE IF EXISTS `mycat_sql_high`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_sql_high` (
  `sid` bigint(22) NOT NULL AUTO_INCREMENT,
  `id` bigint(22) DEFAULT NULL,
  `c_user` varchar(45) DEFAULT NULL,
  `frequency` bigint(22) DEFAULT NULL COMMENT 'FREQUENCY',
  `avg_time` bigint(22) DEFAULT NULL,
  `max_time` bigint(22) DEFAULT NULL,
  `min_time` bigint(22) DEFAULT NULL,
  `execute_time` bigint(22) DEFAULT NULL,
  `last_time` bigint(20) DEFAULT NULL,
  `c_sql` longtext,
  `server_id` int(11) DEFAULT NULL,
  `collect_time` bigint(22) DEFAULT NULL,
  `startup_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=706 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_sql_large`
--

DROP TABLE IF EXISTS `mycat_sql_large`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_sql_large` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `sql_user` varchar(45) DEFAULT NULL,
  `rows` bigint(22) DEFAULT NULL,
  `start_time` bigint(22) DEFAULT NULL,
  `execute_time` bigint(22) DEFAULT NULL,
  `c_sql` longtext,
  `server_id` int(11) DEFAULT NULL,
  `collect_time` bigint(22) DEFAULT NULL,
  `startup_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_sql_large_rs`
--

DROP TABLE IF EXISTS `mycat_sql_large_rs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_sql_large_rs` (
  `sid` bigint(22) NOT NULL AUTO_INCREMENT,
  `id` bigint(22) DEFAULT NULL,
  `sql_user` varchar(45) DEFAULT NULL,
  `frequency` bigint(22) DEFAULT NULL COMMENT 'FREQUENCY',
  `c_sql` longtext,
  `resultset_size` bigint(22) DEFAULT NULL,
  `server_id` int(11) DEFAULT NULL,
  `collect_time` bigint(22) DEFAULT NULL,
  `startup_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_sql_slow`
--

DROP TABLE IF EXISTS `mycat_sql_slow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_sql_slow` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `c_user` varchar(45) DEFAULT NULL,
  `datasource` varchar(100) DEFAULT NULL,
  `start_time` bigint(20) DEFAULT NULL,
  `execute_time` bigint(22) DEFAULT NULL,
  `c_sql` longtext,
  `server_id` int(11) DEFAULT NULL,
  `collect_time` bigint(22) DEFAULT NULL,
  `startup_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mycat_sql_sum`
--

DROP TABLE IF EXISTS `mycat_sql_sum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycat_sql_sum` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `id` bigint(22) NOT NULL,
  `c_user` varchar(45) DEFAULT NULL,
  `r` bigint(22) DEFAULT NULL,
  `w` bigint(22) DEFAULT NULL,
  `r_p` float DEFAULT NULL,
  `sql_max` bigint(22) DEFAULT NULL,
  `net_in` bigint(22) DEFAULT NULL,
  `net_out` bigint(22) DEFAULT NULL,
  `time_count` varchar(100) DEFAULT NULL,
  `ttl_count` varchar(100) DEFAULT NULL,
  `last_time` bigint(20) DEFAULT NULL COMMENT '时间戳',
  `sql_table` varchar(100) DEFAULT NULL,
  `relatable` varchar(100) DEFAULT NULL,
  `relacount` varchar(100) DEFAULT NULL,
  `collect_type` char(1) DEFAULT NULL COMMENT '0:all | 1:user | 2:table',
  `server_id` int(11) DEFAULT NULL COMMENT 'mycat 节点id',
  `collect_time` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`sid`,`id`),
  UNIQUE KEY `sid_UNIQUE` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=385 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mysql_cluster`
--

DROP TABLE IF EXISTS `mysql_cluster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mysql_cluster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '集群名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mysql_server`
--

DROP TABLE IF EXISTS `mysql_server`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mysql_server` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `host` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '主机地址',
  `port` int(10) NOT NULL COMMENT '端口',
  `username` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `tags` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标签',
  `cluster_id` bigint(20) DEFAULT NULL COMMENT '归属于哪个集群id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `ver` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  KEY `idx_host` (`host`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mysql_status_history`
--

DROP TABLE IF EXISTS `mysql_status_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mysql_status_history` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `server_id` bigint(4) NOT NULL DEFAULT '0',
  `uptime` varchar(50) NOT NULL DEFAULT '0',
  `open_tables` int(4) NOT NULL DEFAULT '0' COMMENT '打开的表数量',
  `threads_connected` int(10) NOT NULL DEFAULT '0' COMMENT '已连接的线程数',
  `threads_running` int(10) NOT NULL DEFAULT '0' COMMENT '正在运行的线程数',
  `threads_created` int(10) NOT NULL DEFAULT '0' COMMENT '已创建的线程数',
  `threads_cached` int(10) NOT NULL DEFAULT '0' COMMENT '已缓存的线程数',
  `connections` int(10) NOT NULL DEFAULT '0' COMMENT '连接数',
  `aborted_clients` int(10) NOT NULL DEFAULT '0' COMMENT '中止的客户端数量',
  `aborted_connects` int(10) NOT NULL DEFAULT '0' COMMENT '中止的连接数',
  `bytes_received` bigint(10) NOT NULL DEFAULT '0' COMMENT '接受的数据量',
  `bytes_received_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒接受的数据量',
  `bytes_sent` bigint(10) NOT NULL DEFAULT '0' COMMENT '发送的数据量',
  `bytes_sent_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒发送的数据量',
  `com_select` bigint(11) NOT NULL DEFAULT '0' COMMENT 'select语句数量',
  `com_select_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒select语句数量',
  `com_insert` bigint(11) NOT NULL DEFAULT '0' COMMENT 'insert语句数量',
  `com_insert_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒insert语句数量',
  `com_update` bigint(11) NOT NULL DEFAULT '0' COMMENT 'update语句数量',
  `com_update_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒update语句数量',
  `com_delete` bigint(11) NOT NULL DEFAULT '0' COMMENT 'delete语句数量',
  `com_delete_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒delete语句数量',
  `com_commit` bigint(11) NOT NULL DEFAULT '0' COMMENT '事务提交数量',
  `com_commit_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒事务提交数量',
  `com_rollback` bigint(11) NOT NULL DEFAULT '0' COMMENT '事务回滚数量',
  `com_rollback_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒事务回滚数量',
  `questions` bigint(11) NOT NULL DEFAULT '0' COMMENT '请求数',
  `questions_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒请求数',
  `transactions` bigint(11) NOT NULL DEFAULT '0' COMMENT '事务数',
  `transactions_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒事务数',
  `created_tmp_tables` bigint(11) NOT NULL DEFAULT '0' COMMENT '创建临时表的数量',
  `created_tmp_tables_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒创建临时表的数量',
  `created_tmp_disk_tables` bigint(11) NOT NULL DEFAULT '0' COMMENT '创建临时磁盘表数量',
  `created_tmp_disk_tables_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒创建临时磁盘表数量',
  `created_tmp_files` bigint(11) NOT NULL DEFAULT '0' COMMENT '创建临时文件',
  `created_tmp_files_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒创建临时文件',
  `innodb_data_reads` bigint(10) NOT NULL DEFAULT '0' COMMENT '从文件中读取的次数',
  `innodb_data_reads_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒从文件中读取的次数',
  `innodb_data_writes` bigint(10) NOT NULL DEFAULT '0' COMMENT '从文件中写入的次数',
  `innodb_data_writes_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒从文件中写入的次数',
  `innodb_data_fsyncs` bigint(2) NOT NULL DEFAULT '0' COMMENT '进行fsync()操作的次数',
  `innodb_data_fsyncs_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒进行fsync()操作的次数',
  `innodb_data_read` bigint(2) NOT NULL DEFAULT '0' COMMENT '读取的数据量，单位为KB',
  `innodb_data_read_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒读取的数据量，单位为KB',
  `innodb_data_written` bigint(10) NOT NULL DEFAULT '0' COMMENT '写入的数据量，单位为KB',
  `innodb_data_written_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒写入的数据量，单位为KB',
  `innodb_buffer_pool_pages_dirty` bigint(10) NOT NULL DEFAULT '0' COMMENT '缓存池中脏页的数目-单位page',
  `innodb_buffer_pool_pages_dirty_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒缓存池中生成脏页的数目-单位page',
  `innodb_buffer_pool_pages_flushed` bigint(18) NOT NULL DEFAULT '0' COMMENT '缓存池中刷新页请求的数目-单位page',
  `innodb_buffer_pool_pages_flushed_persecond` varchar(50) NOT NULL DEFAULT '0' COMMENT '每秒缓存池中刷新页请求的数目-单位page',
  `innodb_buffer_read_hit_ratio` varchar(10) NOT NULL DEFAULT '0' COMMENT '缓冲池的读命中率: ( 1 - Innodb_buffer_pool_reads/Innodb_buffer_pool_read_requests) * 100',
  `innodb_buffer_usage` varchar(10) NOT NULL DEFAULT '0' COMMENT '缓冲池的利用率 :  ( 1 - Innodb_buffer_pool_pages_free / Innodb_buffer_pool_pages_total) * 100',
  `innodb_rows_inserted` bigint(11) NOT NULL DEFAULT '0' COMMENT '从innodb表插入的行数',
  `innodb_rows_inserted_persecond` varchar(10) NOT NULL DEFAULT '0' COMMENT '每秒从innodb表插入的行数',
  `innodb_rows_updated` bigint(11) NOT NULL DEFAULT '0' COMMENT '从innodb表更新的行数',
  `innodb_rows_updated_persecond` varchar(10) NOT NULL DEFAULT '0' COMMENT '每秒从innodb表更新的行数',
  `innodb_rows_deleted` bigint(11) NOT NULL DEFAULT '0' COMMENT '从innodb表删除的行数',
  `innodb_rows_deleted_persecond` varchar(10) NOT NULL DEFAULT '0' COMMENT '每秒从innodb表删除的行数',
  `innodb_buffer_pool_pages_total` bigint(20) DEFAULT '0',
  `innodb_buffer_pool_pages_free` bigint(20) DEFAULT '0',
  `innodb_page_size` int(11) DEFAULT '16384',
  `slow_queries` int(11) NOT NULL DEFAULT '0' COMMENT '慢查询数量',
  `slave_delay` bigint(11) NOT NULL DEFAULT '0' COMMENT '备库延迟',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_server_id_create_time` (`server_id`,`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=77277 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mysql_weak_password`
--

DROP TABLE IF EXISTS `mysql_weak_password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mysql_weak_password` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plaintext` varchar(100) NOT NULL COMMENT '密码明文',
  `ciphertext` varchar(200) NOT NULL COMMENT '密码密文',
  PRIMARY KEY (`id`),
  KEY `idx_ciphertext` (`ciphertext`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码（MD5密文）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`),
  KEY `idx_test` (`password`,`create_time`,`modify_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 20:57:14
