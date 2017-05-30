package com.jsoft.testjavabasics.test3;

public class Employee {
	// this instance variable is visible for any child class.
	public String name;

	// salary variable is visible in Employee class only.
	private double salary;

	// The name variable is assigned in the constructor.
	public Employee(String empName) {
		name = empName;
	}

	// The salary variable is assigned a value.
	public void setSalary(double empSal) {
		salary = empSal;
	}

	// This method prints the employee details.
	public void printEmp() {
		System.out.println("name  : " + name);
		System.out.println("salary :" + salary);
	}

	public static void main(String args[]) {
		Employee empOne = new Employee("Ransika");
		empOne.setSalary(1000);
		empOne.printEmp();
	}
}
