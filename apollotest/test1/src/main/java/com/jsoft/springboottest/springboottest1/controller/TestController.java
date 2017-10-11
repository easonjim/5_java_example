package com.jsoft.springboottest.springboottest1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private AnnotatedBean annotatedBean;
	
	@RequestMapping("/show")
	public String show(){
		
		logger.info("batch:{}",annotatedBean.getBatch());
		logger.info("timeout:{}",annotatedBean.getTimeout());
		
		return "Hello World"+" batch:"+annotatedBean.getBatch()+" timeout:"+annotatedBean.getTimeout();		
	}
}
