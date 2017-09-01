<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
   <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>User Information</h2>
<form:form method="POST" action="addUser">
   <table>
      <tr>
         <td><form:label path="username">User Name</form:label></td>
         <td><form:input path="username" /></td>
      </tr>
      <tr>
         <td><form:label path="password">Age</form:label></td>
         <td><form:password path="password" /></td>
      </tr>  
      <tr>
         <td colspan="2">
            <input type="submit" value="Submit"/>
         </td>
      </tr>
   </table>  
</form:form>
</body>
</html>