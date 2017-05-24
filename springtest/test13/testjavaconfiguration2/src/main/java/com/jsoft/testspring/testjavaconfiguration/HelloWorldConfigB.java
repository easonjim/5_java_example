package com.jsoft.testspring.testjavaconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HelloWorldConfig.class)
public class HelloWorldConfigB {
	
	@Bean
	public String messageB(){
		return new String("Hello B");
	}
}
