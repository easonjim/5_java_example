package com.jsoft.testspring.testapplicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\开发工程\\GitHub\\5_java_example\\springtest\\test3\\testapplicationcontext\\src\\main\\resources\\beans.xml");
    	HelloWorld helloWorld = (HelloWorld)applicationContext.getBean("helloWorld");
    	System.out.println(helloWorld.getMessage());
    }
}
