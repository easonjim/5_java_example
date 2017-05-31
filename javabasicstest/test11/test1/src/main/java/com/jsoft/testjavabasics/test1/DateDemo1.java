package com.jsoft.testjavabasics.test1;

import java.util.*;
import java.text.*;

public class DateDemo1 {
	public static void main(String args[]) {

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

		System.out.println("Current Date: " + ft.format(dNow));
	}
}
