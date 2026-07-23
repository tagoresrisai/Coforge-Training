package com.coforge.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.ems.model.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

	public List<Employee> findByEname(String ename);

	public void deleteByEname(String ename);

	// Get all Employee IDs
	@Query("select e.eid from Employee e")
	public List<Integer> getEids();

	// Count, Max Salary, Min Salary, Sum Salary
	@Query("select count(e), max(e.esalary), min(e.esalary), sum(e.esalary) from Employee e")
	public List<Object[]> getEmployeeStatistics();

}
