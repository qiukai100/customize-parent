create database if not exists enterprise;

create user 'enterprise'@'%' identified by '123456';

grant all privileges on enterprise.* to 'enterprise'@'%';

use enterprise;