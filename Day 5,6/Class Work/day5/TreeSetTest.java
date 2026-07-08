package com.coforge.day5;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
		
		set.add(new Integer(10));
		set.add(20); //Auto Boxing
		set.add(30);
		set.add(40);
		set.remove(10);
		System.out.println(set);
		
		for(Integer i: set) {
			System.out.println(i);
		}
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
