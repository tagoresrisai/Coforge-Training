CREATE DATABASE EmployeeManagement;
USE EmployeeManagement;

CREATE TABLE Department (
   DeptID INT PRIMARY KEY,
   DeptName VARCHAR(50),
   Location VARCHAR(50)
);

INSERT INTO Department VALUES
(101,'HR','Hyderabad'),
(102,'Finance','Mumbai'),
(103,'IT','Bangalore'),
(104,'Sales','Chennai');

CREATE TABLE Employee (
   EmpID INT PRIMARY KEY,
   EmpName VARCHAR(50),
   Gender VARCHAR(10),
   Age INT,
   Salary DECIMAL(10,2),
   Designation VARCHAR(50),
   DeptID INT,
   HireDate DATE,
   FOREIGN KEY (DeptID) REFERENCES Department(DeptID)
);

INSERT INTO Employee VALUES
(1,'Amit','Male',28,45000,'Software Engineer',103,'2022-05-10'),
(2,'Priya','Female',30,55000,'HR Manager',101,'2021-03-15'),
(3,'Rahul','Male',27,50000,'Accountant',102,'2023-01-20'),
(4,'Sneha','Female',25,42000,'Sales Executive',104,'2022-09-12'),
(5,'Kiran','Male',31,60000,'Team Lead',103,'2020-11-18');

CREATE TABLE Attendance (
   AttendanceID INT PRIMARY KEY,
   EmpID INT,
   AttendanceDate DATE,
   Status VARCHAR(10),
   FOREIGN KEY (EmpID) REFERENCES Employee(EmpID)
);

INSERT INTO Attendance VALUES
(1,1,'2026-07-01','Present'),
(2,2,'2026-07-01','Present'),
(3,3,'2026-07-01','Absent'),
(4,4,'2026-07-01','Present'),
(5,5,'2026-07-01','Present');

select count(*) from employee;
select max(salary) from employee;
select min(salary) from employee;
select avg(salary) from employee;
select sum(salary) from employee;

select deptid, count(*) from employee group by deptid;
select deptid, avg(salary) from employee group by deptid;
select deptid, max(salary) from employee group by deptid;

select e.empname, d.deptname from employee e, department d
where e.deptid=d.deptid;

select e.empname, d.deptname, d.location from employee e, department d
where e.deptid=d.deptid;

SELECT e.EmpName, a.AttendanceDate, a.Status
FROM Employee e
JOIN Attendance a
ON e.EmpID = a.EmpID;

update employee set salary = salary + salary*0.1 where deptid =
(select deptid from department where deptname='it');

UPDATE Employee
SET Designation = 'Senior Software Engineer'
WHERE EmpID = 1;

UPDATE Employee
SET DeptID = 102
WHERE EmpID = 1;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM Employee
WHERE Salary < 40000;

DELETE FROM Attendance
WHERE AttendanceDate = '2026-07-01';

CREATE VIEW EmployeeDetails AS
SELECT e.EmpID, e.EmpName, d.DeptName, e.Salary
FROM Employee e
JOIN Department d
ON e.DeptID = d.DeptID;

DELIMITER //

CREATE PROCEDURE GetEmployees()
BEGIN
    SELECT * FROM Employee;
END //

DELIMITER ;

CALL GetEmployees();