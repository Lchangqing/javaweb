<%@page import="cn.edu.swu.mvcapp.domain.Customer2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		body{
			background:rgb(248,249,252);
		}
	</style>
</head>
<body style="position:relative">
<div style="position:absolute;left:40%;top:50%">
 <%
 	Customer2 customer=(Customer2)session.getAttribute("customer");
    String [] books=(String[])session.getAttribute("books");
 %>
 <table>
 	<tr>
 		<td>customer name:</td>
 		<td><%= customer.getName() %></td>
 	</tr>
 	<tr>
 		<td>address：</td>
 		<td><%= customer.getAddress() %></td>
 	</tr>
 	<tr>
 		<td>cardID:</td>
 		<td><%= customer.getCard() %></td>
 	</tr>
 	<tr>
 		<td>cardtype:</td>
 		<td><%= customer.getCardType() %></td>
 	</tr>
 	<tr>
 		<td>Books：</td>
 		<td>
 		<%if(books!=null){
 			for(String book:books  ){
 				out.print(book);
 				out.print("<br/>");
 			}}
 		%>
 		</td>
 	</tr>
 </table>
 </div>
</body>
</html>
