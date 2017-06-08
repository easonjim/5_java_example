<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="java.util.Date,java.text.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<title>JSTL sql:transaction Tag</title>
</head>
<body>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/TEST?serverTimezone=UTC" user="root"  password="root"/>

<%
Date DoB = new Date("2001/12/16");
int studentId = 100;
%>

<sql:transaction dataSource="${snapshot}">
   <sql:update var="count">
      UPDATE Students2 SET last = 'Ali' WHERE Id = 102
   </sql:update>
   <sql:update var="count">
      UPDATE Students2 SET last = 'Shah' WHERE Id = 103
   </sql:update>
   <sql:update var="count">
     INSERT INTO Students2 
     VALUES (104,'Nuha', 'Ali', '2010/05/26');
   </sql:update>
</sql:transaction>

<sql:query dataSource="${snapshot}" var="result">
   SELECT * from Students2;
</sql:query>

<table border="1" width="100%">
<tr>
<th>Emp ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>DoB</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.id}"/></td>
<td><c:out value="${row.first}"/></td>
<td><c:out value="${row.last}"/></td>
<td><c:out value="${row.dob}"/></td>
</tr>
</c:forEach>
</table>

</body>
</html>