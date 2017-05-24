package com.jsoft.testspring.testeventhandling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        
        applicationContext.start();
        
        HelloWorld helloWorld = (HelloWorld)applicationContext.getBean("helloWorld");
        helloWorld.setMessage("Hello World!");
        helloWorld.getMessage();
        
        applicationContext.stop();
    }
}
