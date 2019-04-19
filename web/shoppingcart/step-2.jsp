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
<h4>
step2：请输入寄送地址和信用卡信息
</h4>
<form action="<%= request.getContextPath()%>/process/processstep2" method="post">
<table cellpadding="10" cellspacing="0" boder="1">
		<tr>
			<td colspan="2">寄送信息</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>寄送地址</td>
			<td><input type="text" name="address"/></td>
		</tr>
		<tr>
			<td colspan="2">信用卡信息</td>
		</tr>
		<tr>
			<td>种类</td>
			<td>
				<input type="radio" name="cardtype" value="tom"/>tom
				<input type="radio" name="cardtype" value="master"/>master
			</td>
		</tr>
		<tr>
			<td>卡号</td>
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