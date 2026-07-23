package com.coforge.dms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.dms.exception.DepartmentNotFoundException;
import com.coforge.dms.exception.InvalidDepartmentObjectException;
import com.coforge.dms.model.Department;

public interface DepartmentService {

	public Optional<Department> findDepartment(int did);

	public List<Department> findAllDepartments();

}