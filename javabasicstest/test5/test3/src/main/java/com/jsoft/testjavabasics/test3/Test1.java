package com.jsoft.testjavabasics.test3;

public class Test1 {

	public static void main(String args[]) {
		int x = 10;
		for (;;) {
			if (x >= 20) {
				break;
			}
			System.out.print("value of x : " + x);
			System.out.print("\n");
			x = x + 1;
		}
	}
}
