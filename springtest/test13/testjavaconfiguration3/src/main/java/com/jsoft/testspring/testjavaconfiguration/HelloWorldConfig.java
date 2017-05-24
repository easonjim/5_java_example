package com.jsoft.testspring.testjavaconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {
	
	@Bean(initMethod="init",destroyMethod="cleanup")
	public HelloWorld helloWorld(){
		return new HelloWorld(message());
	}
	
	@Bean
	public String message(){
		return new String("Hello World");
	}

}
