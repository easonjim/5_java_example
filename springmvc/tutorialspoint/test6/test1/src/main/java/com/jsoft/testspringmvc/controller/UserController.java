package com.jsoft.testspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.testspringmvc.model.User;

import org.springframework.ui.ModelMap;

@Controller
public class UserController {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user() {
		return new ModelAndView("user", "command", new User());
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("SpringWeb") User user, ModelMap model) {
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("address", user.getAddress());
		return "users";
	}
}
