package com.jsoft.test.helloworld;

public class HelloWorld
{
	public String sayHello()
	{
		return "hello maven";
	}

	public static void main(String[] args)
	{
		System.out.print(new HelloWorld().sayHello());
	}
}