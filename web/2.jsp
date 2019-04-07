<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="1.jsp" %>
<% out.println("this is 2.jsp"); %>
<a href="1.jsp">list</a>
</body>
</html>