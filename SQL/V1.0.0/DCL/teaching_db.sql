-- 数据库控制语言
create database if not exists teaching;

create user 'teaching'@'%' identified by '123456';

grant all privileges on teaching.* to 'teaching'@'%';

use teaching;