package com.jsoft.testjavabasics.test1;

import java.io.File;

public class CreateDir {
	public static void main(String args[]) {
		String dirname = "C:/user/java/bin";
		File d = new File(dirname);
		// Create directory now.
		d.mkdirs();
	}
}
