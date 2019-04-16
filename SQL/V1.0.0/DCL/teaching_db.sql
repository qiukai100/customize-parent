-- 数据库控制语言
create user 'teaching'@'%' identified by '123456';

grant all privileges on *.* to 'teaching'@'%';

create database if not exists teaching;

use teaching;