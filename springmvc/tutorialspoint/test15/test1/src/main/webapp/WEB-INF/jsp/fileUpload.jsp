<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>File Upload Example</title>
</head>
<body>
   <form:form method="POST" modelAttribute="fileUpload" enctype="multipart/form-data">
      Please select a file to upload : 
      <input type="file" name="file" />
      <input type="submit" value="upload" />
   </form:form>
</body>
</html>