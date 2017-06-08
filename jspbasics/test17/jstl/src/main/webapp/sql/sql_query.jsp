<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<title>JSTL sql:setDataSource Tag</title>
</head>
<body>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/TEST?serverTimezone=UTC" user="root"  password="root"/>
<sql:query dataSource="${snapshot}" sql="select * from student" var="result" />
<c:forEach var="row" items="${result.rows}">
	<c:out value="${row.name}"/>:<c:out value="${row.age}"/><br/>
</c:forEach>
</body>
</html>