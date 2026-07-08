package com.coforge.day5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(new Integer(10));
		list.add(20); //Auto Boxing
		list.add(30);
		list.add(40);
		System.out.println(list.get(3));
		list.remove(3);
		System.out.println(list);
		list.set(0, 100);
		System.out.println(list);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
