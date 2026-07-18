package com.coforge.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo repo;
	
	public EmployeeServiceImpl(EmployeeRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public boolean saveEmployee(Employee employee) throws InvalidEmployeeObjectException {
		//validation
		if(employee!=null && employee.getEid()>0 && employee.getEname()!=null && employee.getEsalary()>0 && employee.getDno()>0) {
			repo.save(employee);
			return true;
		}
		else {
			throw new InvalidEmployeeObjectException();
		}
	}

	@Override
	public boolean UpdateEmployee(int eid, Employee employee) throws InvalidEmployeeObjectException, EmployeeNotFoundException {
		if(eid > 0 && employee!=null && employee.getEid()>0 && employee.getEname()!=null && employee.getEsalary()>0 && employee.getDno()>0) {
			if(!repo.existsById(eid)) {
				throw new EmployeeNotFoundException();
			}
			repo.save(employee);
			return true;
		}
		else {
			throw new InvalidEmployeeObjectException();
		}
	}

	@Override
	public boolean deleteEmployee(int eid) throws InvalidEmployeeObjectException, EmployeeNotFoundException {
		if(eid>0) {
			if(!repo.existsById(eid)) {
				throw new EmployeeNotFoundException();
			}
			repo.deleteById(eid);
			return true;
		}
		 throw new InvalidEmployeeObjectException();
	}

	@Override
	public Optional<Employee> findEmployee(int eid) throws EmployeeNotFoundException, InvalidEmployeeObjectException {
		if(eid>0) {
			if(!repo.existsById(eid)) {
				throw new EmployeeNotFoundException();
			}
			Optional<Employee> employee = repo.findById(eid);
			 return employee;
		}else {
			throw new InvalidEmployeeObjectException();
		}
	}

	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> employee = (List<Employee>) repo.findAll();
		return employee;
	}

	@Override
	public List<Employee> FindByEname(String ename) throws InvalidEmployeeObjectException {
		if(ename != null) {
			return (List<Employee>) repo.findByEname(ename);
		}else {
			throw new InvalidEmployeeObjectException();
		}
	}

	@Override
	@Transactional
	public boolean deleteByEname(String ename) throws InvalidEmployeeObjectException {
		if(ename!=null) {
			repo.deleteByEname(ename);
			return true;
		}else {
			throw new InvalidEmployeeObjectException();
		}
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
