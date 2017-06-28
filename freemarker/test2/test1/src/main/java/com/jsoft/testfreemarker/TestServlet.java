package com.jsoft.testfreemarker;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name = "test", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Configuration cfg;

	@Override
	public void init() throws ServletException {
		// initialize operation
		cfg = new Configuration(Configuration.VERSION_2_3_26);
		cfg.setServletContextForTemplateLoading(getServletContext(), "WEB-INF/ftl");
	}

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
		response.setCharacterEncoding("utf-8");
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user", "Big Joe");
		// 得到模板
		try {
			// 将模板和数据结合，并返回浏览器
			Template template = cfg.getTemplate("test.ftl");
			template.process(data, response.getWriter());
		} catch (Exception e) {
			// e.printStackTrace();
			response.getWriter().print("暂时无数据");
		}
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
