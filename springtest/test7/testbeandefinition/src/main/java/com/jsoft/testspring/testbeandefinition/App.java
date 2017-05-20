package com.jsoft.testspring.testbeandefinition;

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
        helloWorld.getMessage1();
        helloWorld.getMessage2();
        
        HelloIndia helloIndia = (HelloIndia)applicationContext.getBean("helloIndia");
        helloIndia.getMessage1();
        helloIndia.getMessage2();
        helloIndia.getMessage3();        

        HelloIndia helloIndia2 = (HelloIndia)applicationContext.getBean("helloIndia2");
        helloIndia2.getMessage1();
        helloIndia2.getMessage2();
        helloIndia2.getMessage3();
    }
}
