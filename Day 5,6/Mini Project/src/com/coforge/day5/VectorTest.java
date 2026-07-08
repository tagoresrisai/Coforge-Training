package com.coforge.day5;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<Integer> list = new Vector<>();//Old/Legacy
		
		list.add(new Integer(10));
		list.add(20); //Auto Boxing
		list.add(30);
		list.add(40);
		System.out.println(list.get(3));
		list.remove(3);
		System.out.println(list);
		list.set(0, 100);
		System.out.println(list);
		
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		
//		Iterator<Integer> it = list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		//traverse using enumeration
		
		Enumeration<Integer> en = list.elements();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
	}

}
