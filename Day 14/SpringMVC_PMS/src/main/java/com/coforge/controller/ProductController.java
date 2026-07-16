package com.coforge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.model.Product;
import com.coforge.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping("home")
	public ModelAndView loadHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");

		return mv;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST, params = "Insert")
	public ModelAndView createProduct(@ModelAttribute Product product) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");

		String result = "";
		boolean status = service.createProduct(product);

		if (status) {
			result = "SUCCESS : Product Object Saved";
		} else {
			result = "FAILURE : Product Object Not Saved";
		}

		mv.addObject("result", result);

		return mv;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST, params = "Update")
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");

		String result = "";
		boolean status = service.updateProduct(product);

		if (status) {
			result = "SUCCESS : Product Object Updated";
		} else {
			result = "FAILURE : Product Object Not Updated";
		}

		mv.addObject("result", result);

		return mv;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST, params = "Delete")
	public ModelAndView deleteProduct(@ModelAttribute Product product) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");

		String result = "";
		boolean status = service.deleteProduct(product);

		if (status) {
			result = "SUCCESS : Product Object Deleted";
		} else {
			result = "FAILURE : Product Object Not Deleted";
		}

		mv.addObject("result", result);

		return mv;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST, params = "Find")
	public ModelAndView findProduct(@RequestParam int pid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");

		String result = "";
		Product product = service.findProduct(pid);

		if (product != null) {
			result = product.toString();
		} else {
			result = "FAILURE : Product Object Not Found";
		}

		mv.addObject("result", result);

		return mv;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST, params = "FindAll")
	public ModelAndView findAllProduct() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");

		List<Product> product = service.findAllProduct();

		mv.addObject("result", product);

		return mv;
	}

}