package com.jsoft.springboottest.springboottest1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/show")
	public String show(){
		return "Hello World";		
	}
}
