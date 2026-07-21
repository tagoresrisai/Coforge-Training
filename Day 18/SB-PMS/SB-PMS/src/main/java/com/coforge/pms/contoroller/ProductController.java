package com.coforge.pms.contoroller;

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

import com.coforge.pms.model.Product;
import com.coforge.pms.service.ProductService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/pms")
public class ProductController {

	private ProductService service;
	private Environment environment;

	@Autowired
	public ProductController(ProductService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/products")
	public ResponseEntity<String> saveProduct(@Valid @NotNull @RequestBody(required = false) Product product) {

		ResponseEntity<String> responseEntity = null;

		boolean status = service.saveProduct(product);

		if (status) {
			responseEntity = new ResponseEntity<>(
					environment.getProperty("pms.save.success"),
					HttpStatus.CREATED);
		}

		return responseEntity;
	}

	@PutMapping("/products/{pid}")
	public ResponseEntity<String> UpdateProduct(@PathVariable("pid") int pid,
			@Valid @NotNull @RequestBody(required = false) Product product) {

		ResponseEntity<String> responseEntity = null;

		boolean status = service.updateProduct(pid, product);

		if (status) {
			responseEntity = new ResponseEntity<>(
					environment.getProperty("pms.update.success"),
					HttpStatus.CREATED);
		}

		return responseEntity;
	}

	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> DeleteProduct(@PathVariable("pid") int pid) {

		ResponseEntity<String> responseEntity = null;

		boolean status = service.deleteProduct(pid);

		if (status) {
			responseEntity = new ResponseEntity<>(
					environment.getProperty("pms.delete.success"),
					HttpStatus.CREATED);
		}

		return responseEntity;
	}

	@GetMapping("/products/{pid}")
	public ResponseEntity<?> FindProduct(@PathVariable("pid") int pid) {

		ResponseEntity<?> responseEntity = null;

		Optional<Product> product = service.findProduct(pid);

		responseEntity = new ResponseEntity<>(product.get(), HttpStatus.CREATED);

		return responseEntity;
	}

	@GetMapping("/products")
	public ResponseEntity<?> FindAllProduct() {

		ResponseEntity<?> responseEntity = null;

		List<Product> product = service.findAllProduct();

		responseEntity = new ResponseEntity<>(product, HttpStatus.CREATED);

		return responseEntity;
	}

	@GetMapping("/products/pname/{pname}")
	public ResponseEntity<?> FindByPname(@PathVariable("pname") String pname) {

		ResponseEntity<?> responseEntity = null;

		List<Product> product = service.findByPname(pname);

		responseEntity = new ResponseEntity<>(product, HttpStatus.CREATED);

		return responseEntity;
	}

	@DeleteMapping("/products/pname/{pname}")
	public ResponseEntity<?> DeleteByPname(@PathVariable("pname") String pname) {

		ResponseEntity<?> responseEntity = null;

		boolean status = service.deleteByPname(pname);

		if (status) {
			responseEntity = new ResponseEntity<>(
					environment.getProperty("pms.delete.success"),
					HttpStatus.CREATED);
		}

		return responseEntity;
	}

	@GetMapping("/products/pids")
	public ResponseEntity<?> getPidsList() {

		ResponseEntity<?> responseEntity = null;

		List<Integer> pids = service.getPidsList();

		responseEntity = new ResponseEntity<>(pids, HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping("/products/statistics")
	public ResponseEntity<?> getProductStatistics() {

		ResponseEntity<?> responseEntity = null;

		List<Object[]> statistics = service.getProductStatistics();

		responseEntity = new ResponseEntity<>(statistics, HttpStatus.OK);

		return responseEntity;
	}

}