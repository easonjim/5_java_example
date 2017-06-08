<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>JSTL fmt:bundle Tag</title>
</head>
<body>

<fmt:bundle basename="com.jsoft.Example" prefix="count.">
   <fmt:message key="one"/><br/>
   <fmt:message key="two"/><br/>
   <fmt:message key="three"/><br/>
</fmt:bundle>

</body>
</html>