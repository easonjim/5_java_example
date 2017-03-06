<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=request.getSession().getServletContext().getRealPath("") %><br/><!-- //得到工程目录， 参数可具体到包名。输出：D:\开发工程\workspace_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\webtest -->
<%=request.getRequestURL() %><br/><!-- //得到IE地址栏地址。输出：http://localhost:8080/webtest/index.jsp -->
<%=request.getRequestURI() %><br/><!-- //得到相对地址，输出：/webtest/index.jsp -->
<%=request.getServletPath() %><br/><!-- //根目录所对应的绝对路径，输出：/index.jsp -->		
<%=request.getContextPath() %><br/><!-- //得到工程名，输出：//webtest --> 
<%=application.getRealPath("index.jsp") %><br/><!-- //得到页面所在服务器的全路径，输出：//D:\开发工程\workspace_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\webtest\index.jsp --> 
</body>
</html>