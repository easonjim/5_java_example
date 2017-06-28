package com.jsoft.testspring.testmvchelloworld;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String printHello(ModelMap model){
		model.addAttribute("message","Hello Spring MVC Framework!");
		return "hello";
	}
	
	@RequestMapping(value = "/welcome", method = { RequestMethod.GET })
	public ModelAndView getFirstPage(HttpServletRequest request) {
		
		String strValue = "this is String";
		Date myDate = new Date();
		Object[] objectArray = new Object[] { 1, "str", 1.2 };

		Set<Object> setData = new HashSet<Object>();
		setData.add("dataValue1");
		setData.add("dataValue2");
		setData.add("dataValue3");

		List<String> strList = new ArrayList<String>();
		strList.add("字符串1");
		strList.add("字符串2");
		strList.add("字符串3");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");

		//welcom就是视图的名称（welcom.ftl）
		ModelAndView mv = new ModelAndView("welcom");
		mv.addObject("strValue", strValue);
		mv.addObject("objectArray", objectArray);
		mv.addObject("strList", strList);
		mv.addObject("map", map);
		mv.addObject("myDate", myDate);
		mv.addObject("setData", setData);
		return mv;
	}
}
