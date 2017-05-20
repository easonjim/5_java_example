package com.jsoft.testspring.testbeanpostprocessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext abstractApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = (HelloWorld)abstractApplicationContext.getBean("helloWorld");
        helloWorld.getMessage();
        abstractApplicationContext.registerShutdownHook();
    }
}
