<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
			#class1{
				text-align: center;
				margin:50px;
			}
			body{
				background-color: rgb(241,243,244);
			}
</style>
</head>
<body>
<div id="class1">
       <form  action="hello" method="POST">	
		用户:<input type="text" name="user"><br /><br />
	    密码:<input	type="password" name="pass"><br /><br />
	         <input type="submit"name="submit" value="登陆">
	</form>
	<br />

	<form  action="log.jsp" method="POST">	
	         <input type="submit"name="submit" value="注册">
	</form>
</div>
</body>
</html>
