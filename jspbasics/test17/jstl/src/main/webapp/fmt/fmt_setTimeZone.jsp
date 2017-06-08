<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>JSTL fmt:setTimeZone Tag</title>
</head>
<body>
<c:set var="now" value="<%=new java.util.Date()%>" />
<p>Date in Current Zone: <fmt:formatDate value="${now}" type="both" timeStyle="long" dateStyle="long" /></p>
<p>Change Time Zone to GMT-8</p>
<fmt:setTimeZone value="GMT-8" />
<p>Date in Changed Zone: <fmt:formatDate value="${now}" type="both" timeStyle="long" dateStyle="long" /></p>
</body>
</html>