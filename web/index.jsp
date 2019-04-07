<<<<<<< bdbf626bc0eafa51bdcfcf79839b24cdde4f9e00
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
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

		<title>Wopop</title>
		<link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css" />

	</head>

	<body class="login" mycollectionplug="bind">
		<div class="login_m">
			<div class="login_boder">

				<div class="login_padding" id="login_model">
				
					<form  action="hello" method="POST">	
					<h2>用户名</h2>

					<input  type="text" id="username" name="user" class="txt_input txt_input2" onfocus="if (value ==&#39;Your name&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;Your name&#39;}" value="tomcat" />

					<h2>用户密码</h2>
					
					<input type="password" name="pass" id="userpwd" class="txt_input" onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}" value="123456" />
					<div class="rem_sub">
						<input type="submit" class="sub_button" name="button" id="button" value="登陆" style="opacity: 0.7;"  />
					</div>
					</form>
					<div class="rem_sub">
						<input type="submit" class="sub_button" name="button" id="button" value="注册" style="opacity: 0.7;"onclick="window.location.href='log.jsp';" />
					</div>
					
				</div>

			</div>
		</div>
	</body>

</html>
>>>>>>> point of mvc
