package com.jsoft.testspring.testbeanpostprocessor;

public class HelloWorld {
	private String messageString;
	
	public void setMessage(String message){
		this.messageString = message;
	}
	
	public void getMessage(){
		System.out.println(this.messageString);
	}
	
	public void initCustom(){
		System.out.println("初始化");
	}
	
	public void destroyCustom(){
		System.out.println("销毁");
	}
	
}
