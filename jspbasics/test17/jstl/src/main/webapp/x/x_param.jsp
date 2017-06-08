<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %> 

<c:set var="doc1">
    <document>
        <description>This is first document.</description>
    </document>
</c:set> 

<x:parse varDom="doc2">
    <document>
        <description>This is second document.</description>
    </document>
</x:parse> 

<x:parse varDom="doc3">
    <document>
        <description>This is third document.</description>
    </document>
</x:parse> 

<c:set var="xslt">
    <?xml version="1.0"?>
    <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:output method="xml" omit-xml-declaration="yes" indent="yes" />
        <xsl:param name="doc2"/>
        <xsl:param name="doc3"/>
        
        <xsl:template match="/">
            <xsl:value-of select="/document/description" /><br />
            <xsl:value-of select="$doc2/document/description" /><br />
            <xsl:value-of select="$doc3/document/description" /><br />
        </xsl:template>
        
    </xsl:stylesheet>
</c:set> 

<html>
    <head><title>Example of x:param tag of JSTL</title></head>
    <body>
        <x:transform xml="${doc1}" xslt="${xslt}">
            <x:param name="doc2" value="${doc2}" />
            <x:param name="doc3" value="${doc3}" />
        </x:transform>
    </body>
</html>
