package com.coforge.day3.assignment;

public class Product {
	private int productId;
	private String productName;
	private int productPrice;
	private int productQuantity;
	
public void Product(int productId, String productName, int productPrice, int productQuantity) {
	this.productId = productId;
	this.productName = productName;
	this.productPrice = productPrice;
	this.productQuantity = productQuantity;
}
	
	public int CalculateTotal() {
		return productPrice*productQuantity;
	}
}
