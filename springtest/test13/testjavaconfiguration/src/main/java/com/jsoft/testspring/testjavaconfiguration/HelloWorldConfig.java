package com.jsoft.testspring.testjavaconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {
	
	@Bean
	public HelloWorld helloWorld(){
		return new HelloWorld();
	}

}
