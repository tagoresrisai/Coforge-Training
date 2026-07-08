package com.coforge.day6;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StreamTest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11,12,13,1,15,16,17,18,19,20);
		
		List<Integer> even = list.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
		System.out.println(even);
		
		long count = list.stream().filter(n -> n%2 == 0).count();
		System.out.println(count);
		
		list.stream().filter(n -> n%2 == 0).forEach(System.out::println);
		
		list.stream().filter(n -> n%2 ==0).map(n -> n*2).forEach(System.out::println);
		
		List<String> stringList = Arrays.asList("Tagore","Sri","Sai","Ram","Krish");
		
		stringList.stream().filter(s -> s.contains("a")).forEach(System.out::println);
		
		stringList.stream().filter(s -> s.contains("a")).map(s -> s.length()).forEach(System.out::println);
		
	}

}
