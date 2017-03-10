import java.io.BufferedInputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.Locale;  
import java.util.Properties;  
import java.util.PropertyResourceBundle;  
import java.util.ResourceBundle;  

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getPath1();
		//getPath2();
		getPath3();
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}
	
	
	/** 
     * 一、 使用java.util.Properties类的load(InputStream in)方法加载properties文件
     * 这个方法的重点在于load中使用的是InputStream，所以只要最终文件返回的是InputStream即可。
     * 1、（不建议使用File对象获取路径）直接new FileInputStream，然后传入绝对路径，一般通过IO对象File获取，参考：http://www.cnblogs.com/EasonJim/p/6503612.html（第二中方法）;但是经过测试此方法打包出jar时是没办法获取的。
     * 2、 使用类中取得路径的方法，获取流，参考：http://www.cnblogs.com/EasonJim/p/6503612.html（第三种方法）
     * 
     * @return 
     */  
    public static void getPath1() {  
  
        try {  
        	/*
        	//1、直接new FileInputStream，然后传入绝对路径（但是经过测试此方法打包出jar时是没办法获取的）
            Properties prop = new Properties();    
            prop.load(new BufferedInputStream(new FileInputStream(new File("test3.properties"))));  
			System.out.println(prop.getProperty("message"));  
			prop.load(new BufferedInputStream(new FileInputStream(new File("appClientModule/test.properties"))));  
			System.out.println(prop.getProperty("message"));  
			prop.load(new BufferedInputStream(new FileInputStream(new File("appClientModule/META-INF/test2.properties"))));  
			System.out.println(prop.getProperty("message"));  
			prop.load(new BufferedInputStream(new FileInputStream(new File("appClientModule/properties/test/test1.properties"))));  
			System.out.println(prop.getProperty("message"));  
			//注意：以上方法导出jar包时，在读取上会找不到文件路径
			*/
			
			//2、 使用类中取得路径的方法
            Properties prop2 = new Properties();    
            prop2.load(Main.class.getResourceAsStream("/test.properties"));  
			System.out.println(prop2.getProperty("message"));  
            prop2.load(Main.class.getResourceAsStream("/properties/test/test1.properties"));  
			System.out.println(prop2.getProperty("message")); 
            prop2.load(Main.class.getResourceAsStream("/META-INF/test2.properties"));  
			System.out.println(prop2.getProperty("message")); 
			
			System.out.println(""); 
			
            Properties prop3 = new Properties();    
            prop3.load(Main.class.getClassLoader().getResourceAsStream("test.properties"));  
			System.out.println(prop3.getProperty("message"));  
            prop3.load(Main.class.getClassLoader().getResourceAsStream("properties/test/test1.properties"));  
			System.out.println(prop3.getProperty("message")); 
            prop3.load(Main.class.getClassLoader().getResourceAsStream("META-INF/test2.properties"));  
			System.out.println(prop3.getProperty("message")); 
			
			System.out.println(""); 
			
			Properties prop4 = new Properties();    
            prop4.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("test.properties"));  
			System.out.println(prop4.getProperty("message"));  
            prop4.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/test/test1.properties"));  
			System.out.println(prop4.getProperty("message")); 
            prop4.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("META-INF/test2.properties"));  
			System.out.println(prop4.getProperty("message")); 
			
			System.out.println(""); 
			
			Properties prop5 = new Properties();    
            prop5.load(ClassLoader.getSystemClassLoader().getResourceAsStream("test.properties"));  
			System.out.println(prop5.getProperty("message"));  
            prop5.load(ClassLoader.getSystemClassLoader().getResourceAsStream("properties/test/test1.properties"));  
			System.out.println(prop5.getProperty("message")); 
            prop5.load(ClassLoader.getSystemClassLoader().getResourceAsStream("META-INF/test2.properties"));  
			System.out.println(prop5.getProperty("message"));
  
        } catch (FileNotFoundException e) {  
            System.out.println("properties文件路径书写有误，请检查！");  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (Exception e){
        	e.printStackTrace();
        } 
    }  
  
    /** 
     * 二、 使用java.util.ResourceBundle类的getBundle()方法 
     * 注意：这个getBundle()方法的参数只能写成包路径+properties文件名，否则将抛异常 
     * 
     * @return 
     */  
    public static void getPath2() {  
    	try{ 
	        System.out.println(ResourceBundle.getBundle("test").getString("message"));
	        System.out.println(ResourceBundle.getBundle("properties/test/test1").getString("message"));
	        System.out.println(ResourceBundle.getBundle("META-INF/test2").getString("message"));
	        
    	} catch (Exception e){
    		e.printStackTrace();
    	}
    }  
  
    /** 
     * 三、 使用java.util.PropertyResourceBundle类的构造函数 
     * 
     * @return 
     */  
    public static void getPath3() {  
        try {  
        	System.out.println(new PropertyResourceBundle(Main.class.getResourceAsStream("/test.properties")).getString("message"));  
        	System.out.println(new PropertyResourceBundle(Main.class.getResourceAsStream("/properties/test/test1.properties")).getString("message"));  
        	System.out.println(new PropertyResourceBundle(Main.class.getResourceAsStream("/META-INF/test2.properties")).getString("message"));

        	System.out.println(""); 
        	
        	System.out.println(new PropertyResourceBundle(Main.class.getClassLoader().getResourceAsStream("test.properties")).getString("message"));  
        	System.out.println(new PropertyResourceBundle(Main.class.getClassLoader().getResourceAsStream("properties/test/test1.properties")).getString("message"));  
        	System.out.println(new PropertyResourceBundle(Main.class.getClassLoader().getResourceAsStream("META-INF/test2.properties")).getString("message"));  

        	System.out.println(""); 
        	
        	System.out.println(new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("test.properties")).getString("message"));  
        	System.out.println(new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/test/test1.properties")).getString("message"));  
        	System.out.println(new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("META-INF/test2.properties")).getString("message"));

        	System.out.println(""); 
        	
        	System.out.println(new PropertyResourceBundle(ClassLoader.getSystemClassLoader().getResourceAsStream("test.properties")).getString("message"));  
        	System.out.println(new PropertyResourceBundle(ClassLoader.getSystemClassLoader().getResourceAsStream("properties/test/test1.properties")).getString("message"));  
        	System.out.println(new PropertyResourceBundle(ClassLoader.getSystemClassLoader().getResourceAsStream("META-INF/test2.properties")).getString("message")); 
            
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  

}