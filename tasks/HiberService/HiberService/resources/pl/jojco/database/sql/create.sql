drop table pojo if exists;
create table pojo(
id bigint auto_increment, 
name varchar2(255),
number  bigint);

drop table basket if exists;
create table basket(
b_id bigint primary key auto_increment , 
b_name varchar2(255)
);

drop table item if exists;
create table item(
i_id bigint primary key auto_increment , 
b_id bigint,
I_DESCRIPTION varchar2(255),
I_QUANTITY bigint,
 FOREIGN KEY (b_id) REFERENCES basket(b_id) 
);

insert into pojo(number,name) values(22,'elo');

insert into basket(b_name) values('moj');

insert into item(b_id,I_DESCRIPTION,I_QUANTITY) values(1,'tv',1);
insert into item(b_id,I_DESCRIPTION,I_QUANTITY) values(1,'baterie',4);
insert into item(b_id,I_DESCRIPTION,I_QUANTITY) values(1,'pilot',1);
insert into item(b_id,I_DESCRIPTION,I_QUANTITY) values(1,'pralka',1);
insert into item(b_id,I_DESCRIPTION,I_QUANTITY) values(1,'czajnik',2);

