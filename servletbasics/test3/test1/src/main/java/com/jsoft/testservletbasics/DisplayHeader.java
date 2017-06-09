package com.jsoft.testservletbasics;

//Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
//Extend HttpServlet class
public class DisplayHeader extends HttpServlet {
	// Method to handle GET method request.
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	   // Set response content type
	   response.setContentType("text/html"); 
	   PrintWriter out = response.getWriter();
	   String title = "HTTP Header Request Example";
	   String docType =
	   "<!doctype html public \"-//w3c//dtd html 4.0 " +
	   "transitional//en\">\n";
	   out.println(docType +
	     "<html>\n" +
	     "<head><title>" + title + "</title></head>\n"+
	     "<body bgcolor=\"#f0f0f0\">\n" +
	     "<h1 align=\"center\">" + title + "</h1>\n" +
	     "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
	     "<tr bgcolor=\"#949494\">\n" +
	     "<th>Header Name</th><th>Header Value(s)</th>\n"+
	     "</tr>\n"); 
	   Enumeration headerNames = request.getHeaderNames();      
	   while(headerNames.hasMoreElements()) {
	      String paramName = (String)headerNames.nextElement();
	      out.print("<tr><td>" + paramName + "</td>\n");
	      String paramValue = request.getHeader(paramName);
	      out.println("<td> " + paramValue + "</td></tr>\n");
	   }
	   out.println("</table>\n</body></html>");
	}
	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doGet(request, response);
	}
}
