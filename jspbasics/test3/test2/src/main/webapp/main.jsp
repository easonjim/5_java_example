<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Using JavaBeans in JSP</title>
</head>
<body>
	<center>
		<h2>Using JavaBeans in JSP</h2>

		<jsp:useBean id="test" class="com.jsoft.testjspbasics.TestBean" />

		<jsp:setProperty name="test" property="message" value="Hello JSP..." />

		<p>Got message....</p>

		<jsp:getProperty name="test" property="message" />

	</center>
</body>
</html>