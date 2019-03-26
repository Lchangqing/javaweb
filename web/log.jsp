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
	<form  action="register" method="POST">	
	<div id="class1" >
		用户:<input type="text" name="user"><br /><br />
	    密码:<input	type="password" name="pass"><br /><br />
	         <input type="submit"name="submit" value="注册">
	</div>
	</form>

</body>
</html>
