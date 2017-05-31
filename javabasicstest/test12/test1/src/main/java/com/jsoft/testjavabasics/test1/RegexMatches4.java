package com.jsoft.testjavabasics.test1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches4 {
	private static String REGEX = "a*b";
	private static String INPUT = "aabfooaabfooabfoob";
	private static String REPLACE = "-";

	public static void main(String[] args) {
		Pattern p = Pattern.compile(REGEX);
		// get a matcher object
		Matcher m = p.matcher(INPUT);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, REPLACE);//将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里。
		}
		m.appendTail(sb);
		System.out.println(sb.toString());//将最后一次匹配工作后剩余的字符串添加到一个StringBuffer对象里
	}
}