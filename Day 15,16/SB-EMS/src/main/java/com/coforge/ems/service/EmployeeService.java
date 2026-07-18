package com.coforge.ems.service;

import java.util.List;
import java.util.Optional;

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;

public interface EmployeeService {

	public boolean saveEmployee(Employee employee) throws InvalidEmployeeObjectException;

	public boolean UpdateEmployee(int eid, Employee employee)throws InvalidEmployeeObjectException, EmployeeNotFoundException ;

	public boolean deleteEmployee(int eid)throws InvalidEmployeeObjectException, EmployeeNotFoundException;

	public Optional<Employee> findEmployee(int eid) throws EmployeeNotFoundException, InvalidEmployeeObjectException;

	public List<Employee> findAllEmployee() throws EmployeeNotFoundException, InvalidEmployeeObjectException;

	public List<Employee> FindByEname(String ename) throws InvalidEmployeeObjectException;

	public boolean deleteByEname(String ename) throws InvalidEmployeeObjectException;

	public List<Integer> getEidsList();

	public List<Object[]> getEmployeeStatistics();
}
