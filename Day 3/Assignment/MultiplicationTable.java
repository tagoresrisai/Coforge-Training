package com.coforge.day3.assignment;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		System.out.print("Enter Table: ");
		
		Scanner sc = new Scanner(System.in);
		int table = sc.nextInt();
		
		for(int i=0;i<=10;i++) {
			System.out.println(table+"*"+i+"="+(table*i));
		}
		
		sc.close();

	}

}
