<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>JSTL fmt:setLocale Tag</title>
</head>
<body>

<fmt:bundle basename="com.jsoft.Example">
   <fmt:message key="count.one"/><br/>
   <fmt:message key="count.two"/><br/>
   <fmt:message key="count.three"/><br/>
</fmt:bundle>

<!-- Change the Locale -->
<fmt:setLocale value="es_ES"/>
<fmt:bundle basename="com.jsoft.Example">
   <fmt:message key="count.one"/><br/>
   <fmt:message key="count.two"/><br/>
   <fmt:message key="count.three"/><br/>
</fmt:bundle>

</body>
</html>