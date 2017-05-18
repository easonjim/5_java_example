package com.jsoft.testspring.testbeanfactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        HelloWorld helloWorld = (HelloWorld)xmlBeanFactory.getBean("helloWorld");
        System.out.println(helloWorld.getMessage());
    }
}
