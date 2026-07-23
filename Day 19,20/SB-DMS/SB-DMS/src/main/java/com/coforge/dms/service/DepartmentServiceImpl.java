package com.coforge.dms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.dms.exception.DepartmentNotFoundException;
import com.coforge.dms.exception.InvalidDepartmentObjectException;
import com.coforge.dms.model.Department;
import com.coforge.dms.repo.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepo repo;
	private Environment environment;

	public DepartmentServiceImpl(DepartmentRepo repo, Environment environment) {
		super();
		this.repo = repo;
		this.environment = environment;
	}

	@Override
	public Optional<Department> findDepartment(int did)
			throws DepartmentNotFoundException, InvalidDepartmentObjectException {

		if (!repo.existsById(did)) {
			throw new DepartmentNotFoundException(
					environment.getProperty("dms.invalid.department-notfound"));
		}

		return repo.findById(did);
	}

	@Override
	public List<Department> findAllDepartments() {
		
		return (List<Department>) repo.findAll();
	}

}