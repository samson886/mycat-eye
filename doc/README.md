# Mycat-eye 监控平台

监控平台分为三大功能模块(MyCat监控、MySql监控、可视化配置)。监控数据从MyCat管理端口获取信息：

```sql
mysql> show @@help;
+------------------------------------------+--------------------------------------------+
| STATEMENT                                | DESCRIPTION                                |
+------------------------------------------+--------------------------------------------+
| show @@time.current                      | Report current timestamp                   |
| show @@time.startup                      | Report startup timestamp                   |
| show @@version                           | Report Mycat Server version                |
| show @@server                            | Report server status                       |√
| show @@threadpool                        | Report threadPool status                   |
| show @@database                          | Report databases                           |
| show @@datanode                          | Report dataNodes                           |
| show @@datanode where schema = ?         | Report dataNodes                           |
| show @@datasource                        | Report dataSources                         |
| show @@datasource where dataNode = ?     | Report dataSources                         |
| show @@datasource.synstatus              | Report datasource data synchronous         |
| show @@datasource.syndetail where name=? | Report datasource data synchronous detail  |
| show @@datasource.cluster                | Report datasource galary cluster variables |
| show @@processor                         | Report processor status                    |
| show @@command                           | Report commands status                     |
| show @@connection                        | Report connection status                   |√
| show @@cache                             | Report system cache usage                  |.
| show @@backend                           | Report backend connection status           |√
| show @@session                           | Report front session details               |
| show @@connection.sql                    | Report connection sql                      |√跟踪当前应用执行sql情况
| show @@sql.execute                       | Report execute status                      |√
| show @@sql.detail where id = ?           | Report execute detail status               |√
| show @@sql                               | Report SQL list                            |√
| show @@sql.high                          | Report Hight Frequency SQL                 |√
| show @@sql.slow                          | Report slow SQL                            |√
| show @@sql.resultset                     | Report BIG RESULTSET SQL                   |√
| show @@sql.sum                           | Report  User RW Stat                       |√
| show @@sql.sum.user                      | Report  User RW Stat                       |√
| show @@sql.sum.table                     | Report  Table RW Stat                      |√
| show @@parser                            | Report parser status                       |
| show @@router                            | Report router status                       |
| show @@heartbeat                         | Report heartbeat status                    |
| show @@heartbeat.detail where name=?     | Report heartbeat current detail            |
| show @@slow where schema = ?             | Report schema slow sql                     |
| show @@slow where datanode = ?           | Report datanode slow sql                   |
| show @@sysparam                          | Report system param                        |
| show @@syslog limit=?                    | Report system mycat.log                    |
| show @@white                             | show mycat white host                      |
| show @@white.set=?,?                     | set mycat white host,[ip,user]             |
| show @@directmemory=1 or 2               | show mycat direct memory usage             |
| switch @@datasource name:index           | Switch dataSource                          |
| kill @@connection id1,id2,...            | Kill the specified connections             |
| stop @@heartbeat name:time               | Pause dataNode heartbeat                   |
| reload @@config                          | Reload basic config from file              |
| reload @@config_all                      | Reload all config from file                |*
| reload @@route                           | Reload route config from file              |
| reload @@user                            | Reload user config from file               |
| reload @@sqlslow=                        | Set Slow SQL Time(ms)                      |
| reload @@user_stat                       | Reset show @@sql  @@sql.sum @@sql.slow     |
| rollback @@config                        | Rollback all config from memory            |
| rollback @@route                         | Rollback route config from memory          |
| rollback @@user                          | Rollback user config from memory           |
| reload @@sqlstat=open                    | Open real-time sql stat analyzer           |
| reload @@sqlstat=close                   | Close real-time sql stat analyzer          |
| offline                                  | Change MyCat status to OFF                 |
| online                                   | Change MyCat status to ON                  |
| clear @@slow where schema = ?            | Clear slow sql by schema                   |
| clear @@slow where datanode = ?          | Clear slow sql by datanode                 |
+------------------------------------------+--------------------------------------------+
```

## Mycat 监控
### Mycat服务
#### Mycat 内存分析 √
```sql
mysql> show @@server;
+--------------+-------------+--------------+------------+---------------+---------------+---------+--------+
| UPTIME       | USED_MEMORY | TOTAL_MEMORY | MAX_MEMORY | RELOAD_TIME   | ROLLBACK_TIME | CHARSET | STATUS |
+--------------+-------------+--------------+------------+---------------+---------------+---------+--------+
| 16h 32m 55s  |    90145912 |    182976512 | 1908932608 | 1524574388986 |            -1 | utf8    | ON     |
+--------------+-------------+--------------+------------+---------------+---------------+---------+--------+
```

