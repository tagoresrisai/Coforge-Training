package com.coforge.day4;

public class StringTest {

	public static void main(String[] args) {
		String s1 = "Java"; //Takes memory form string pool
		String s2 = new String("Java");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
		
		System.out.println(s1.length());

	}

}
