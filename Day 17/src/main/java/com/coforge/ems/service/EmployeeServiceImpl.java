package com.coforge.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo repo;
	private Environment environment;
	
	public EmployeeServiceImpl(EmployeeRepo repo, Environment environment) {
		super();
		this.repo = repo;
		this.environment = environment;
	}

	@Override
	public boolean saveEmployee(Employee employee) {

		repo.save(employee);

		return true;
	}

	@Override
	public boolean UpdateEmployee(int eid, Employee employee)
			throws InvalidEmployeeObjectException, EmployeeNotFoundException {

		if (!repo.existsById(eid)) {
			throw new EmployeeNotFoundException(
					environment.getProperty("ems.invalid.employee-notfound"));
		}

		repo.save(employee);

		return true;
	}

	@Override
	public boolean deleteEmployee(int eid)
			throws InvalidEmployeeObjectException, EmployeeNotFoundException {

		if (!repo.existsById(eid)) {
			throw new EmployeeNotFoundException(
					environment.getProperty("ems.invalid.employee-notfound"));
		}

		repo.deleteById(eid);

		return true;
	}

	@Override
	public Optional<Employee> findEmployee(int eid)
			throws EmployeeNotFoundException, InvalidEmployeeObjectException {

		if (!repo.existsById(eid)) {
			throw new EmployeeNotFoundException(
					environment.getProperty("ems.invalid.employee-notfound"));
		}

		return repo.findById(eid);
	}

	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> employee = (List<Employee>) repo.findAll();
		return employee;
	}

	@Override
	public List<Employee> FindByEname(String ename)
			throws InvalidEmployeeObjectException {

		if (ename != null) {
			return repo.findByEname(ename);
		}

		throw new InvalidEmployeeObjectException(
				environment.getProperty("ems.invalid.employee-details"));
	}

	@Override
	@Transactional
	public boolean deleteByEname(String ename)
			throws InvalidEmployeeObjectException {

		if (ename != null) {

			repo.deleteByEname(ename);

			return true;
		}

		throw new InvalidEmployeeObjectException(
				environment.getProperty("ems.invalid.employee-details"));
	}
	
	@Override
	public List<Integer> getEidsList() {
		return repo.getEids();
	}

	@Override
	public List<Object[]> getEmployeeStatistics() {
		return repo.getEmployeeStatistics();
	}

	

	

}
