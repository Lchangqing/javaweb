<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			body{
				background-color: rgb(241,243,244);
			}
			h1,h3,form{
				text-align: center;
			}
			div{
				padding-top: 20px;
				margin: 100px auto;
				height: 200px;
				width: 300px;
				background-color: rgb(222,225,230);
			}
		</style>
	</head>
	<body>
		<div>
		<h1>登陆失败</h1>
		<h3>用户名或密码错误</h3>
		<form action="log.jsp" method="post">
			
			<input type="submit" value="注册"/>
		</form>
		</div>
	</body>
</html>
