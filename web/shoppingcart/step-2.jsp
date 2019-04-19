<%@page language="java" contentType="text/html; charset=UTF-8"
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
<h4>
step2：please input the message of  address and card information
</h4>
<form action="<%= request.getContextPath()%>/process/processstep2" method="post">
<table cellpadding="10" cellspacing="0" boder="1">
		<tr>
			<td colspan="2">send information</td>
		</tr>
		<tr>
			<td>name</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>send address</td>
			<td><input type="text" name="address"/></td>
		</tr>
		<tr>
			<td colspan="2">card  information</td>
		</tr>
		<tr>
			<td>card type</td>
			<td>
				<input type="radio" name="cardtype" value="tom"/>Bank fo China
				<input type="radio" name="cardtype" value="master"/>agricultural bank
			</td>
		</tr>
		<tr>
			<td>cardID</td>
				<td><input type="text" name="card"/>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="submit"/></td>
		</tr>
</table>
</form>
</div>
</body>
</html>
