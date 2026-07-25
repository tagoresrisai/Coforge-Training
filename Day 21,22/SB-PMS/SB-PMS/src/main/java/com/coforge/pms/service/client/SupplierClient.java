package com.coforge.pms.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coforge.pms.dto.SupplierDto;

@FeignClient(name = "SB-SMS")
public interface SupplierClient {

	@GetMapping("/api/v1/sms/suppliers/{sid}")
	public SupplierDto getSupplierById(@PathVariable("sid") int sid);

}
