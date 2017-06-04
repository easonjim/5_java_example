<html>
<head><title>Hello World</title></head>
<body>
Hello World!<br/>
<%
out.println("Your IP address is " + request.getRemoteAddr());
%>

<%! int i = 0; %> 
<%! int a, b, c; %> 

<p>
   Today's date: <%= (new java.util.Date()).toLocaleString()%>
</p>
<%-- This comment will not be visible in the page source --%> 

</body>
</html>