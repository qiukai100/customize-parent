##1、安装及配置
####1.1 redis
    1、windows下连接 redis
        redis/bin 目录下执行 redis-cli -h 127.0.0.1 -p 6379 -a 12345
        或者直接执行 redis-cli.exe -h 127.0.0.1 -p 6379（配置了环境变量）
    2、切换数据库（切换到1）
        select 1
    3、无权限时（认证密码为123456）
        auth '123456'
       
####1.2 hbase
    1、windows下启动 hbase
        hbase/bin 目录下执行 start-hbase.cmd
    2、windows下连接 hbase
        hbase/bin 目录下执行 hbase shell
    3、linux下启动 hbase
        hbase/bin 目录下 ./start-hbase.sh
    4、linux下进入 hbase
        hbase/bin 目录下执行 hbase shell
        配置了环境变量则直接执行 hbase shell
        
####1.3 mysql
    1、启动mysql
        service mysql start
    2、连接mysql
        mysql -uroot -p123456
    
##2、已完成事项
####2.1 mysql
    1、采用druid连接池及sql监控
    
####2.2 mybatis
    1、采用Pagehelper进行分页
    
####2.3 hibernate
    1、采用JPA规范
    2、对service层进行了简单封装并与mybatis联合使用
    
####2.4 redis
    1、单机版部署
    
####2.5 Executor
    1、普通多线程池
    
####2.6 log4j2
    1、替代spring boot默认的日志框架
    
####2.7 spring cloud
    1、eureka 注册中心、注册发现
    2、feign 服务调用，并支持文件传输、多文件传输
    3、hystrix 熔断器
    
####2.8 hbase
    1、单机版部署
    
##3、待完成事项
    1、generator-server 切换数据源（JDBC），支持ORACLE
    2、manage-server 增加接口文档swagger
    3、增加网关
    3、manage-server 增加Spring Security、JWT鉴权
    4、redis-server 切换DB，哨兵模式
    5、拆分quartz服务

    

    