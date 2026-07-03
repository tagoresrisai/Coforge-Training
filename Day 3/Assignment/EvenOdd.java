package com.coforge.day3.assignment;

import java.util.Scanner;

public class EvenOdd {
	public static void main(String[] args) {
		System.out.print("Enter the number: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a%2==0) System.out.println("It's Even");
		else System.out.println("It's Odd");
		sc.close();
	}
}
