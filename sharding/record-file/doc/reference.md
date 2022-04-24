## 文件存储操作指导
文件存储链接根据业务大类进行分类分表存储：
(1) face: 人脸照片 10张表
(2) access_record：门禁通行记录  10张表
(3) vehicle_record：车辆通行记录 10张表
(4) log：日志文件  10张表
(5) sys：系统资源，附件、视频、图标、压缩包等  5 张表

#### 步骤一：执行sql
sharding/record-file/sql 目录下：首先执行sharding-table.sql (业务表) ，然后执行baidu-uuid.sql(baidu-uid 表)和bucket.sql
备注：数据库建议建立一个独立的新库，库名根据需要自定义，项目sql中为smartzone

#### 步骤二：安装jar
sharding/record-file/jar 目录下：安装 uid-generator-1.0.0-SNAPSHOT.jar，并可有将其推送至项目maven仓库中

#### 步骤三：配置VM options
因本项目引入sky-walking,本地启动项目时需要依赖 skywalking-agent.jar
vm options 配置：-javaagent:D:\plugin\apache-skywalking-java-agent-8.9.0\skywalking-agent\skywalking-agent.jar -Dskywalking.agent.service_name=logDemo -Dskywalking.collector.backend_service=172.21.39.127:11800
上面配置中的skywalking 的 server 端地址和 skywalking-agent.jar 地址根据实际情况更改

#### 步骤四：数据库账号加密
使用 jasypt 对数据库账号加密：com.example.sharding.util.DbEncryptTest 类用于生成数据库账号密码密文



           
          