<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
   // CreateCookiesfor first and last names.      
  Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
  Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));

   // Set expiry date after 24 Hrs for both theCookies.
   firstName.setMaxAge(60*60*24); 
   lastName.setMaxAge(60*60*24); 

   // Add both theCookiesin the response header.
   response.addCookie( firstName );
   response.addCookie( lastName );
%>
<html>
<head>
<title>SettingCookies</title>
</head>
<body>
<center>
<h1>SettingCookies</h1>
</center>
<ul>
<li><p><b>First Name:</b>
   <%= request.getParameter("first_name")%>
</p></li>
<li><p><b>Last  Name:</b>
   <%= request.getParameter("last_name")%>
</p></li>
</ul>
</body>
</html>