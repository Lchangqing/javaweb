<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="position:relative">
<div style="position:absolute;left:40%;top:50%">
<h4>step1:choose the book you want</h4>
<form action="<%= request.getContextPath() %>/processstep1" method="post">
	<table border="1" cellpadding="10" cellspacing="0" >
		<tr>
			<td>书名</td>
			<td>购买</td>
		</tr>
		<tr>
			<td>Java</td>
			<td><input type="checkbox" name="book" value="java" /></td>
		</tr>
		<tr>
			<td>Oracle</td>
			<td><input type="checkbox" name="book" value="oracle" /></td>
		</tr>
		<tr>
			<td>Struts</td>
			<td><input type="checkbox" name="book" value="struts" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"  value="submit" /></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>