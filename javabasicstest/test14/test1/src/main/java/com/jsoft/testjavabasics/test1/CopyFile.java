package com.jsoft.testjavabasics.test1;

import java.io.*;
import java.net.URISyntaxException;

public class CopyFile {
	public static void main(String args[]) throws IOException, URISyntaxException {
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream(CopyFile.class.getClassLoader().getResource("input.txt").toURI().getPath());
			out = new FileOutputStream(CopyFile.class.getClassLoader().getResource("").toURI().getPath()+"output.txt");

			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}