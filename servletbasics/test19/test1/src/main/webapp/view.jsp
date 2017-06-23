<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.jsoft.testservletbasics.UserInfo" %>
<!DOCTYPE HTML >
<html>
<head>
<title>显示页面</title>
</head>
<body>
	<%
      UserInfo user=(UserInfo)request.getAttribute("user");
     %>
	<table border="1" align="center">
		<tr>
			<td>用户名:</td>
			<td><%=user.getUserName()%></td>
		</tr>
		<tr>
			<td>密&nbsp;码:</td>
			<td><%=user.getUserPwd()%></td>
		</tr>
		<tr>
			<td>性别:</td>
			<td><%=user.getUserSex()%></td>
		</tr>
		<tr>
			<td>年龄:</td>
			<td><%=user.getUserAge()%></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><%=user.getUserEmail()%></td>
		</tr>
	</table>
</body>
</html>