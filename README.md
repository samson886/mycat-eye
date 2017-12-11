# MyCAT EYE
MySQL数据库监控工具，实现了对MySQL节点的管理和监控，可供开发人员和DBA使用。后续版本将整合MyCAT2.0的管理和配置。

## 版本更新：
### 0.8：
1、整合两个前端界面模块为mycateye-web；

2、修改控制台界面样式；

3、新增事务查看、锁等待查看等功能。
### 0.7：
初始版本，完成对MySQL监控的基础功能。

## 支持MySQL版本：
目前被监控的MySQL版本支持5.7（推荐），5.6。

## 演示地址：
开发人员视图：http://122.112.238.95:7001 

DBA或管理人员视图：http://122.112.238.95:7001/admin/index.html 登录用户名、密码:admin/admin

## 基本架构：
![图片描述](http://112.74.163.112:8085/tmp/mycateye/0.png)

## 安装环境：

推荐：centos7（6.*也可以）、MySQL5.7、JDK8

端口预留：7001 7003 3306

7001预留给mycateye-web，7003预留给mycateye-agent,3306预留给MySQL。

## 安装步骤：

1、安装初始数据，在MySQL数据库上新建mycat_eye数据库，导入build/mycat_eye.sql文件。新建数据库账户:dev，密码：123456

2、将build目录中的2个jar文件传输到服务器。

1）启动mycateye-agent-xx.jar,执行：java -jar mycateye-agent-0.8.jar --mysql.host=localhost &

2）启动mycateye-web-xx.jar,执行：java -jar mycateye-web-0.8.jar --mysql.host=localhost --agent.url=http://{ip}:7003/agent &

注意：由于该项目使用ajax跨域请求，如果需要在外网访问，则这里的IP需要填写服务器外网IP，如果只在局域网使用则填写服务器的内网IP，例如：java -jar mycateye-web-0.8.jar --agent.url=http://192.168.0.100:7003 &



如需在后台启动请使用：nohup启动各应用。

## 快速开始：
以下假设你的服务器IP为192.168.0.100，实际环境中将它替换为你的服务器IP即可。

### 登录管理视图：
登录http://192.168.0.100:7002

![图片描述](http://112.74.163.112:8085/tmp/mycateye/1.png)

初始安装后，没有任何MySQL节点，你首先需要添加一个MySQL节点。

![图片描述](http://112.74.163.112:8085/tmp/mycateye/4.png)
![图片描述](http://112.74.163.112:8085/tmp/mycateye/5.png)
![图片描述](http://112.74.163.112:8085/tmp/mycateye/6.png)

刷新或重新登录后，就可以使用了。

![图片描述](http://112.74.163.112:8085/tmp/mycateye/8.png)
![图片描述](http://112.74.163.112:8085/tmp/mycateye/9.png)
![图片描述](http://112.74.163.112:8085/tmp/mycateye/10.png)

### 使用开发者视图：
浏览器打开http://192.168.0.100:7001

![图片描述](http://112.74.163.112:8085/tmp/mycateye/11.png)
![图片描述](http://112.74.163.112:8085/tmp/mycateye/12.png)
![图片描述](http://112.74.163.112:8085/tmp/mycateye/13.png)
![图片描述](http://112.74.163.112:8085/tmp/mycateye/14.png)
![图片描述](http://112.74.163.112:8085/tmp/mycateye/15.png)
![图片描述](http://112.74.163.112:8085/tmp/mycateye/16.png)
![图片描述](http://112.74.163.112:8085/tmp/mycateye/17.png)
![图片描述](http://112.74.163.112:8085/tmp/mycateye/18.png)

## 该项目使用的技术：

### 前端：
* bootstrap3
* jquery1.11
* ECharts3
* vis

### 后端：
* springboot 1.5.4
* druid1.0
* mybatis3.4
* ehcache2.10
* fastjson1.2
* logback1.1

### 数据库：
* MySQL5.7


## 联系：
360841519@qq.com
