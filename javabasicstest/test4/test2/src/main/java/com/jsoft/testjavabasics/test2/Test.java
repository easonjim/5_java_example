package com.jsoft.testjavabasics.test2;

public class Test {

	public static void main(String args[]) {
		String name = "James";
		// following will return true since name is type of String
		boolean result = name instanceof String;
		System.out.println(result);
	}
}
