<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
<<<<<<< bdbf626bc0eafa51bdcfcf79839b24cdde4f9e00
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
=======
		<link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css">
		<style type="text/css">
			
			h1{
				margin:30px auto;
				text-align: center;
			}
			#inner{
				margin: 50px auto;
				height: 320px;
				 width: 300px; 
			}
			#inner2{
				padding:10px 85px;
			}
			input{
				display:inline-block;
				width:90px;
				height:35px;
				margin:10px;
			}
		</style>
		<script type="text/javascript">
			window.onload=function(){
			
			var btn2=document.getElementsByTagName("button")[0];
			btn2.onclick=function(){
				history.forward();
			};
			};
		</script>
	</head>
<body class="login" mycollectionplug="bind">
	<div class="login_m">
		<div class="login_boder">
			<div id="inner">
				<h1>登陆失败</h1>
				<h1>用户名或密码错误</h1>
				<div id="inner2">
				<form action="log.jsp" method="post">
					<input type="submit" value="注册" id="i1" />
				</form>
				<form action="index.jsp" method="post">
					<input type="submit" value="返回"  id="i2"/>
				</form>
				</div>
			</div>
		</div>
	</div>
</body>

>>>>>>> point of mvc
</html>
