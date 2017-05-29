package com.jsoft.testspring.testlog4juse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	static Logger log = (Logger) LogManager.getLogger(App.class.getName());
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		log.info("Going to create HelloWord Obj");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		log.info("Exiting the program");
	}
}
