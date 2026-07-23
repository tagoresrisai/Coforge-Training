package com.coforge.dms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.dms.model.Department;
import com.coforge.dms.service.DepartmentService;

@RestController
@RequestMapping("api/v1/dms")
public class DepartmentController {

	private DepartmentService service;
	private Environment environment;

	@Autowired
	public DepartmentController(DepartmentService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	@GetMapping("/departments/{did}")
	public ResponseEntity<?> FindDepartment(@PathVariable("did") int did) {

		ResponseEntity<?> responseEntity = null;

		Optional<Department> dept = service.findDepartment(did);

		responseEntity = new ResponseEntity<>(dept.get(), HttpStatus.CREATED);

		return responseEntity;
	}
	
	@GetMapping("/departments")
	public ResponseEntity<?> FindAllDepartments() {

		ResponseEntity<?> responseEntity = null;

		List<Department> dept = service.findAllDepartments();

		responseEntity = new ResponseEntity<>(dept, HttpStatus.CREATED);

		return responseEntity;
	}

}