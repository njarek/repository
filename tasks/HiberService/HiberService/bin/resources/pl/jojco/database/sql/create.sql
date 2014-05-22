drop table pojo if exists;
create table pojo(
id bigint auto_increment, 
name varchar2(255),
number  bigint);

insert into pojo(number,name) values(22,'elo');

