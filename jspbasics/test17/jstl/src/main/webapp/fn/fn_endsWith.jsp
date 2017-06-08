<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>Using JSTL Functions</title>
</head>
<body>

<c:set var="theString" value="I am a test String 123"/>

<c:if test="${fn:endsWith(theString, '123')}">
   <p>String ends with 123<p>
</c:if>

<c:if test="${fn:endsWith(theString, 'TEST')}">
   <p>String ends with TEST<p>
</c:if>

</body>
</html>