CREATE DATABASE School;

USE School;

CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    Name VARCHAR(50),
    Age INT,
    Gender VARCHAR(10),
    City VARCHAR(50)
);

INSERT INTO Students (StudentID, Name, Age, Gender, City) VALUES
(101, 'Rahul', 20, 'Male', 'Hyderabad'),
(102, 'Priya', 19, 'Female', 'Chennai'),
(103, 'Arjun', 21, 'Male', 'Bengaluru'),
(104, 'Sneha', 20, 'Female', 'Mumbai'),
(105, 'Kiran', 22, 'Male', 'Pune');

SELECT * FROM Students;

SELECT Name, City FROM Students;

SELECT * FROM Students WHERE Age > 20;

SELECT * FROM Students WHERE Gender = 'Female';

SELECT * FROM Students WHERE City = 'Hyderabad';

select * from Students order by Name asc;

select * from Students order by Age desc;

select * from Students order by City asc, Name asc;

SELECT * FROM Students WHERE Age BETWEEN 19 AND 21;

SELECT * FROM Students WHERE Name LIKE 'R%';

SELECT * FROM Students WHERE City LIKE '%i';

SELECT * FROM Students WHERE Age IN (20, 22);

update Students set City='Delhi' where Name = 'Rahul';
update Students set Age = Age+1 where Name = 'Arjun';
update Students set City = 'Kolkata' where Name = 'Sneha';

delete from Students where StudentID=105;
delete from students where City = 'Chennai';