package com.coforge.pms.dto;

import com.coforge.pms.model.Product;


public class ProductDto {
	private Product product;
	private SupplierDto supplier;
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDto(Product product, SupplierDto supplier) {
		super();
		this.product = product;
		this.supplier = supplier;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public SupplierDto getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierDto supplier) {
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "ProductDto [product=" + product + ", supplier=" + supplier + "]";
	}
	
}
