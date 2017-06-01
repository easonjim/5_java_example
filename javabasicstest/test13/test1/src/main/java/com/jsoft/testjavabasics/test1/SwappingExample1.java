package com.jsoft.testjavabasics.test1;

public class SwappingExample1 {

	public static void main(String[] args) {
		int[] ab={30,45};

		System.out.println("Before swapping, a = " + ab[0] + " and b = " + ab[1]);

		// Invoke the swap method
		swapFunction(ab);
		System.out.println("\n**Now, Before and After swapping values will be same here**:");
		System.out.println("After swapping, a = " + ab[0] + " and b is " + ab[1]);
	}

	public static void swapFunction(int[] ab) {

		System.out.println("Before swapping(Inside), a = " + ab[0] + " b = " + ab[1]);
		// Swap n1 with n2
		ab[0] = 45;
		ab[1] = 30;

		System.out.println("After swapping(Inside), a = " + ab[0] + " b = " + ab[1]);
	}
}
