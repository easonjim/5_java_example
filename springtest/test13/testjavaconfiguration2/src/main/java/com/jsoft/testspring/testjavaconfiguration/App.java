package com.jsoft.testspring.testjavaconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloWorldConfigB.class);
        HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
        helloWorld.getMessage();
    }
}
