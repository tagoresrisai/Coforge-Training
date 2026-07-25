package com.coforge.sms.service;

import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.sms.model.Supplier;
import com.coforge.sms.repo.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService{
	
	private SupplierRepo repo;
	private Environment environment;
	
	

	public SupplierServiceImpl(SupplierRepo repo, Environment environment) {
		super();
		this.repo = repo;
		this.environment = environment;
	}



	@Override
	public Optional<Supplier> getSupplierById(int sid) {
		
		return repo.findById(sid);
	}

}
