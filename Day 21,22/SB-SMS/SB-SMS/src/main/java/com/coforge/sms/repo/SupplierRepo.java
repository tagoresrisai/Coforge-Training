package com.coforge.sms.repo;

import org.springframework.data.repository.CrudRepository;

import com.coforge.sms.model.Supplier;

public interface SupplierRepo  extends CrudRepository<Supplier, Integer> {

}
