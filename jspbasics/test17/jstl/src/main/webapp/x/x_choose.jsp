<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<html>
<head>
  <title>JSTL x:choose Tags</title>
</head>
<body>
<h3>Books Info:</h3>

<c:set var="xmltext">
  <books>
    <book>
      <name>Padam History</name>
      <author>ZARA</author>
      <price>100</price>
    </book>
    <book>
      <name>Great Mistry</name>
      <author>NUHA</author>
      <price>2000</price>
    </book>
  </books>
</c:set>

<x:parse xml="${xmltext}" var="output"/>
<x:choose>
   <x:when select="$output//book/author = 'ZARA'">
      Book is written by ZARA
   </x:when>
   <x:when select="$output//book/author = 'NUHA'">
      Book is written by NUHA
   </x:when>
   <x:otherwise>
      Unknown author.
   </x:otherwise>
</x:choose>

</body>
</html>