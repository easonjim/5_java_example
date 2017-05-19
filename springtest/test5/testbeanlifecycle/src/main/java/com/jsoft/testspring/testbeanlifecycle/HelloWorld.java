package com.jsoft.testspring.testbeanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class HelloWorld implements InitializingBean, DisposableBean {
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
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Class destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Class init");
	}
}
