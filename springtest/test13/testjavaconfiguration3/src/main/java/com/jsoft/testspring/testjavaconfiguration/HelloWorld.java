package com.jsoft.testspring.testjavaconfiguration;

public class HelloWorld {
	private String message;
	
	public HelloWorld(String message){
		this.message = message;
	}
	
	public void getMessage(){
		System.out.println(this.message);
	}
	
	public void init(){
		System.out.println("HelloWorld init");
	}
	
	public void cleanup(){
		System.out.println("HelloWorld cleanup");
	}
}
