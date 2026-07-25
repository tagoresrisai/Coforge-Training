package com.coforge.sms.controller;

import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.sms.model.Supplier;
import com.coforge.sms.service.SupplierService;

@RestController
@RequestMapping("api/v1/sms")
public class SupplierController {
	
	private SupplierService service;
	private Environment environmant;
	
	public SupplierController(SupplierService service, Environment environmant) {
		super();
		this.service = service;
		this.environmant = environmant;
	}
	
	@GetMapping("/suppliers/{sid}")
	public ResponseEntity<?> getSupplerById(@PathVariable("sid") int sid){
		ResponseEntity<?> responseEntity = null;
		
		Optional<Supplier> supplier = service.getSupplierById(sid);
		
		responseEntity = new ResponseEntity<>(supplier.get(),HttpStatus.CREATED);
		
		return responseEntity;
		
	}
}
