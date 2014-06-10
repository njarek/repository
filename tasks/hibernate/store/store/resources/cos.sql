select * from basket;
select * from basket b, item i where b.b_id=i.b_id;
select * from item;
select * from lifecycle;

select I_DESCRIPTION from basket b, item i, lifecycle l where b.b_id=i.b_id and b.b_id=l.b_id;

select basket0_.b_id as b1_1_0_, basket0_.b_name as b2_1_0_, basket0_.b_version as b3_1_0_ from basket basket0_ where basket0_.b_id=1;

select b.i_description , b.i_quantity from (select *  from basket b INNER JOIN item i on b.b_id=i.b_id INNER JOIN lifecycle l on b.b_id=l.b_id where l.l_lifecycle='new' );
														
select *  from basket b INNER JOIN item i on b.b_id=i.b_id INNER JOIN lifecycle l on b.b_id=l.b_id where l.l_lifecycle='new';

select * from item;

select i_description,sum(I_QUANTITY),I_price  from item i, basket b, lifecycle l where i.b_id=b.b_id and b.b_id=l.b_id and l.l_lifecycle='new' group by  i_description,I_price  order by i_description;

select I_DESCRIPTION,I_QUANTITY,I_price from basket b, item i, lifecycle l where b.b_id=i.b_id and b.b_id=l.b_id;