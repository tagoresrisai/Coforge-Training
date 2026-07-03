package com.coforge.day3.assignment;

import java.util.Scanner;

public class Largest {

	public static void main(String[] args) {
		System.out.println("Enter 3 numbers: ");
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a>b) {
			if(a>c) {
				System.out.println("A is Greater");
			}
			else {
				System.out.println("C is Geater");
			}
		}
		else {
			if(b>c) {
				System.out.println("B is Greater");
			}
			else {
				System.out.println("C is Greater");
			}
		}
		
		sc.close();

	}

}
