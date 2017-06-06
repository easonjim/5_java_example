<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Setting HTTP Status Code</title>
</head>
<body>
<%
   // Set error code and reason.
   response.sendError(407, "Need authentication!!!" );
%>
</body>
</html>