package com.coforge.sms.service;

import java.util.Optional;

import com.coforge.sms.model.Supplier;

public interface SupplierService {

	public Optional<Supplier> getSupplierById(int sid);

}
