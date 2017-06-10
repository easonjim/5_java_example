package com.jsoft.testservletbasics;

//Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
//Extend HttpServlet class
public class Refresh extends HttpServlet {
	// Method to handle GET method request.
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	   // Set refresh, autoload time as 5 seconds
	   response.setIntHeader("Refresh", 5);
	   // Set response content type
	   response.setContentType("text/html");
	   // Get current time
	   Calendar calendar = new GregorianCalendar();
	   String am_pm;
	   int hour = calendar.get(Calendar.HOUR);
	   int minute = calendar.get(Calendar.MINUTE);
	   int second = calendar.get(Calendar.SECOND);
	   if(calendar.get(Calendar.AM_PM) == 0)
	     am_pm = "AM";
	   else
	     am_pm = "PM"; 
	   String CT = hour+":"+ minute +":"+ second +" "+ am_pm;   
	   PrintWriter out = response.getWriter();
	   String title = "Auto Page Refresh using Servlet";
	   String docType =
	   "<!doctype html public \"-//w3c//dtd html 4.0 " +
	   "transitional//en\">\n";
	   out.println(docType +
	     "<html>\n" +
	     "<head><title>" + title + "</title></head>\n"+
	     "<body bgcolor=\"#f0f0f0\">\n" +
	     "<h1 align=\"center\">" + title + "</h1>\n" +
	     "<p>Current Time is: " + CT + "</p>\n");
	}
	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doGet(request, response);
	}
}
