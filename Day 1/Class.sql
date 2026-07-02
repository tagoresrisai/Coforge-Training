create database coforge

use coforge;

CREATE TABLE tbl_employee(
eid INTEGER,
ename VARCHAR(30),
esal INTEGER); 

Desc tbl_employee;

insert into tbl_employee values(102,'raju',20000);

insert into tbl_employee values(103,null,30000);

select * from tbl_employee;

select * from tbl_employee where eid=101;

select * from tbl_employee where eid <> 101;

select ename from tbl_employee where esal<20000

select eid, ename from tbl_employee where ename is null;

select * from tbl_employee where eid in (101,103);
select * from tbl_employee where eid not in (101,103);
select * from tbl_employee where eid in (101,105);

select * from tbl_employee where esal between 10000 and 30000;

select * from tbl_employee where esal not between 20000 and 10000;

select * from tbl_employee where ename like '__j%';

SET SQL_SAFE_UPDATES = 0;

update tbl_employee set esal=0 where eid=101;

delete from tbl_employee where ename is null;

select 'Tagore', 10+20 from tbl_employee;

select eid as "Employee ID", sysdate() as "Date", 'Tagore', 10+20 from tbl_employee;

alter table tbl_employee add column dno integer;

alter table tbl_employee drop column dno;

alter table tbl_employee rename column eid to empid;

truncate table tbl_employee;

rename table tbl_employee to emp;

drop table emp;