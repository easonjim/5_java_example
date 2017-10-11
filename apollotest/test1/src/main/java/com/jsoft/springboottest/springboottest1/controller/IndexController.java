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
@EnableApolloConfig
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	private Config config;

	@Value("${timeout:200}")
	private int timeout;
	@Value("${batch:200}")
	private int batch;
	@Value("${url:http://easonjim.com}")
	private String url;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		Entry entry = new Entry();
		entry.setText("Text");
		entry.setTitle("Title");
		model.addAttribute("entries", entry);
		model.addAttribute("entry", new Entry());
		
		model.addAttribute("url", url);
		model.addAttribute("timeout",timeout);
		model.addAttribute("batch",batch);

		logger.info("timeout:{}", timeout);
		logger.info("batch:{}", batch);
		logger.info("url:{}", url);

		return "index";
	}

	public IndexController() {
		config = ConfigService.getAppConfig();
		config.addChangeListener(new ConfigChangeListener() {
			@Override
			public void onChange(ConfigChangeEvent changeEvent) {
				logger.info("Changes for namespace {}", changeEvent.getNamespace());
				for (String key : changeEvent.changedKeys()) {
					ConfigChange change = changeEvent.getChange(key);
					logger.info("Change - key: {}, oldValue: {}, newValue: {}, changeType: {}", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType());

					if (key.equals("url")) {
						url = change.getNewValue();
					}
					if(key.equals("batch")) {
						batch = Integer.valueOf(change.getNewValue());
					}
					if (key.equals("timeout")) {
						timeout = Integer.valueOf(change.getNewValue());
					}
				}					
			}
		});
	}

}
