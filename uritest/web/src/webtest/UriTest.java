package webtest;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UriTest
 */
@WebServlet("/UriTest")
public class UriTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UriTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1、利用System.getProperty()函数获取当前路径： 
		//response.getWriter().println(System.getProperty("user.dir"));
		//response.getWriter().println(System.getProperty("java.class.path"));//java.class.path类路径
		/*//2、使用File提供的函数获取当前路径：  
		try{ 
			File directory = new File("");//设定为当前文件夹
			response.getWriter().println(directory.getCanonicalPath());//获取标准的路径，输出：D:\开发工程\GitHub\5_java_example\123\application 
			response.getWriter().println(directory.getAbsolutePath());//获取绝对路径，输出：D:\开发工程\GitHub\5_java_example\123\application 
		}catch(Exception e){} 		
		
		 * File.getCanonicalPath()和File.getAbsolutePath()大约只是对于new File(".")和new File("..")两种路径有所区别。
		 * 对于getCanonicalPath()函数，“."就表示当前的文件夹，而”..“则表示当前文件夹的上一级文件夹
		 * 对于getAbsolutePath()函数，则不管”.”、“..”，返回当前的路径加上你在new File()时设定的路径
		 * 至于getPath()函数，得到的只是你在new File()时设定的路径  
		 
		//比如当前的路径为 D:\开发工程\GitHub\5_java_example\123\application ： 
		try{ 
			File directory1 = new File("abc"); 
			response.getWriter().println(directory1.getCanonicalPath());//输出：D:\开发工程\GitHub\5_java_example\123\application\abc
			response.getWriter().println(directory1.getAbsolutePath());//输出：D:\开发工程\GitHub\5_java_example\123\application\abc 
			response.getWriter().println(directory1.getPath());//输出：abc 
		}catch(Exception e){}
		
		try{ 
			File directory2 = new File("."); 
			response.getWriter().println(directory2.getCanonicalPath());//输出：D:\开发工程\GitHub\5_java_example\123\application 
			response.getWriter().println(directory2.getAbsolutePath());//输出：D:\开发工程\GitHub\5_java_example\123\application\. 
			response.getWriter().println(directory2.getPath());//输出：. 
		}catch(Exception e){} 
		
		try{ 
			File directory3 = new File(".."); 
			response.getWriter().println(directory3.getCanonicalPath());//输出：D:\开发工程\GitHub\5_java_example\123 
			response.getWriter().println(directory3.getAbsolutePath());//输出：D:\开发工程\GitHub\5_java_example\123\application\.. 
			response.getWriter().println(directory3.getPath());//输出：.. 
		}catch(Exception e){} */
		//3、在类中取得路径：
		/*//类的绝对路径，指的是编译后字节码class文件放置的位置根目录
		response.getWriter().println(UriTest.class.getResource(""));//当前类(class)所在的包目录，输出：file:/D:/开发工程/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/webtest/WEB-INF/classes/webtest/
		response.getWriter().println(Class.class.getResource(""));//当前类(class)所在的包目录，得到的会是null，因为没有这个具体的类，输出：null
		response.getWriter().println(UriTest.class.getResource("/"));//class path根目录，输出：file:/D:/开发工程/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/webtest/WEB-INF/classes/
		response.getWriter().println(Class.class.getResource("/"));//输出：null
		response.getWriter().println(UriTest.class.getResource("/Test.xml"));//输出：file:/D:/开发工程/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/webtest/WEB-INF/classes/Test.xml
		response.getWriter().println(UriTest.class.getResource("/webtest/Test2.xml"));//输出：file:/D:/开发工程/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/webtest/WEB-INF/classes/webtest/Test2.xml
		response.getWriter().println(Class.class.getResource("/webtest/Test2.xml"));//输出：null
		response.getWriter().println(UriTest.class.getResource("webtest/Test2.xml"));//没有开头的斜杠，无法确定起始的class path根目录，输出：null
		response.getWriter().println(Class.class.getResource("webtest/Test2.xml"));//效果和上面一致，输出：null
		//这里取资源文件有个技巧，在src文件夹下的资源文件，编译后都会按照原有的路径全部拷贝到class文件夹放置的位置下，因此会出现如上的取法
		//当然，可以通过判断获取的对象是否为null来确定文件是否存在
		//以下这种写法会自动查找当前文件，但是只能查找当前类所在的包下的文件，如果有子包存在时，要带上子包的路径，同时开头不需要斜杠。
		response.getWriter().println(UriTest.class.getResource("Test.xml"));//不在当前类所在的包下，输出：null
		response.getWriter().println(UriTest.class.getResource("Test3.xml"));//不在当前类所在的包下，输出：null
		response.getWriter().println(UriTest.class.getResource("Test2.xml"));//不在当前类所在的包下，输出：file:/D:/开发工程/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/webtest/WEB-INF/classes/webtest/Test2.xml
		response.getWriter().println(Class.class.getResource("Test2.xml"));//返回null，说明还是没有这个具体的类，所以找不到在哪里开始查找文件，输出：null
		//总结：综上测试，具体的类获取资源文件可以免去很多麻烦，建议使用具体的类进行获取；还有中文路径会经过转码。*/
		
		/*//对比Class.getClassLoader().getResource()
		//类的绝对路径，指的是编译后字节码class文件放置的位置根目录
		response.getWriter().println(UriTest.class.getClassLoader().getResource(""));//class path根目录，输出：file:/D:/开发工程/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/webtest/WEB-INF/classes/
		//Sresponse.getWriter().println(Class.class.getClassLoader().getResource(""));//报错
		response.getWriter().println(UriTest.class.getClassLoader().getResource("/"));//输出：file:/D:/开发工程/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/webtest/WEB-INF/classes/
		//response.getWriter().println(Class.class.getClassLoader().getResource("/"));//报错
		response.getWriter().println(UriTest.class.getClassLoader().getResource("/Test.xml"));//输出：file:/D:/开发工程/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/webtest/WEB-INF/classes/Test.xml
		response.getWriter().println(UriTest.class.getClassLoader().getResource("/webtest/Test2.xml"));//输出：nfile:/D:/开发工程/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/webtest/WEB-INF/classes/webtest/Test2.xml
		//response.getWriter().println(Class.class.getClassLoader().getResource("/webtest/Test2.xml"));//报错
		response.getWriter().println(UriTest.class.getClassLoader().getResource("webtest/Test2.xml"));//没有开头的斜杠，输出：file:/D:/开发工程/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/webtest/WEB-INF/classes/webtest/Test2.xml
		//response.getWriter().println(Class.class.getClassLoader().getResource("webtest/Test2.xml"));//报错
		//这里取资源文件有个技巧，在src文件夹下的资源文件，编译后都会按照原有的路径全部拷贝到class文件夹放置的位置下，因此会出现如上的取法
		//当然，可以通过判断获取的对象是否为null来确定文件是否存在
		//以下这种写法会自动查找当前文件，但是只能查找class根目录下的文件，所在包下的文件无法找到
		response.getWriter().println(UriTest.class.getClassLoader().getResource("Test.xml"));//输出：file:/D:/开发工程/workspace_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/webtest/WEB-INF/classes/Test.xml
		response.getWriter().println(UriTest.class.getClassLoader().getResource("Test3.xml"));//输出：null
		response.getWriter().println(UriTest.class.getClassLoader().getResource("Test2.xml"));//输出：null
		//response.getWriter().println(Class.class.getClassLoader().getResource("Test2.xml"));//报错
		//总结：综上测试，具体的类获取资源文件可以免去很多麻烦，建议使用具体的类进行获取；还有中文路径会经过转码。*/
		
		/*//4、File函数与类取路径结合输出：
		try{ 
			File directory1 = new File(UriTest.class.getResource("/Test.xml").getPath()); 
			response.getWriter().println(directory1.getCanonicalPath());//输出：D:\开发工程\workspace_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\webtest\WEB-INF\classes\Test.xml
			response.getWriter().println(directory1.getAbsolutePath());//输出： D:\开发工程\workspace_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\webtest\WEB-INF\classes\Test.xml
			response.getWriter().println(directory1.getPath());//输出：D:\开发工程\workspace_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\webtest\WEB-INF\classes\Test.xml
		}catch(Exception e){}*/
		
		//5、在Servlet中取得路径： 
		response.getWriter().println(request.getSession().getServletContext().getRealPath(""));//得到工程目录， 参数可具体到包名。输出：D:\开发工程\workspace_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\webtest
		response.getWriter().println(request.getRequestURL());//得到IE地址栏地址。输出：http://localhost:8080/webtest/UriTest
		response.getWriter().println(request.getRequestURI());//得到相对地址，输出：/webtest/UriTest
		response.getWriter().println(request.getServletPath());//根目录所对应的绝对路径，输出：/UriTest		
		response.getWriter().println(request.getContextPath());//得到工程名，输出：//webtest 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
