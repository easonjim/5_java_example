package com.jsoft.testspring.testautowiringbytype;

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
        TextEditor textEditor = (TextEditor)applicationContext.getBean("textEditor");
        textEditor.spellCheck();
        textEditor.getName();
    }
}
