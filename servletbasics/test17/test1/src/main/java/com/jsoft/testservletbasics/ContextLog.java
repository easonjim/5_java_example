package com.jsoft.testservletbasics;

//Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ContextLog extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {   
	   String par = request.getParameter("par1");
	   //Call the two ServletContext.log methods
	   ServletContext context = getServletContext( );
	   if (par == null || par.equals(""))
	   //log version with Throwable parameter
	   context.log("No message received:", new IllegalStateException("Missing parameter"));
	   else
	       context.log("Here is the visitor's message: " + par);      
	   response.setContentType("text/html");
	   java.io.PrintWriter out = response.getWriter( );
	   String title = "Context Log";
	   String docType =
	   "<!doctype html public \"-//w3c//dtd html 4.0 " +
	   "transitional//en\">\n";
	   out.println(docType +
	     "<html>\n" +
	     "<head><title>" + title + "</title></head>\n" +
	     "<body bgcolor=\"#f0f0f0\">\n" +
	     "<h1 align=\"center\">" + title + "</h1>\n" +
	     "<h2 align=\"center\">Messages sent</h2>\n" +
	     "</body></html>");
	 } //doGet
}
