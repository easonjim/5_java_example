package com.jsoft.testjavabasics.test2;

//File Name InsufficientFundsException.java
import java.io.*;

public class InsufficientFundsException extends Exception {
	private double amount;

	public InsufficientFundsException(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
}
