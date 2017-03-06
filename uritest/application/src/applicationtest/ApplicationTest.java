package applicationtest;

import java.io.File;

public class ApplicationTest {

	public static void main(String[] args) {
		//1、利用System.getProperty()函数获取当前路径： 
		//System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径
		//System.out.println(System.getProperty("java.class.path"));//java.class.path类路径
		
		/*//2、使用File提供的函数获取当前路径：  
		try{ 
			File directory = new File("");//设定为当前文件夹
		    System.out.println(directory.getCanonicalPath());//获取标准的路径，输出：D:\开发工程\GitHub\5_java_example\123\application 
		    System.out.println(directory.getAbsolutePath());//获取绝对路径，输出：D:\开发工程\GitHub\5_java_example\123\application 
		}catch(Exception e){} 		
		
		 * File.getCanonicalPath()和File.getAbsolutePath()大约只是对于new File(".")和new File("..")两种路径有所区别。
		 * 对于getCanonicalPath()函数，“."就表示当前的文件夹，而”..“则表示当前文件夹的上一级文件夹
		 * 对于getAbsolutePath()函数，则不管”.”、“..”，返回当前的路径加上你在new File()时设定的路径
		 * 至于getPath()函数，得到的只是你在new File()时设定的路径  
		 
		//比如当前的路径为 D:\开发工程\GitHub\5_java_example\123\application ： 
		try{ 
			File directory1 = new File("abc"); 
			System.out.println(directory1.getCanonicalPath());//输出：D:\开发工程\GitHub\5_java_example\123\application\abc
			System.out.println(directory1.getAbsolutePath());//输出：D:\开发工程\GitHub\5_java_example\123\application\abc 
			System.out.println(directory1.getPath());//输出：abc 
		}catch(Exception e){}
		
		try{ 
			File directory2 = new File("."); 
			System.out.println(directory2.getCanonicalPath());//输出：D:\开发工程\GitHub\5_java_example\123\application 
			System.out.println(directory2.getAbsolutePath());//输出：D:\开发工程\GitHub\5_java_example\123\application\. 
			System.out.println(directory2.getPath());//输出：. 
		}catch(Exception e){} 
		
		try{ 
			File directory3 = new File(".."); 
			System.out.println(directory3.getCanonicalPath());//输出：D:\开发工程\GitHub\5_java_example\123 
			System.out.println(directory3.getAbsolutePath());//输出：D:\开发工程\GitHub\5_java_example\123\application\.. 
			System.out.println(directory3.getPath());//输出：.. 
		}catch(Exception e){} */
		/*//3、在类中取得路径：
		//类的绝对路径，指的是编译后字节码class文件放置的位置根目录
		System.out.println(ApplicationTest.class.getResource(""));//当前类(class)所在的包目录，输出：file:/D:/%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b/GitHub/5_java_example/uritest/application/bin/applicationtest/
		System.out.println(Class.class.getResource(""));//当前类(class)所在的包目录，得到的会是null，因为没有这个具体的类，输出：null
		System.out.println(ApplicationTest.class.getResource("/"));//class path根目录，输出：file:/D:/%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b/GitHub/5_java_example/uritest/application/bin/
		System.out.println(Class.class.getResource("/"));//class path根目录，与上面效果一致，输出：file:/D:/%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b/GitHub/5_java_example/uritest/application/bin/
		System.out.println(ApplicationTest.class.getResource("/Test.xml"));//输出：file:/D:/%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b/GitHub/5_java_example/uritest/application/bin/Test.xml
		System.out.println(ApplicationTest.class.getResource("/applicationtest/Test2.xml"));//输出：file:/D:/%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b/GitHub/5_java_example/uritest/application/bin/applicationtest/Test2.xml
		System.out.println(Class.class.getResource("/applicationtest/Test2.xml"));//效果和上面一致，输出：file:/D:/%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b/GitHub/5_java_example/uritest/application/bin/applicationtest/Test2.xml
		System.out.println(ApplicationTest.class.getResource("applicationtest/Test2.xml"));//没有开头的斜杠，无法确定起始的class path根目录，输出：null
		System.out.println(Class.class.getResource("applicationtest/Test2.xml"));//效果和上面一致，输出：null
		//这里取资源文件有个技巧，在src文件夹下的资源文件，编译后都会按照原有的路径全部拷贝到class文件夹放置的位置下，因此会出现如上的取法
		//当然，可以通过判断获取的对象是否为null来确定文件是否存在
		//以下这种写法会自动查找当前文件，但是只能查找当前类所在的包下的文件，如果有子包存在时，要带上子包的路径，同时开头不需要斜杠。
		System.out.println(ApplicationTest.class.getResource("Test.xml"));//不在当前类所在的包下，输出：null
		System.out.println(ApplicationTest.class.getResource("Test3.xml"));//不在当前类所在的包下，输出：null
		System.out.println(ApplicationTest.class.getResource("Test2.xml"));//不在当前类所在的包下，输出：file:/D:/%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b/GitHub/5_java_example/uritest/application/bin/applicationtest/Test2.xml
		System.out.println(Class.class.getResource("Test2.xml"));//返回null，说明还是没有这个具体的类，所以找不到在哪里开始查找文件，输出：null
		//总结：综上测试，具体的类获取资源文件可以免去很多麻烦，建议使用具体的类进行获取；还有中文路径会经过转码。*/	
		
		/*//对比Class.getClassLoader().getResource()
		//类的绝对路径，指的是编译后字节码class文件放置的位置根目录
		System.out.println(ApplicationTest.class.getClassLoader().getResource(""));//class path根目录，输出：file:/D:/%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b/GitHub/5_java_example/uritest/application/bin/
		//System.out.println(Class.class.getClassLoader().getResource(""));//报错
		System.out.println(ApplicationTest.class.getClassLoader().getResource("/"));//输出：null
		//System.out.println(Class.class.getClassLoader().getResource("/"));//报错
		System.out.println(ApplicationTest.class.getClassLoader().getResource("/Test.xml"));//输出：null
		System.out.println(ApplicationTest.class.getClassLoader().getResource("/applicationtest/Test2.xml"));//输出：null
		//System.out.println(Class.class.getClassLoader().getResource("/applicationtest/Test2.xml"));//报错
		System.out.println(ApplicationTest.class.getClassLoader().getResource("applicationtest/Test2.xml"));//没有开头的斜杠，输出：file:/D:/%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b/GitHub/5_java_example/uritest/application/bin/applicationtest/Test2.xml
		//System.out.println(Class.class.getClassLoader().getResource("applicationtest/Test2.xml"));//报错
		//这里取资源文件有个技巧，在src文件夹下的资源文件，编译后都会按照原有的路径全部拷贝到class文件夹放置的位置下，因此会出现如上的取法
		//当然，可以通过判断获取的对象是否为null来确定文件是否存在
		//以下这种写法会自动查找当前文件，但是只能查找class根目录下的文件，所在包下的文件无法找到
		System.out.println(ApplicationTest.class.getClassLoader().getResource("Test.xml"));//输出：file:/D:/%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b/GitHub/5_java_example/uritest/application/bin/Test.xml
		System.out.println(ApplicationTest.class.getClassLoader().getResource("Test3.xml"));//输出：null
		System.out.println(ApplicationTest.class.getClassLoader().getResource("Test2.xml"));//输出：null
		//System.out.println(Class.class.getClassLoader().getResource("Test2.xml"));//报错
		//总结：综上测试，具体的类获取资源文件可以免去很多麻烦，建议使用具体的类进行获取；还有中文路径会经过转码。*/	
		
		//4、File函数与类取路径结合输出：
		try{ 
			File directory1 = new File(ApplicationTest.class.getResource("/Test.xml").getPath()); 
			System.out.println(directory1.getCanonicalPath());//输出：D:\%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b\GitHub\5_java_example\123\application\bin\Test.xml
			System.out.println(directory1.getAbsolutePath());//输出： D:\%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b\GitHub\5_java_example\123\application\bin\Test.xml
			System.out.println(directory1.getPath());//输出：D:\%e5%bc%80%e5%8f%91%e5%b7%a5%e7%a8%8b\GitHub\5_java_example\123\application\bin\Test.xml
		}catch(Exception e){}
		
	}

}
