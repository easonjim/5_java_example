package com.jsoft.testfreemarker.test1;

import java.util.HashMap;
import java.util.Map;

public class App {
	public static void main(String[] args) {
		FreeMarkerUtil fu = new FreeMarkerUtil();
		// 1、创建数据模型
		Map<String, Object> root = new HashMap<String, Object>();
		// 2、为数据模型添加值
		root.put("user", "Big Joe");
		// 3、将数据模型和模板组合的数据输出到控制台
		fu.fprint("test.ftl", root, "test.html");
	}
}
