<%@ page language = "java" contentType = "text/html"%>
<html xmlns = "http://www.w3c.org/1999/xhtml"
   xmlns:jsp = "http://java.sun.com/JSP/Page">
   
   <head><title>Generate XML Element</title></head>
   
   <body>
      <jsp:element name = "xmlElement">
         <jsp:attribute name = "xmlElementAttr">
            Value for the attribute
         </jsp:attribute>
         
         <jsp:body>
            Body for XML element
         </jsp:body>
      
      </jsp:element>
   </body>
</html>