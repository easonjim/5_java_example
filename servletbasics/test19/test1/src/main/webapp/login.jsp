<%@ page contentType="text/html;charset=UTF-8" language="Java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
<head>
<title>登录页面</title>
</head>
<body>
	<form action="PassServlet" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>密&nbsp;码:</td>
				<td><input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td><input type="radio" name="sex" value="男" />男 <input
					type="radio" name="name" value="女" />女</td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="注册" /> <input type="reset"
					value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>