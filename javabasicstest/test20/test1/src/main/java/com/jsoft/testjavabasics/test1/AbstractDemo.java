package com.jsoft.testjavabasics.test1;

/* File name : AbstractDemo.java */
public class AbstractDemo {
	public static void main(String[] args) {
		/* Following is not allowed and would raise error */
		Employee e = new Employee("George W.", "Houston, TX", 43);

		System.out.println("\n Call mailCheck using Employee reference--");
		e.mailCheck();
	}
}
