package com.jsoft.testspring.testjavaconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class HelloWorldConfig {
	
	@Bean
	@Scope("prototype")
	public HelloWorld helloWorld(){
		return new HelloWorld();
	}
	
}
