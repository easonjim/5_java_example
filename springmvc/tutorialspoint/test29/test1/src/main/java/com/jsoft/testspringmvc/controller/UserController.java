package com.jsoft.testspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsoft.testspringmvc.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable String name) {

		User user = new User();

		user.setName(name);
		user.setId(1);
		return user;
	}
}
