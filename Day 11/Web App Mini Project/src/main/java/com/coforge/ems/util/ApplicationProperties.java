package com.coforge.ems.util;

public class ApplicationProperties {
	// Database Connection Properties
	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/mydatabase";
	public static final String username = "root";
	public static final String password = "Password";

	// Database SQL Queries
	public static final String insertSql = "insert into tbl_employee values (?, ?, ?, ?)";
	public static final String updateSql = "Update tbl_employee set ename = ?, esalary = ?, dno = ? where eid = ?";
	public static final String deleteSql = "delete from tbl_employee where eid = ?";
	public static final String findAllSql = "select * from tbl_employee";
	public static final String findSql = "Select * from tbl_employee where eid = ?";

	// Application Response Properties
	public static final String insertSuccess = "SUCCESS : Employee Record Inserted";
	public static final String updateSuccess = "SUCCESS : Employe Record Updated";
	public static final String deleteSuccess = "SUCCESS : Employee Record Deleted";
	public static final String dbFailed = "FAILED : DB Error";
	public static final String noRecordFound = "FAILED : Employee Not Found";

	// Application Validation Properties
	public static final String validationFailed = "FAILED : Invalid Employee Details";
}
