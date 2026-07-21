package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.pms.exception.InvalidProductObjectException;
import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;

public interface ProductService {

	public boolean saveProduct(Product product);

	public boolean updateProduct(int pid, Product product);

	public boolean deleteProduct(int pid);

	public Optional<Product> findProduct(int pid);

	public List<Product> findAllProduct();

	public List<Product> findByPname(String pname);

	public boolean deleteByPname(String pname);

	public List<Integer> getPidsList();

	public List<Object[]> getProductStatistics();

}