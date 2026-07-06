package com.coforge.day4.exception;

public class ExceptionTest {

	public static void main(String[] args) {
		System.out.println("Before Exception");
//		int a = 10/0;// java.lang.ArithmeticException
		
//		int a = Integer.parseInt("ABC");// java.lang.NumberFormatException
		
//		int arr[] = {10,20,30};
//		System.out.println(arr[5]);// java.lang.ArrayIndexOutOfBoundsException
		
		int arr[] = new int[-5];
		
		String s = null;
		System.out.println(s.length());
		
		System.out.println("After Exception");

	}

}
