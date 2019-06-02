<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css">
		<script type="text/javascript">
		
		
			
			
			window.onload=function(){
			
			var btn2=document.getElementsByTagName("button")[0];
			btn2.onclick=function(){
				history.forward();
			};
			};
		</script>
		<style type="text/css">
			#inner{
				margin:20px auto;
				width: 300px;
				text-align:center;
			}
			h1{
				margin:70px auto 100px;
			}
			button{
				diaplay:block;
				margin:0 auto;
			}
		</style>
		
	</head>

		<body class="login" mycollectionplug="bind">
		<div class="login_m">
			<div class="login_boder">
				<div  id="inner">
				<h1>页面出错</h1>
				<button>返回页面</button>
				</div>
			</div>
		</div>
	</body>
</html>