```sql
mysql> show @@directmemory=1 or 2 ;
+----------------------+--------------------+-------------------------+-----------------+------------------------+
| MDIRECT_MEMORY_MAXED | DIRECT_MEMORY_USED | DIRECT_MEMORY_AVAILABLE | SAFETY_FRACTION | DIRECT_MEMORY_RESERVED |
+----------------------+--------------------+-------------------------+-----------------+------------------------+
| 1820MB               | 64KB               | 1274MB                  | 0.7             | 450MB                  |
+----------------------+--------------------+-------------------------+-----------------+------------------------+
```

#### Mycat 连接分析 √
* 前端
```sql
mysql> show @@connection;
+------------+------+-----------+------+------------+------+--------+---------+--------+---------+---------------+-------------+------------+---------+------------+
| PROCESSOR  | ID   | HOST      | PORT | LOCAL_PORT | USER | SCHEMA | CHARSET | NET_IN | NET_OUT | ALIVE_TIME(S) | RECV_BUFFER | SEND_QUEUE | txlevel | autocommit |
+------------+------+-----------+------+------------+------+--------+---------+--------+---------+---------------+-------------+------------+---------+------------+
| Processor1 |    1 | 127.0.0.1 | 9066 |      61721 | root | NULL   | utf8:33 |    378 |    5399 |          1298 |        4096 |          0 |         |            |
+------------+------+-----------+------+------------+------+--------+---------+--------+---------+---------------+-------------+------------+---------+------------+
```

* 后端 
```sql
mysql> show @@backend;
+------------+------+---------+---------------+------+--------+--------+---------+------+--------+----------+------------+--------+----------+---------+------------+
| processor  | id   | mysqlId | host          | port | l_port | net_in | net_out | life | closed | borrowed | SEND_QUEUE | schema | charset  | txlevel | autocommit |
+------------+------+---------+---------------+------+--------+--------+---------+------+--------+----------+------------+--------+----------+---------+------------+
| Processor0 |   48 |     597 | 127.0.0.1 | 3308 |  61152 |   2226 |     552 | 1919 | false  | false    |          0 | db3    | latin1:5 | 3       | true       |
| Processor0 |   52 |     632 | 127.0.0.1 | 3307 |  61398 |   1831 |     462 | 1746 | false  | false    |          0 | db3    | latin1:5 | 3       | true       |
```

#### Mycat 缓存
```sql
mysql> show @@cache;
+-------------------------------------+-------+------+--------+------+------+-------------+----------+
| CACHE                               | MAX   | CUR  | ACCESS | HIT  | PUT  | LAST_ACCESS | LAST_PUT |
+-------------------------------------+-------+------+--------+------+------+-------------+----------+
| ER_SQL2PARENTID                     |  1000 |    0 |      0 |    0 |    0 |           0 |        0 |
| SQLRouteCache                       | 10000 |    0 |      0 |    0 |    0 |           0 |        0 |
| TableID2DataNodeCache.TESTDB_ORDERS | 50000 |    0 |      0 |    0 |    0 |           0 |        0 |
+-------------------------------------+-------+------+--------+------+------+-------------+----------+
```

### 数据源
```sql
mysql> show @@datasource;
+----------+--------+-------+---------------+------+------+--------+------+------+---------+-----------+------------+
| DATANODE | NAME   | TYPE  | HOST          | PORT | W/R  | ACTIVE | IDLE | SIZE | EXECUTE | READ_LOAD | WRITE_LOAD |
+----------+--------+-------+---------------+------+------+--------+------+------+---------+-----------+------------+
| dn1      | hostM1 | mysql | 127.0.0.1 | 3306 | W    |      0 |    0 | 1000 |       0 |         0 |          0 |
| dn1      | hostS1 | mysql | 127.0.0.1 | 3308 | W    |      0 |    8 | 1000 |     895 |         0 |          0 |
| dn1      | hostS2 | mysql | 127.0.0.1 | 3307 | R    |      0 |    8 | 1000 |     893 |         0 |          0 |
| dn3      | hostM1 | mysql | 127.0.0.1 | 3306 | W    |      0 |    0 | 1000 |       0 |         0 |          0 |
| dn3      | hostS1 | mysql | 127.0.0.1 | 3308 | W    |      0 |    8 | 1000 |     895 |         0 |          0 |
| dn3      | hostS2 | mysql | 127.0.0.1 | 3307 | R    |      0 |    8 | 1000 |     893 |         0 |          0 |
| dn2      | hostM1 | mysql | 127.0.0.1 | 3306 | W    |      0 |    0 | 1000 |       0 |         0 |          0 |
| dn2      | hostS1 | mysql | 127.0.0.1 | 3308 | W    |      0 |    8 | 1000 |     895 |         0 |          0 |
| dn2      | hostS2 | mysql | 127.0.0.1 | 3307 | R    |      0 |    8 | 1000 |     893 |         0 |          0 |
+----------+--------+-------+---------------+------+------+--------+------+------+---------+-----------+------------+
```

