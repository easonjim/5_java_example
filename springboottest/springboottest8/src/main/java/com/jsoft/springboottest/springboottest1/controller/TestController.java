package com.jsoft.springboottest.springboottest1.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        logger.info("每隔五秒钟执行一次： " + new Date().toString());
    }

    @Scheduled(cron = "15 52 21 ? * *")
    public void fixTimeExecution() {
        logger.info("在指定时间执行" + new Date().toString());
    }
	
	@RequestMapping("/show")
	public String show(){
		return "Hello World";		
	}
}
