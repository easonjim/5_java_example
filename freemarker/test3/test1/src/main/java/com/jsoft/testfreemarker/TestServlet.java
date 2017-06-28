package com.jsoft.testfreemarker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name = "test", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public TestServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		request.setAttribute("strValue", strValue);
		request.setAttribute("objectArray", objectArray);
		request.setAttribute("strList", strList);
		request.setAttribute("map", map);
		request.setAttribute("myDate", myDate);
		request.setAttribute("setData", setData);
		request.getRequestDispatcher("/WEB-INF/ftl/test.ftl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
