<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<title>JSTL sql:update Tag</title>
</head>
<body>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/TEST?serverTimezone=UTC" user="root"  password="root"/>

<sql:update dataSource="${snapshot}" var="count">
   INSERT INTO Student (name,age) VALUES ('Jim', '27');
</sql:update>

<sql:query dataSource="${snapshot}" var="result">
   SELECT * from Student;
</sql:query>

<table border="1" width="100%">
<tr>
<th>ID</th>
<th>Name</th>
<th>Age</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.id}"/></td>
<td><c:out value="${row.name}"/></td>
<td><c:out value="${row.age}"/></td>
</tr>
</c:forEach>
</table>

</body>
</html>