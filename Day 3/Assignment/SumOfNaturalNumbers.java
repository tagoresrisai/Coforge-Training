package com.coforge.day3.assignment;

import java.util.Scanner;

public class SumOfNaturalNumbers {

	public static void main(String[] args) {
		System.out.print("Enter n: ");
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(n*(n+1)/2);
		
		sc.close();

	}

}
