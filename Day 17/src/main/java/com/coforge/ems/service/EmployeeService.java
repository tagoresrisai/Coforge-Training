package com.coforge.ems.service;

import java.util.List;
import java.util.Optional;

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;

public interface EmployeeService {

	public boolean saveEmployee(Employee employee);

	public boolean UpdateEmployee(int eid, Employee employee);

	public boolean deleteEmployee(int eid);

	public Optional<Employee> findEmployee(int eid);

	public List<Employee> findAllEmployee();

	public List<Employee> FindByEname(String ename);

	public boolean deleteByEname(String ename) ;

	public List<Integer> getEidsList();

	public List<Object[]> getEmployeeStatistics();
}
