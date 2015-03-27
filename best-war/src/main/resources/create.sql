drop table cathegory if exists;
create table cathegory(
c_id bigint primary key auto_increment , 
c_name varchar2(255)
);

drop table author if exists;
create table author(
a_id bigint primary key auto_increment, 
a_name varchar2(255));

drop table book if exists;
create table book(
b_id bigint primary key auto_increment , 
b_title varchar2(255),
c_id bigint,
FOREIGN KEY (c_id) REFERENCES cathegory(c_id)  
);

drop table author_book if exists;
create table author_book(
i_id bigint primary key auto_increment , 
a_id bigint,
b_id bigint,
FOREIGN KEY (a_id) REFERENCES author(a_id) ,
 FOREIGN KEY (b_id) REFERENCES book(b_id) 
);

insert into cathegory(c_id,c_name) values(1,'cat 1');
insert into cathegory(c_id,c_name) values(2,'cat 2');
insert into cathegory(c_id,c_name) values(3,'cat 3');


insert into author(a_id,a_name) values(1,'autor 1');
insert into author(a_id,a_name) values(2,'autor 2');
insert into author(a_id,a_name) values(3,'autor 3');
insert into author(a_id,a_name) values(4,'autor 4');
insert into author(a_id,a_name) values(5,'autor 5');

insert into book(b_id,b_title,c_id) values(1,'tytul 1',1);
insert into book(b_id,b_title,c_id) values(2,'tytul 2',2);
insert into book(b_id,b_title,c_id) values(3,'tytul 3',3);
insert into book(b_id,b_title,c_id) values(4,'tytul 4',1);
insert into book(b_id,b_title,c_id) values(5,'tytul 5',1);
insert into book(b_id,b_title,c_id) values(6,'tytul 6',1);
insert into book(b_id,b_title,c_id) values(7,'tytul 7',2);
insert into book(b_id,b_title,c_id) values(8,'tytul 8',2);
insert into book(b_id,b_title,c_id) values(9,'tytul 9',3);

insert into author_book(i_id,a_id,b_id) values(1,1,1);
insert into author_book(i_id,a_id,b_id) values(2,1,2);
insert into author_book(i_id,a_id,b_id) values(3,1,3);
insert into author_book(i_id,a_id,b_id) values(4,2,1);
insert into author_book(i_id,a_id,b_id) values(5,2,9);
insert into author_book(i_id,a_id,b_id) values(6,2,8);
insert into author_book(i_id,a_id,b_id) values(7,2,7);
insert into author_book(i_id,a_id,b_id) values(8,3,6);
insert into author_book(i_id,a_id,b_id) values(9,3,5);
insert into author_book(i_id,a_id,b_id) values(10,3,8);
insert into author_book(i_id,a_id,b_id) values(11,3,4);
insert into author_book(i_id,a_id,b_id) values(12,4,3);
insert into author_book(i_id,a_id,b_id) values(13,4,2);





