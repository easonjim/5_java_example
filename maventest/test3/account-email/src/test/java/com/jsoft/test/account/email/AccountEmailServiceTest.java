package com.jsoft.test.account.email;

import static junit.framework.Assert.assertEquals;

import javax.mail.Message;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

public class AccountEmailServiceTest
{
    private GreenMail greenMail;//这个是用来接受的邮件

    @Before
    public void startMailServer()
        throws Exception
    {
    	//构造接收对象
        greenMail = new GreenMail( ServerSetup.SMTP );
        greenMail.setUser( "test@email.com", "123456" );
        greenMail.start();
    }

    @Test
    public void testSendMail()
        throws Exception
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext( "account-email.xml" );//依赖注入构造发送对象
        AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean( "accountEmailService" );

        String subject = "Test Subject";
        String htmlText = "<h3>Test</h3>";
        accountEmailService.sendMail( "test2@email.com", subject, htmlText );//发送邮件

        greenMail.waitForIncomingEmail( 2000, 1 );//接收邮件

        Message[] msgs = greenMail.getReceivedMessages();
        assertEquals( 1, msgs.length );
        assertEquals( subject, msgs[0].getSubject() );
        assertEquals( htmlText, GreenMailUtil.getBody( msgs[0] ).trim() );
    }

    @After
    public void stopMailServer()
        throws Exception
    {
        greenMail.stop();
    }
}
