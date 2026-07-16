package com.coforge.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.coforge.model.Product;

@Service
public class ProductService {

	private Map<Integer, Product> map = new HashMap<>();

	public boolean createProduct(Product product) {
		if (map.containsKey(product.getPid())) {
			return false;
		}
		map.put(product.getPid(), product);
		return true;
	}

	public boolean updateProduct(Product product) {
		if (map.containsKey(product.getPid())) {
			map.put(product.getPid(), product);
			return true;
		}
		return false;
	}

	public boolean deleteProduct(Product product) {
		if (map.containsKey(product.getPid())) {
			map.remove(product.getPid());
			return true;
		}
		return false;
	}

	public Product findProduct(int pid) {
		return map.get(pid);
	}

	public List<Product> findAllProduct() {
		return new ArrayList<>(map.values());
	}

}