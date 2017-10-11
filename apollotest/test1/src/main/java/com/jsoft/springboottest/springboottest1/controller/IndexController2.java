package com.jsoft.springboottest.springboottest1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

@Controller
public class IndexController2 {

	private static final Logger logger = LoggerFactory.getLogger(IndexController2.class);

	private Config config = ConfigService.getAppConfig();

	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String index(Model model) {
		Entry entry = new Entry();
		entry.setText("Text");
		entry.setTitle("Title");
		model.addAttribute("entries", entry);
		model.addAttribute("entry", new Entry());
		
		model.addAttribute("url", config.getProperty("url", ""));
		model.addAttribute("timeout",config.getProperty("timeout", ""));
		model.addAttribute("batch",config.getProperty("batch", ""));

		logger.info("timeout:{}", config.getProperty("timeout", ""));
		logger.info("batch:{}", config.getProperty("batch", ""));
		logger.info("url:{}", config.getProperty("url", ""));

		return "index";
	}

}
