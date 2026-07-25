package com.coforge.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.pms.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

	public List<Product> findByPname(String pname);

	public void deleteByPname(String pname);

	// Get all Product IDs
	@Query("select p.pid from Product p")
	public List<Integer> getPids();

	// Count, Max Price, Min Price, Sum Price
	@Query("select count(p), max(p.price), min(p.price), sum(p.price) from Product p")
	public List<Object[]> getProductStatistics();

}