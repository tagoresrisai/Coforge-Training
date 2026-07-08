package com.coforge.day3.assignment;

public class Book {
	private int id;
	private String title;
	private String author;
	private int price;
	
public Book(int id, String title, String author, int price) {
	this.id = id;
	this.title = title;
	this.author = author;
	this.price = price;
}
	
	public void display() {
		System.out.println("Id: "+id);
		System.out.println("Title: "+title);
		System.out.println("Author: "+author);
		System.out.println("Price: "+price);
	}
	
}
