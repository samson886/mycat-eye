/*
Navicat MySQL Data Transfer

Source Server         : 112.74.163.112(阿里云DBEYE)
Source Server Version : 50717
Source Host           : 112.74.163.112:3306
Source Database       : mycat_eye

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-29 10:33:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mysql_cluster`
-- ----------------------------
DROP TABLE IF EXISTS `mysql_cluster`;
CREATE TABLE `mysql_cluster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '集群名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mysql_cluster
-- ----------------------------
INSERT INTO `mysql_cluster` VALUES ('1', '默认集群', '2017-09-29 09:02:49');

-- ----------------------------
-- Table structure for `mysql_server`
-- ----------------------------
DROP TABLE IF EXISTS `mysql_server`;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of mysql_server
-- ----------------------------

-- ----------------------------
-- Table structure for `mysql_status_history`
-- ----------------------------
DROP TABLE IF EXISTS `mysql_status_history`;
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
) ENGINE=InnoDB AUTO_INCREMENT=452 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mysql_status_history
-- ----------------------------

-- ----------------------------
-- Table structure for `mysql_weak_password`
-- ----------------------------
DROP TABLE IF EXISTS `mysql_weak_password`;
CREATE TABLE `mysql_weak_password` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plaintext` varchar(100) NOT NULL COMMENT '密码明文',
  `ciphertext` varchar(200) NOT NULL COMMENT '密码密文',
  PRIMARY KEY (`id`),
  KEY `idx_ciphertext` (`ciphertext`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mysql_weak_password
-- ----------------------------
INSERT INTO `mysql_weak_password` VALUES ('1', '123456', '6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
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

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '2017-04-13 17:44:49', '2017-04-13 17:44:56');
