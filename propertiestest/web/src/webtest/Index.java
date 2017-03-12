package webtest;

import java.io.IOException;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet(description = "首页", urlPatterns = { "/Index" })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1、使用java.util.Properties类的load(InputStream in)方法加载properties文件：
		/*Properties prop2 = new Properties();   
		prop2.load(Index.class.getResourceAsStream("/test4.properties"));  
		System.out.println(prop2.getProperty("message"));  
		prop2.load(Index.class.getResourceAsStream("/properties/test/test5.properties"));  
		System.out.println(prop2.getProperty("message")); 
		prop2.load(Index.class.getResourceAsStream("/webtest/test7.properties"));  
		System.out.println(prop2.getProperty("message"));  		
		//以下为servlet独有
		prop2.load(request.getSession().getServletContext().getResourceAsStream("/META-INF/test3.properties"));  
		System.out.println(prop2.getProperty("message")); 
		prop2.load(request.getSession().getServletContext().getResourceAsStream("/WEB-INF/lib/test6.properties"));  
		System.out.println(prop2.getProperty("message")); 
		prop2.load(request.getSession().getServletContext().getResourceAsStream("/WEB-INF/test2.properties"));  
		System.out.println(prop2.getProperty("message")); 
		prop2.load(request.getSession().getServletContext().getResourceAsStream("/test1.properties"));  
		System.out.println(prop2.getProperty("message")); 

		System.out.println(""); 

		Properties prop3 = new Properties(); 
		prop3.load(Index.class.getClassLoader().getResourceAsStream("test4.properties"));  
		System.out.println(prop3.getProperty("message"));  
		prop3.load(Index.class.getClassLoader().getResourceAsStream("properties/test/test5.properties"));  
		System.out.println(prop3.getProperty("message")); 
		prop3.load(Index.class.getClassLoader().getResourceAsStream("webtest/test7.properties"));  
		System.out.println(prop3.getProperty("message")); 
		prop3.load(Index.class.getClassLoader().getResourceAsStream("../../META-INF/test3.properties"));  
		System.out.println(prop3.getProperty("message"));  
		prop3.load(Index.class.getClassLoader().getResourceAsStream("../lib/test6.properties"));  
		System.out.println(prop3.getProperty("message")); 
		prop3.load(Index.class.getClassLoader().getResourceAsStream("../test2.properties"));  
		System.out.println(prop3.getProperty("message")); 
		prop3.load(Index.class.getClassLoader().getResourceAsStream("../../test1.properties"));  
		System.out.println(prop3.getProperty("message")); 
		
		System.out.println(""); 

		Properties prop4 = new Properties();    
		prop4.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("test4.properties"));  
		System.out.println(prop4.getProperty("message"));  
		prop4.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/test/test5.properties"));  
		System.out.println(prop4.getProperty("message")); 
		prop4.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("webtest/test7.properties"));  
		System.out.println(prop4.getProperty("message")); 
		prop4.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("../../META-INF/test3.properties"));  
		System.out.println(prop4.getProperty("message"));  
		prop4.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("../lib/test6.properties"));  
		System.out.println(prop4.getProperty("message")); 
		prop4.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("../test2.properties"));  
		System.out.println(prop4.getProperty("message")); 
		prop4.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("../../test1.properties"));  
		System.out.println(prop4.getProperty("message")); 

		System.out.println(""); */
		
		//ClassLoader.getSystemClassLoader().getResourceAsStream()在web中不可用
		/*Properties prop5 = new Properties();    
		prop5.load(ClassLoader.getSystemClassLoader().getResourceAsStream("test4.properties"));  
		System.out.println(prop5.getProperty("message"));  
		prop5.load(ClassLoader.getSystemClassLoader().getResourceAsStream("properties/test/test5.properties"));  
		System.out.println(prop5.getProperty("message")); 
		prop5.load(ClassLoader.getSystemClassLoader().getResourceAsStream("webtest/test7.properties"));  
		System.out.println(prop5.getProperty("message"));*/
		
		
		//2、使用java.util.ResourceBundle类的getBundle()方法：
		//注意：这个getBundle()方法的参数只能写成包路径+properties文件名，也就说不用带文件的后缀。
		/*System.out.println(ResourceBundle.getBundle("test4").getString("message"));
		System.out.println(ResourceBundle.getBundle("properties/test/test5").getString("message"));
		System.out.println(ResourceBundle.getBundle("webtest/test7").getString("message"));*/
		//以下无法正常获取
		/*System.out.println(ResourceBundle.getBundle("/../../META-INF/test3").getString("message"));
		System.out.println(ResourceBundle.getBundle("../lib/test6").getString("message"));
		System.out.println(ResourceBundle.getBundle("../test2").getString("message"));
		System.out.println(ResourceBundle.getBundle("../../test1").getString("message"));*/
		
		//3、使用java.util.PropertyResourceBundle类的构造函数：
		System.out.println(new PropertyResourceBundle(Index.class.getResourceAsStream("/test4.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Index.class.getResourceAsStream("/properties/test/test5.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Index.class.getResourceAsStream("/webtest/test7.properties")).getString("message")); 
		//以下为servlet独有
		System.out.println(new PropertyResourceBundle(request.getSession().getServletContext().getResourceAsStream("/META-INF/test3.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(request.getSession().getServletContext().getResourceAsStream("/WEB-INF/lib/test6.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(request.getSession().getServletContext().getResourceAsStream("/WEB-INF/test2.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(request.getSession().getServletContext().getResourceAsStream("/test1.properties")).getString("message")); 

		System.out.println(""); 

		System.out.println(new PropertyResourceBundle(Index.class.getClassLoader().getResourceAsStream("test4.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Index.class.getClassLoader().getResourceAsStream("properties/test/test5.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Index.class.getClassLoader().getResourceAsStream("webtest/test7.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Index.class.getClassLoader().getResourceAsStream("../../META-INF/test3.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Index.class.getClassLoader().getResourceAsStream("../lib/test6.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Index.class.getClassLoader().getResourceAsStream("../test2.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Index.class.getClassLoader().getResourceAsStream("../../test1.properties")).getString("message")); 
		
		System.out.println(""); 

		System.out.println(new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("test4.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/test/test5.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("webtest/test7.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("../../META-INF/test3.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("../lib/test6.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("../test2.properties")).getString("message")); 
		System.out.println(new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("../../test1.properties")).getString("message")); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
