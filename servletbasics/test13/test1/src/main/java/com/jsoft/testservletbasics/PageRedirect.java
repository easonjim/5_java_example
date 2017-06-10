package com.jsoft.testservletbasics;

import java.io.*;
import java.sql.Date;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class PageRedirect extends HttpServlet{    
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
      // Set response content type
      response.setContentType("text/html");
      // New location to be redirected
      String site = new String("http://www.easonjim.com");
      response.setStatus(response.SC_MOVED_TEMPORARILY);
      response.setHeader("Location", site);    
      //response.sendRedirect(site);
    }
}
