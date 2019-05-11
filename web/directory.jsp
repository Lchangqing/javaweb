<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<style type="text/css">
		body{
			background:rgb(248,249,252);
		}
		a{
			width: 200px;
			text-decoration: none;
			display: block;
			font-family:"楷体";
			margin: 100px auto;
			font-size:20px;
		}
		</style>
	</head>
	<body>
	<% System.out.println("directory:"+request.getSession().getId()); %>
		<div class="box1" >
		<a href="<%= response.encodeURL(request.getContextPath()+"/app/upload.jsp")%>">文件上传功能</a>	
		<a href="<%= response.encodeURL(request.getContextPath()+"/operate.jsp")%>">模糊查询</a>			
		<a href="<%= response.encodeURL(request.getContextPath()+"/shoppingcart/1.jsp")%>">简易购物车</a>						
		<a></a>			
		</div>
	</body>
</html>
