package com.jsoft.springboottest.springboottest1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.springboottest.springboottest1.RemoteService;

@RestController
public class TestController {
	
	@Autowired
	private RemoteService remoteService;
	
	@RequestMapping("/show")
	public String show(){
		try {
			remoteService.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return "Hello World";		
	}
}
