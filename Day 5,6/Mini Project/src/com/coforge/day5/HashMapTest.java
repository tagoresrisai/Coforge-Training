package com.coforge.day5;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<>();
		map.put(10, "Java");
		map.put(20, "Python");
		System.out.println(map);
		
		map.put(20, "React");
		System.out.println(map);
		
		map.remove(10);
		System.out.println(map);
		
		System.out.println(map.get(20));
		
	}

}
