<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>JSTL fmt:parseNumber Tag</title>
</head>
<body>
<h3>Number Parsing:</h3>
<c:set var="balance" value="1250003.350" />

<fmt:parseNumber var="i" type="number" value="${balance}" />
<p>Parsed Number (1) : <c:out value="${i}" /></p>
<fmt:parseNumber var="i" integerOnly="true" type="number" value="${balance}" />
<p>Parsed Number (2) : <c:out value="${i}" /></p>

</body>
</html>