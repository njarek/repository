drop  SEQUENCE HIBERNATE_SEQUENCE if exists;
create SEQUENCE HIBERNATE_SEQUENCE;

drop table GENERATOR_TABLE if exists;
create table GENERATOR_TABLE (
    key_name varchar(80),
    next integer
);

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

drop table agd if exists;
create table agd(
a_id bigint primary key auto_increment , 
I_location varchar2(255),
 FOREIGN KEY (a_id) REFERENCES item(i_id) 
);

drop table fridge if exists;
create table fridge(
f_id bigint primary key auto_increment , 
I_color varchar2(255),
 FOREIGN KEY (f_id) REFERENCES agd(a_id) 
);

drop table LIFECYCLE if exists;
create table LIFECYCLE(
l_id bigint primary key auto_increment , 
l_version bigint,
b_id bigint,
l_lifecycle varchar2(255),
 FOREIGN KEY (b_id) REFERENCES basket(b_id) 
);

