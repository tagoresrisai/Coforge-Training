package com.coforge.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.ems.dto.DepartmentDto;
import com.coforge.ems.dto.EmployeeDto;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/ems")
public class EmployeeController {

//	@GetMapping("/welcome")
//	public String sayWelcome() {
//		return "Welcome to EMS";
//	}

	// @Autowired //Field injection
	private EmployeeService service;
	private Environment environment;

	@Autowired // Constructor injection
	public EmployeeController(EmployeeService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@Valid @NotNull @RequestBody(required = false) Employee employee) {

		ResponseEntity<String> responseEntity = null;

		boolean status = service.saveEmployee(employee);

		if (status) {
			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.save.success"),
					HttpStatus.CREATED);
		}

		return responseEntity;
	}
	
	@PutMapping("/employees/{eid}")
	public ResponseEntity<String> UpdateEmployee(@PathVariable("eid") int eid,
			@Valid @NotNull @RequestBody(required = false) Employee employee) {

		ResponseEntity<String> responseEntity = null;

		boolean status = service.UpdateEmployee(eid, employee);

		if (status) {
			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.update.success"),
					HttpStatus.CREATED);
		}

		return responseEntity;
	}
	
	@DeleteMapping("/employees/{eid}")
	public ResponseEntity<String> DeleteEmployee(@PathVariable("eid") int eid) {

		ResponseEntity<String> responseEntity = null;

		boolean status = service.deleteEmployee(eid);

		if (status) {
			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.delete.success"),
					HttpStatus.CREATED);
		}

		return responseEntity;
	}
	
	@GetMapping("/employees/{eid}")
	public ResponseEntity<?> FindEmployee(@PathVariable("eid") int eid) {

		ResponseEntity<?> responseEntity = null;

		Optional<Employee> emp = service.findEmployee(eid);

		responseEntity = new ResponseEntity<>(emp.get(), HttpStatus.CREATED);

		return responseEntity;
	}
	
	@GetMapping("/employees")
	public ResponseEntity<?> FindAllEmployee() {

		ResponseEntity<?> responseEntity = null;

		List<Employee> emp = service.findAllEmployee();

		responseEntity = new ResponseEntity<>(emp, HttpStatus.CREATED);

		return responseEntity;
	}
	
	@GetMapping("/employees/ename/{ename}")
	public ResponseEntity<?> FindByEname(@PathVariable("ename") String ename) {

		ResponseEntity<?> responseEntity = null;

		List<Employee> emp = service.FindByEname(ename);

		responseEntity = new ResponseEntity<>(emp, HttpStatus.CREATED);

		return responseEntity;
	}
	
	@DeleteMapping("/employees/ename/{ename}")
	public ResponseEntity<?> DeleteByEname(@PathVariable("ename") String ename) {

		ResponseEntity<?> responseEntity = null;

		boolean status = service.deleteByEname(ename);

		if (status) {
			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.delete.success"),
					HttpStatus.CREATED);
		}

		return responseEntity;
	}
	
	@GetMapping("/employees/eids")
	public ResponseEntity<?> getEidsList() {

		ResponseEntity<?> responseEntity = null;

		List<Integer> eids = service.getEidsList();

		responseEntity = new ResponseEntity<>(eids, HttpStatus.OK);

		return responseEntity;
	}
	
	@GetMapping("/employees/statistics")
	public ResponseEntity<?> getEmployeeStatistics() {

		ResponseEntity<?> responseEntity = null;

		List<Object[]> statistics = service.getEmployeeStatistics();

		responseEntity = new ResponseEntity<>(statistics, HttpStatus.OK);

		return responseEntity;
	}
	
	//Rest end points for client
	@GetMapping("/employees/department/{dno}")
	public ResponseEntity<?> getDeptById(@PathVariable("dno") int dno){
		
		ResponseEntity<?> responseEntity = null;
		
		DepartmentDto  department = service.getDeptById(dno);
		
		if(department != null) {
			responseEntity = new ResponseEntity<>(department, HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<>("FAILED: Dept Not Found", HttpStatus.BAD_REQUEST);
		}
		
		
		return responseEntity;
		
	}
	
	@GetMapping("/employees/department")
	public ResponseEntity<?> FindAllDepartments() {

		ResponseEntity<?> responseEntity = null;

		List<DepartmentDto> dept = service.findAllDepartments();

		responseEntity = new ResponseEntity<>(dept, HttpStatus.CREATED);

		return responseEntity;
	}
	
	@GetMapping("/employees/{eid}/department")
	public ResponseEntity<?> FindEmployeeDetails(@PathVariable("eid") int eid) {

		ResponseEntity<EmployeeDto> responseEntity = null;
		EmployeeDto employeeDto = new EmployeeDto();
		Employee employee = service.findEmployee(eid).get();
		
		DepartmentDto department = service.getDeptById(employee.getDno());
		
		employeeDto.setEmployee(employee);
		employeeDto.setDepartment(department);
		
		responseEntity = new ResponseEntity<>(employeeDto,HttpStatus.OK);

		return responseEntity;
	}

}
