package com.jsoft.testzookeeper.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private static final Logger log = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello(@RequestParam(name = "name") String name) {
		log.info("param:name->{}", name);
		return "hello: " + name;
	}
}
