package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.pms.dto.SupplierDto;
import com.coforge.pms.exception.InvalidProductObjectException;
import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;
import com.coforge.pms.repo.ProductRepo;
import com.coforge.pms.service.client.SupplierClient;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepo repo;
	private Environment environment;
	private SupplierClient client;

	public ProductServiceImpl(ProductRepo repo, Environment environment, SupplierClient client) {
		super();
		this.repo = repo;
		this.environment = environment;
		this.client = client;
	}

	@Override
	public boolean saveProduct(Product product) {

		repo.save(product);

		return true;
	}

	@Override
	public boolean updateProduct(int pid, Product product)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (!repo.existsById(pid)) {
			throw new ProductNotFoundException(
					environment.getProperty("pms.invalid.product-notfound"));
		}

		repo.save(product);

		return true;
	}

	@Override
	public boolean deleteProduct(int pid)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (!repo.existsById(pid)) {
			throw new ProductNotFoundException(
					environment.getProperty("pms.invalid.product-notfound"));
		}

		repo.deleteById(pid);

		return true;
	}

	@Override
	public Optional<Product> findProduct(int pid)
			throws ProductNotFoundException, InvalidProductObjectException {

		if (!repo.existsById(pid)) {
			throw new ProductNotFoundException(
					environment.getProperty("pms.invalid.product-notfound"));
		}

		return repo.findById(pid);
	}

	@Override
	public List<Product> findAllProduct() {
		List<Product> product = (List<Product>) repo.findAll();
		return product;
	}

	@Override
	public List<Product> findByPname(String pname)
			throws InvalidProductObjectException {

		if (pname != null) {
			return repo.findByPname(pname);
		}

		throw new InvalidProductObjectException(
				environment.getProperty("pms.invalid.product-details"));
	}

	@Override
	@Transactional
	public boolean deleteByPname(String pname)
			throws InvalidProductObjectException {

		if (pname != null) {

			repo.deleteByPname(pname);

			return true;
		}

		throw new InvalidProductObjectException(
				environment.getProperty("pms.invalid.product-details"));
	}

	@Override
	public List<Integer> getPidsList() {
		return repo.getPids();
	}

	@Override
	public List<Object[]> getProductStatistics() {
		return repo.getProductStatistics();
	}

	@Override
	public SupplierDto getSupplierById(int sno) {
		SupplierDto supplier = client.getSupplierById(sno);
		return supplier;
	}
	
	
	

}