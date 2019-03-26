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
		<h1>注册失败</h1>
		<h3>点击返回注册页面重新注册</h3>
		<form action="log.jsp" method="post">
			
			<input type="submit" value="返回"/>
		</form>
		</div>
	</body>
</html>
