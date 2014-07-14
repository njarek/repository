drop table pojo if exists;
create table pojo(
id bigint auto_increment, 
name varchar2(255),
number  bigint);

drop table basket if exists;
create table basket(
b_id bigint primary key auto_increment , 
b_version bigint,
b_name varchar2(255)
);

drop table item if exists;
create table item(
i_id bigint primary key auto_increment , 
i_version bigint,
b_id bigint,
I_DESCRIPTION varchar2(255),
I_QUANTITY bigint,
I_price double,
 FOREIGN KEY (b_id) REFERENCES basket(b_id) 
);

drop table LIFECYCLE if exists;
create table LIFECYCLE(
l_id bigint primary key auto_increment , 
l_version bigint,
b_id bigint,
l_lifecycle varchar2(255),
 FOREIGN KEY (b_id) REFERENCES basket(b_id) 
);


insert into pojo(number,name) values(22,'elo');

insert into basket(b_version,b_name) values(1,'moj');

insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(1,1,'tv',1,2.2);
insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(1,1,'baterie',4,3.2);
insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(1,1,'pilot',1,7.5);
insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(1,1,'pralka',1,1.2);
insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(1,1,'czajnik',2,0.4);

insert into basket(b_version,b_name) values(2,'moj2');

insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(2,1,'tv',1,2.2);
insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(2,1,'baterie',4,2.2);
insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(2,1,'pilot',1,2.2);
insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(2,1,'pralka',1,2.2);
insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(2,1,'czajnik2',2,2.2);

insert into basket(b_version,b_name) values(3,'moj3');

insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(3,1,'tv',1,2.2);
insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(3,1,'baterie',4,3.2);
insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(3,1,'pilot',1,7.5);
insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(3,1,'pralka',1,1.2);
insert into item(b_id,i_version,I_DESCRIPTION,I_QUANTITY,I_price) values(3,1,'czajnik',2,0.4);

insert into LIFECYCLE(b_id,l_version,l_lifecycle) values(1,1,'new');
insert into LIFECYCLE(b_id,l_version,l_lifecycle) values(2,1,'new');
insert into LIFECYCLE(b_id,l_version,l_lifecycle) values(3,1,'modified');
