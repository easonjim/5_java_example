package com.jsoft.testspring.testcustomevent;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CustomEventPublisher publisher = (CustomEventPublisher)context.getBean("customEventPublisher");
        publisher.publish();
        publisher.publish();
    }
}
