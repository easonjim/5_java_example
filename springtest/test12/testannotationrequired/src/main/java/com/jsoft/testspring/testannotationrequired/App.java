package com.jsoft.testspring.testannotationrequired;

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
       	Student student = (Student)applicationContext.getBean("student");
       	System.out.println(student.getAge());
       	System.out.println(student.getName());
    }
}
