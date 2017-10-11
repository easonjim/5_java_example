package com.jsoft.springboottest.springboottest1.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

@Configuration
@EnableApolloConfig
public class AnnotatedConfig {
	
	@Bean
	public AnnotatedBean annotatedBean() {
		return new AnnotatedBean();
	}
}
