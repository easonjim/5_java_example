package com.jsoft.testjavabasics.test1;

//A simple constructor.
class MyClass {
	int x;

	// Following is the constructor
	MyClass(int i) {
		x = i;
	}
}
// 可以通过以下方法来调用构造函数来实例化一个对象：

public class ConsDemo {

	public static void main(String args[]) {
		MyClass t1 = new MyClass(10);
		MyClass t2 = new MyClass(20);
		System.out.println(t1.x + " " + t2.x);
	}
}
