package com.coforge.day3.assignment;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		System.out.print("Enter Number: ");
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		boolean isPrime = true;
		
		for(int i = 2; i < n/2; i++) {
			if(n%i == 0) isPrime = false;
		}
		
		if(isPrime) System.out.println("Prime");
		else System.out.println("Not Prime");
		
		sc.close();

	}

}
