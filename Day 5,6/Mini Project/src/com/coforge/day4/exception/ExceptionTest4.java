package com.coforge.day4.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest4 {
	public static void myMethod() throws FileNotFoundException{
		FileReader fr = new FileReader("Demo.txt");
	}
	
	public static void main(String[] args) {
		try {
			ExceptionTest4.myMethod();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
