package com.jsoft.testjavabasics.test1;

import java.util.Date;

public class DateDemo2 {

	public static void main(String args[]) {
		// Instantiate a Date object
		Date date = new Date();

		// display time and date using toString()
		String str = String.format("Current Date/Time : %tc", date);

		System.out.printf(str);
	}
}