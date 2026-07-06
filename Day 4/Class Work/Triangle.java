package com.coforge.day4;

public class Triangle extends Figure{
	public Triangle() {
		super(5L,6L);
	}
	@Override
	public void area() {
		System.out.println("Area of Triangle: "+(getBase()*getHeight()*0.5));
	}
}
