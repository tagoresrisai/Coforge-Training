package com.coforge.day3.assignment;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		System.out.print("Enter number: ");
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int ans = 0;
		
		while(n>0) {
			int last = n%10;
			ans = ans*10 + last;
			n = n/10;
		}
		
		System.out.println(ans);
		
		sc.close();

	}

}
