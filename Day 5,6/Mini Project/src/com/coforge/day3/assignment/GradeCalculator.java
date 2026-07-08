package com.coforge.day3.assignment;

import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		System.out.print("Enter Marks: ");
		
		Scanner sc = new Scanner(System.in);
		int marks = sc.nextInt();
		
		if(marks<=100 && marks>=90) System.out.println("A Grade");
		else if(marks<=89 && marks>=80) System.out.println("B Grade");
		else if(marks<=79 && marks>=70) System.out.println("C Grade");
		else if(marks<=69 && marks>=60) System.out.println("D Grade");
		else System.out.println("F Grade");
		
		sc.close();

	}

}
