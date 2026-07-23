package com.coforge.ems.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coforge.ems.dto.DepartmentDto;

@FeignClient(name = "SPRINGBOOT-DMS")
public interface DepartmentClient {
	
	@GetMapping("/api/v1/dms/departments/{did}")
	public DepartmentDto getDeptById(@PathVariable("did") int did);
	
	@GetMapping("/api/v1/dms/departments")
	public List<DepartmentDto> getDepartments();
}
