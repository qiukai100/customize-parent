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
    
##3、待完成事项
    1、hbase单机版集成（文件上传）
    2、spring cloud搭建（部署微服务）
    3、shiro集成
    4、前端（vue）构建
    5、mongodb单机版集成（记录日志）
    6、quartz集成
    7、使用nginx代理
    8、mqtt（activemq）集成
    9、activity集成
    10、websocket集成
    11、线程池扩展（高并发、自定义线程）
    12、redis缓存、集群、哨兵
    13、druid换成hikari

    

    