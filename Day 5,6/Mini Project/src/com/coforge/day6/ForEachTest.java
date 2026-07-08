package com.coforge.day6;

import java.util.Arrays;
import java.util.List;

public class ForEachTest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11,12,13,14,15,16,17,18,19,20);
		list.forEach(n -> System.out.println(n));
		System.out.println("------");
		
		list.forEach(n->{
			if(n%2==0) System.out.println(n);
		});
		System.out.println("------");
		
		list.forEach(System.out::println);
	}

}
