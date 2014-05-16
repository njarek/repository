drop table pojo if exists;
create table pojo(
id bigint auto_increment, 
name varchar(255),
number  bigint);

insert into pojo(name,number) values("elo",22);