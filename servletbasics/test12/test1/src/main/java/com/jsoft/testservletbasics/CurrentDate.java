package com.jsoft.testservletbasics;

//Import required java libraries
import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*; 
//Extend HttpServlet class
public class CurrentDate extends HttpServlet { 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	   // Set response content type
	   response.setContentType("text/html"); 
	   PrintWriter out = response.getWriter();
	   String title = "Display Current Date & Time";
	   Date date = new Date();
	   String docType =
	   "<!doctype html public \"-//w3c//dtd html 4.0 " +
	   "transitional//en\">\n";
	   out.println(docType +
	     "<html>\n" +
	     "<head><title>" + title + "</title></head>\n" +
	     "<body bgcolor=\"#f0f0f0\">\n" +
	     "<h1 align=\"center\">" + title + "</h1>\n" +
	     "<h2 align=\"center\">" + date.toString() + "</h2>\n" +
	     "</body></html>");
	}
}