### 数据节点
```sql

```

### SQL 监控
#### sql 执行信息 √
```sql
mysql> show @@sql.execute;
+--------+---------+-------+----------+----------+
| SQL_ID | EXECUTE | TIME  | MAX_TIME | MIN_TIME |
+--------+---------+-------+----------+----------+
|   1000 |     100 | 898.9 |      8.8 |        1 |
|   2000 |     100 | 898.9 |      8.8 |        1 |
|   3000 |     100 | 898.9 |      8.8 |        1 |
+--------+---------+-------+----------+----------+
```

#### sql 执行信息明细 √
```sql
mysql> show @@sql.detail where id = 2000;
+-------------+---------+------+------------------------+-----------+
| DATA_SOURCE | EXECUTE | TIME | LAST_EXECUTE_TIMESTAMP | LAST_TIME |
+-------------+---------+------+------------------------+-----------+
| mysql_1     |     123 |  2.3 |          1279188420682 |      3.42 |
| mysql_1     |     123 |  2.3 |          1279188420682 |      3.42 |
| mysql_1     |     123 |  2.3 |          1279188420682 |      3.42 |
+-------------+---------+------+------------------------+-----------+
```


#### 显示sql列表 √
```sql
mysql> show @@sql;
+------+------+---------------+--------------+-------------------------------------------+
| ID   | USER | START_TIME    | EXECUTE_TIME | SQL                                       |
+------+------+---------------+--------------+-------------------------------------------+
|    1 | root | 1524583496990 |          597 | insert into hotnews(id,nm) values(6,'nm') |
+------+------+---------------+--------------+-------------------------------------------+
```

#### Report Hight Frequency SQL √
```sql
mysql> show @@sql.high;
+------+------+-----------+----------+----------+----------+--------------+---------------+--------------------------------------------+
| ID   | USER | FREQUENCY | AVG_TIME | MAX_TIME | MIN_TIME | EXECUTE_TIME | LAST_TIME     | SQL                                        |
+------+------+-----------+----------+----------+----------+--------------+---------------+--------------------------------------------+
|    1 | root |         1 |      597 |      597 |      597 |          597 | 1524583497587 | INSERT INTO hotnews (id, nm) VALUES (?, ?) |
+------+------+-----------+----------+----------+----------+--------------+---------------+--------------------------------------------+
```

#### Report slow SQL √
```sql
mysql> show @@sql.slow;
+------+------------+---------------+--------------+-------------------------------------------+
| USER | DATASOURCE | START_TIME    | EXECUTE_TIME | SQL                                       |
+------+------------+---------------+--------------+-------------------------------------------+
| root | NULL       | 1524583496990 |          597 | insert into hotnews(id,nm) values(6,'nm') |
+------+------------+---------------+--------------+-------------------------------------------+
```

#### Report BIG RESULTSET SQL 
```sql

```

#### Report RW Stat √
```sql
mysql> show @@sql.sum;
+------+------+------+------+------+------+--------+---------+--------------+--------------+---------------+
| ID   | USER | R    | W    | R%   | MAX  | NET_IN | NET_OUT | TIME_COUNT   | TTL_COUNT    | LAST_TIME     |
+------+------+------+------+------+------+--------+---------+--------------+--------------+---------------+
|    1 | root |    2 |    1 | 0.67 | 1    |     41 |     779 | [3, 0, 0, 0] | [0, 2, 1, 0] | 1524583697975 |
+------+------+------+------+------+------+--------+---------+--------------+--------------+---------------+
```

#### Report User RW Stat √
```sql
mysql> show @@sql.sum.user;
+------+------+------+------+------+------+--------+---------+--------------+--------------+---------------+
| ID   | USER | R    | W    | R%   | MAX  | NET_IN | NET_OUT | TIME_COUNT   | TTL_COUNT    | LAST_TIME     |
+------+------+------+------+------+------+--------+---------+--------------+--------------+---------------+
|    1 | root |    2 |    1 | 0.67 | 1    |     41 |     779 | [3, 0, 0, 0] | [0, 2, 1, 0] | 1524583697975 |
+------+------+------+------+------+------+--------+---------+--------------+--------------+---------------+
```

#### Report Table RW Stat √
```sql
mysql> show @@sql.sum.table;
+------+---------+------+------+------+-----------+-----------+---------------+
| ID   | TABLE   | R    | W    | R%   | RELATABLE | RELACOUNT | LAST_TIME     |
+------+---------+------+------+------+-----------+-----------+---------------+
|    1 | hotnews |    2 |    1 | 0.67 | NULL      | NULL      | 1524583697975 |
+------+---------+------+------+------+-----------+-----------+---------------+
```

## Mysql 监控



## 工具
* 查看库里面所有表，批量设置
* 验证



