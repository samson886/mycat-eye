# MyCAT EYE
MySQL数据库监控工具，实现了对MySQL节点的管理和监控，可供开发人员和DBA使用。后续版本将整合MyCAT2.0的管理和配置。

## 版本更新：
### 0.7：
初始版本，完成对MySQL监控的基础功能。

## 支持MySQL版本：
目前被监控的MySQL版本只支持5.7

## 演示地址：
开发人员视图：http://120.77.46.146:7001 

DBA或管理人员视图：http://120.77.46.146:7002 登录用户名、密码:admin/admin

## 基本架构：
![图片描述](http://112.74.163.112:8085/tmp/mycateye/0.png)

## 安装环境：

推荐：centos7（6.*也可以）、MySQL5.7、JDK8

端口预留：7001 7002 7003 3306

7001预留给mycateye-web，7002预留给mycateye-admin,7003预留给mycateye-agent,3306预留给MySQL。

## 安装步骤：

1、安装初始数据，在MySQL数据库上新建mycat_eye数据库，导入build/mycat_eye.sql文件。新建数据库账户:dev，密码：123456

2、将build目录中的三个jar文件传输到服务器。

1）首先启动mycateye-agent-xx.jar,执行：java -jar mycateye-agent-xx.jar &

2）再启动mycateye-admin-xx.jar,执行：java -jar mycateye-admin-xx.jar --agent.url=http://{ip}:7003 &

注意：由于该项目使用ajax跨域请求，如果需要在外网访问，则这里的IP需要填写服务器外网IP，如果只在局域网使用则填写服务器的内网IP，例如：java -jar mycateye-admin-xx.jar --agent.host=http://192.168.0.100:7003 &



3）最后启动mycateye-web-xx.jar,执行：java -jar mycateye-web-xx.jar --agent.url=http://{ip}:7003 &

同样这里的IP和mycateye-admin配置一致。


如需在后台启动请使用：nohup java -jar mycateye-xx-xx.jar > /dev/null 2>&1 & 启动各应用。

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
* fastadmin
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
