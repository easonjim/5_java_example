package com.jsoft.testspring.testannotationjsr250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class HelloWorld {
	private String messageString;
	
	@Resource(name="msg")
	public void setMessage(String message){
		this.messageString = message;
	}
	
	public void getMessage(){
		System.out.println(this.messageString);
	}
	
	@PostConstruct
	public void initPost(){
		System.out.println("@ init");
	}
	
	@PreDestroy
	public void destroyPre(){
		System.out.println("@ destroy");
	}
}
