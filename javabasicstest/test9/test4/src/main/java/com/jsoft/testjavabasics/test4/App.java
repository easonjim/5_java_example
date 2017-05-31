package com.jsoft.testjavabasics.test4;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String fs;
    	fs = String.format("The value of the float variable is " +
    	                   "%f, while the value of the integer " +
    	                   "variable is %d, and the string " +
    	                   "is %s",0.0f , 0, "test");
    	System.out.println(fs);
    }
}
