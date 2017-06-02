package com.jsoft.testjavabasics.test1;

/* File name : Salary.java */
public class Salary1 extends Employee1 {
	private double salary; // Annual salary

	public double computePay() {
		System.out.println("Computing salary pay for ");
		return salary / 52;
	}

	// Remainder of class definition
}