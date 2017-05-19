package com.jsoft.testspring.testsingletonscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = (HelloWorld)applicationContext.getBean("helloWorld");
        helloWorld.setMessage("A");
        System.out.println(helloWorld.getMessage());
        HelloWorld helloWorld2 = (HelloWorld)applicationContext.getBean("helloWorld");
        System.out.println(helloWorld2.getMessage());
    }
}
