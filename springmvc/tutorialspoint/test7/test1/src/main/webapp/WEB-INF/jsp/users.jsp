<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted User Information</h2>
   <table>
      <tr>
         <td>Username</td>
         <td>${username}</td>
      </tr>
      <tr>
         <td>Password</td>
         <td>${password}</td>
      </tr>    
      <tr>
         <td>Address</td>
         <td>${address}</td>
      </tr>  
      <tr>
         <td>Subscribed to Newsletter</td>
         <td>${receivePaper}</td>
      </tr>          
   </table>  
</body>
</html>