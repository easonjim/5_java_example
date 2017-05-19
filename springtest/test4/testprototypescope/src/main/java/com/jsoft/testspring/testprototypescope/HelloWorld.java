package com.jsoft.testspring.testprototypescope;

public class HelloWorld {
	private String messageString;
	
	public void setMessage(String message){
		this.messageString = message;
	}
	
	public String getMessage(){
		return this.messageString;
	}
}
