package com.coforge.day5.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCUpdate {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coforge","root","Password");
		
		String sql = "update tbl_employee set esalary=? where eid=?" ;
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, 400000);
		statement.setInt(2, 201);
		
		int n = statement.executeUpdate();//INsert, Delete and Update Query.
		if(n==1) {
			System.out.println("Success");
		}else {
			System.out.println("Nope");
		}
		
	}

}
