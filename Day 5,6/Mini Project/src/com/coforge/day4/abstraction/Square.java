package com.coforge.day4.abstraction;

public class Square extends Figure{
	public Square() {
		super(5);
	}
	@Override
	public void area() {
		System.out.println("Area of Square: "+(getSide()*getSide()));
	}
}
