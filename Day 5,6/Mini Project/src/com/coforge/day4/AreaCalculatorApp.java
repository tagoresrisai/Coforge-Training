package com.coforge.day4;

public class AreaCalculatorApp {

	public static void main(String[] args) {
//		Rectangle rectangle = new Rectangle();
//		Square square = new Square();
//		Triangle triangle = new Triangle();
//		
//		rectangle.area();
//		square.area();
//		triangle.area();
		
		
		Figure figure ;// reference
		figure = new Rectangle();// object
		figure.area();// One reference is handling all the objects
		figure = new Square();//DMD - Dynamic method dispatch - Run time polymorphism. Sub class object ot super class reference.
		figure.area();
		figure = new Triangle();
		figure.area();
		
		// Rectangle rectangle = (Rectangle) new Figure(5); - All oranges are fruits but all fruits are not oranges.
		
	
	}

}
