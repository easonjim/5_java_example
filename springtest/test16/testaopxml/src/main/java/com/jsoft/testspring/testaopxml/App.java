package com.jsoft.testspring.testaopxml;

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
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
         Student student = (Student) context.getBean("student");
         student.getName();
         student.getAge();      
         student.printThrowException();
    }
}
