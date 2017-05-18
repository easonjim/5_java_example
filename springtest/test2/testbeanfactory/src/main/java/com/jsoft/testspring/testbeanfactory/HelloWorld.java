package com.jsoft.testspring.testbeanfactory;

public class HelloWorld {

	private String messageString;
	
	public void setMessage(String message){
		this.messageString = message;
	}
	
	public String getMessage(){
		return this.messageString;
	}
	
}
