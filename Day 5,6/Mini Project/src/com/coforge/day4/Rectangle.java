package com.coforge.day4;

public class Rectangle extends Figure{
	public Rectangle() {
		super(5, 10);
	}
	@Override
	public void area() {
		System.out.println("Area of Rectangle: "+(getLength()*getBreadth()));
	}
}
