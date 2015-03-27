select * from author;
select * from cathegory;
select * from book;

select a.a_name,b.b_title, c.c_name from author a, book b, cathegory c , author_book ab 
where ab.a_id=a.a_id and ab.b_id=b.b_id and  b.c_id=c.c_id;


select a.a_name,count(b.b_title) ,c.c_name from author a, book b, author_book ab, cathegory c where ab.a_id=a.a_id and ab.b_id=b.b_id  and  b.c_id=c.c_id group by a.a_name,c.c_name order by a.a_name;