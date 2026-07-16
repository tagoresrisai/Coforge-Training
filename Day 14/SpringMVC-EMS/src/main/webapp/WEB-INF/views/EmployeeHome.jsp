<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<link rel="stylesheet" href="Style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="Header">
		<h1>Employee Management System</h1>
	</div>
	<br>
	<form action = "employee" method = "post">
	<div class="content">
		<table>
			<tr>
			<td>Employee ID : </td>
			<td><input type = "text" name="eid"></td>
			</tr>
			<tr>
			<td>Employee Name : </td>
			<td><input type = "text" name="ename"></td>
			</tr>
			<tr>
			<td>Employee Salary : </td>
			<td><input type = "text" name="esalary"></td>
			</tr>
			<tr>
			<td>Department Number : </td>
			<td><input type = "text" name="dno"></td>
			</tr>

		</table>
		<br>
		<input type="submit"
           name="Insert"
           value="Insert"
           class="btn btn-primary">
		<input type="submit" name="Delete" value="Delete" class="btn btn-danger">

		<input type="submit" name="Update" value="Update" class="btn btn-warning">

		<input type="submit" name="Find" value="Find" class="btn btn-success">

		<input type="submit" name="FindAll" value="FindAll" class="btn btn-info">
	</div>
	</form>
	<br>
	<div>
	<b>${result}</b>
	</div>
</body>
</html>