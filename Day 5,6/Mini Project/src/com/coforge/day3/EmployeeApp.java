package com.coforge.day3;

public class EmployeeApp {

	public static void main(String[] args) {
		Employee emp = new Employee(101,"Tagore",200000);
		emp.display();
		emp.setSalary(500000);
		System.out.println(emp.getSalary());
	}

}
