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

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

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
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		ResponseEntity<String> responseEntity = null;
		
		try {
			boolean status = service.saveEmployee(employee);
			if(status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("ems.save.success"),HttpStatus.CREATED);
			}
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@PutMapping("/employees/{eid}")
	public ResponseEntity<String> UpdateEmployee(@PathVariable("eid") int eid,@RequestBody Employee employee) {
		ResponseEntity<String> responseEntity = null;
		
		try {
			boolean status = service.UpdateEmployee(eid,employee);
			if(status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("ems.update.success"),HttpStatus.CREATED);
			}
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		} catch (EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/employees/{eid}")
	public ResponseEntity<String> DeleteEmployee(@PathVariable("eid") int eid) {
		ResponseEntity<String> responseEntity = null;
		
		try {
			boolean status = service.deleteEmployee(eid);
			if(status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.success"),HttpStatus.CREATED);
			}
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		} catch(EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@GetMapping("/employees/{eid}")
	public ResponseEntity<?> FindEmployee(@PathVariable("eid") int eid) {
		ResponseEntity<?> responseEntity = null;
		
		try {
			Optional<Employee> emp = service.findEmployee(eid);
			if(emp!=null) {
				responseEntity = new ResponseEntity<>(emp.get(),HttpStatus.CREATED);
			}
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		} catch(EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@GetMapping("/employees")
	public ResponseEntity<?> FindAllEmployee() {
		ResponseEntity<?> responseEntity = null;
		
		try {
			List<Employee> emp = service.findAllEmployee();
			responseEntity = new ResponseEntity<>(emp,HttpStatus.CREATED);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@GetMapping("/employees/ename/{ename}")
	public ResponseEntity<?> FindByEname(@PathVariable("ename") String ename) {
		ResponseEntity<?> responseEntity = null;
		
		try {
			List<Employee> emp = service.FindByEname(ename);
			responseEntity = new ResponseEntity<>(emp,HttpStatus.CREATED);
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/employees/ename/{ename}")
	public ResponseEntity<?> DeleteByEname(@PathVariable("ename") String ename) {
		ResponseEntity<?> responseEntity = null;
		
		try {
			boolean status = service.deleteByEname(ename);
			if(status)
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.success"),HttpStatus.CREATED);
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@GetMapping("/employees/eids")
	public ResponseEntity<?> getEidsList() {

		ResponseEntity<?> responseEntity = null;

		try {

			List<Integer> eids = service.getEidsList();

			responseEntity = new ResponseEntity<>(eids, HttpStatus.OK);

		}
		catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.db.failed"),
					HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}
	
	@GetMapping("/employees/statistics")
	public ResponseEntity<?> getEmployeeStatistics() {

		ResponseEntity<?> responseEntity = null;

		try {

			List<Object[]> statistics = service.getEmployeeStatistics();

			responseEntity = new ResponseEntity<>(statistics, HttpStatus.OK);

		}
		catch (Exception e) {

			responseEntity = new ResponseEntity<>(
					environment.getProperty("ems.db.failed"),
					HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}

}
