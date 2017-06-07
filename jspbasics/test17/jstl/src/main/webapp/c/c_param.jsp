<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Tag Example</title>
</head>
<body>
<c:url value="https://www.baidu.com" var="myURL">
   <c:param name="trackingId" value="1234"/>
   <c:param name="reportType" value="summary"/>
</c:url>
<c:import url="${myURL}"/>
</body>
</html>