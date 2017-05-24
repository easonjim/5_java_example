package com.jsoft.testspring.testjavaconfiguration;

public class HelloWorld {
	private String message;
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public void getMessage(){
		System.out.println(this.message);
	}
}
