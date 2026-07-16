package com.coforge.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("home")
	public ModelAndView loadHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");
		
		return mv;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST, params = "Insert")
	public ModelAndView createEmployee(@ModelAttribute Employee employee) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");
		
		String result = "";
		boolean status = service.createEmployee(employee);
		
		if(status) {
			result = "SUCCESS : Employee Object Saved";
		}else {
			result = "FAILURE : Employee Object Not Saved";
		}
		
		mv.addObject("result", result);
		
		return mv;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST, params = "Update")
	public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");
		
		String result = "";
		boolean status = service.updateEmployee(employee);
		
		if(status) {
			result = "SUCCESS : Employee Object Updated";
		}else {
			result = "FAILURE : Employee Object Not Updated";
		}
		
		mv.addObject("result", result);
		
		return mv;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST, params = "Delete")
	public ModelAndView deleteEmployee(@ModelAttribute Employee employee) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");
		
		String result = "";
		boolean status = service.deleteEmployee(employee);
		
		if(status) {
			result = "SUCCESS : Employee Object Deleted";
		}else {
			result = "FAILURE : Employee Object Not Deleted";
		}
		
		mv.addObject("result", result);
		
		return mv;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST, params = "Find")
	public ModelAndView findEmployee(@RequestParam int eid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");
		
		String result = "";
		Employee employee = service.findEmployee(eid);
		
		if(employee != null) {
			result = employee.toString();
		}else {
			result = "FAILURE : Employee Object Not Found";
		}
		
		mv.addObject("result", result);
		
		return mv;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST, params = "FindAll")
	public ModelAndView findAllEmployee() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmployeeHome");
		
		List<Employee> employee = service.findAllEmployee();
		
		
		mv.addObject("result", employee);
		
		return mv;
	}
}
