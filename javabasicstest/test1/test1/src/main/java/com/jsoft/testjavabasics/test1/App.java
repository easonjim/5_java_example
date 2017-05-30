package com.jsoft.testjavabasics.test1;

import com.jsoft.testjavabasics.test1.FreshJuice.FreshJuiceSize;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuiceSize.SMALL;
        System.out.println("Size:"+juice.size);
    }
}
