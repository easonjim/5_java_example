package com.jsoft.test.hellospring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsoft.test.hellospring.helloworld.HelloWorld;
import com.jsoft.test.hellospring.helloworld.HelloWorldService;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    
    public static void main( String[] args )
    {
        logger.info("test");
    	//IoC获取beans的上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //通过上下文获取beans创建的Service，此时已经注入了是创建哪个的接口实现
        HelloWorldService helloWorldService = (HelloWorldService)context.getBean("helloWorldService");
        //Service调用统一接口方法获取注入的接口实现
        HelloWorld helloWorld = helloWorldService.getHelloWorld();
        //输出接口实现的内容
        helloWorld.sayHello();
    }
}
