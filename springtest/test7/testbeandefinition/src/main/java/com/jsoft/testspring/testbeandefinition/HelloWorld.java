package com.jsoft.testspring.testbeandefinition;

public class HelloWorld {
	private String messageString1;
	
	public void setMessage1(String message){
		this.messageString1 = message;
	}
	
	public void getMessage1(){
		System.out.println(this.messageString1);
	}
	
	private String messageString2;

	public void getMessage2() {
		System.out.println(this.messageString2);
	}

	public void setMessage2(String messageString2) {
		this.messageString2 = messageString2;
	}
}
