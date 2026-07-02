use coforge

create table tbl_employee(eid integer, ename varchar(30), esalary integer, dno integer);

INSERT INTO tbl_employee VALUES
(101, 'Rahul', 10000,10),
(102, 'Priya', 20000,20),
(103, 'Arjun', 30000,30),
(104, 'Sneha', 25000,10),
(105, 'Kiran', 40000,20);

INSERT INTO tbl_employee VALUES
(106, 'Tagore', 15000,10);

select dno, count(*) as 'Total no.of emp' from tbl_employee group by dno;

select dno, sum(esalary), avg(esalary), min(esalary), max(esalary)
from tbl_employee group by dno;

select dno, sum(esalary), avg(esalary), min(esalary), max(esalary)
from tbl_employee group by dno having min(esalary)>10000;

select dno, sum(esalary), avg(esalary), min(esalary), max(esalary)
from tbl_employee group by dno order by dno desc;

select *
from tbl_employee order by eid desc;

create table tbl_dept(dno integer, dname varchar(30));

insert into tbl_dept values
(10,'Testing'),
(20,'Development');

select dname from tbl_dept where dno =
(select dno from tbl_employee where eid=101);

select * from tbl_employee where dno =
(select dno from tbl_dept where dname='Testing');

select dname from tbl_dept where dno =
(select dno from tbl_employee where ename='Rahul');

select dname from tbl_dept where dno in
(select dno from tbl_employee);

drop table tbl_employee;
drop table tbl_dept;

create table tbl_dept(
dno int primary key,
dname varchar(30));

CREATE TABLE tbl_employee (
    eid INT PRIMARY KEY,
    ename VARCHAR(30) NOT NULL,
    esalary INT CHECK (esalary > 0),
    email VARCHAR(30) UNIQUE,
    dno INT,
    FOREIGN KEY (dno) REFERENCES tbl_dept(dno)
);

insert into tbl_employee values (101,'Tagore',200000,'tagore@gmail.com',10);

drop table tbl_employee;

CREATE TABLE tbl_employee (
    eid INT PRIMARY KEY,
    ename VARCHAR(30) NOT NULL,
    esalary INT CHECK (esalary > 0),
    dno INT
);

DELIMITER //
create procedure insertEmployee(in eid int, in ename varchar(20),
in esalary int, in dno int)
begin
	insert into tbl_employee(eid,ename,esalary,dno)
    values(eid,ename,esalary,dno);
end //

call insertEmployee(101,'Tagore',200000,10);

DELIMITER //
create procedure getEmployeeName(in empid int,out empname varchar(30))
begin
	select ename into empname from tbl_employee where eid=empid;
end //

call getEmployeeName(101,@bname);
select @bname;

DELIMITER //
create function getEmployeeName(empid int) returns varchar(20) deterministic
begin
	declare empname varchar(20);
	select ename into empname from tbl_employee where eid=empid;
    return empname;
end //

select getEmployeeName(101);


