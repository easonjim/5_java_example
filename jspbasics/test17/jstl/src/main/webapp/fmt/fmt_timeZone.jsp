<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
  <head>
    <title>JSTL fmt:timeZone Tag</title>
  </head>

  <body>
    <c:set var="now" value="<%=new java.util.Date()%>" />
    <table border="1" width="100%">
      <tr>
        <td width="100%" colspan="2" bgcolor="#0000FF">
          <p align="center">
            <b>
              <font color="#FFFFFF" size="4">Formatting:
              <fmt:formatDate value="${now}" type="both" timeStyle="long" dateStyle="long" />
              </font>
            </b>
          </p>
        </td>
      </tr>

      <c:forEach var="zone" items="<%=java.util.TimeZone.getAvailableIDs()%>">
        <tr>
          <td width="51%">
            <c:out value="${zone}" />
          </td>
          <td width="49%">
            <fmt:timeZone value="${zone}">
              <fmt:formatDate value="${now}" timeZone="${zn}" type="both" />
            </fmt:timeZone>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>