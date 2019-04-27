<%@page import="cn.edu.swu.mvcapp.domain.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Bootstrap 101 Template</title>

		<!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="css/sb-admin-2.min.css" rel="stylesheet">

		<!-- Custom styles for this page -->
		<link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
		<style type="text/css">
			body {
				font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
				font-size: 18px;
				line-height: 1.42857143;
				color: #333;
				background-color: rgb(248, 249, 252);
			}
		</style>
	</head>

	<body id="page-top">

		<div id="wrapper">
			<div class="container">
				<br /> <br />
				<%
				Object msg = request.getAttribute("message");
				if (msg != null) {
			%>
				<br />
				<font color="darkred">
					<%=msg%>
				</font> <br /> <br />
				<%
				}
			%>
			<br />
<br />
<br />
<% 
	
	String id=null;
	String oldName=null;
	String name=null;
	String address=null;
	String phone=null;
	Customer customer=(Customer)request.getAttribute("customer");
	if(customer!=null){
		id=customer.getId()+"";
		oldName=customer.getName();
		name=customer.getName();
		name=customer.getName();
		address=customer.getAddress();
		phone=customer.getPhone();
		
	}else{
		id=request.getParameter("id");
		oldName=request.getParameter("oldName");
		name=request.getParameter("oldName");
		address=request.getParameter("address");
		phone=request.getParameter("phone");
	}
%>
				<form action="<%=response.encodeURL(request.getContextPath()+"/update.do") %>" method="post">
					<input type="hidden" name="id" value="<%= id %>" />
					<input type="hidden" name="oldName" value="<%= oldName %>" />
					<div class="row ">
						<div class="col-md-1  col-md-offset-4">name</div>
						<input class="col-md-3" type="text" name="name" value="<%=oldName%>" />
					</div>
					<br />
					<div class="row ">
						<div class="col-md-1 col-md-offset-4">address</div>
						<input class="col-md-3" type="text" name="address" value="<%=address%>" />
					</div>
					<br />
					<div class="row ">
						<div class="col-md-1 col-md-offset-4">phone</div>
						<input class="col-md-3" type="text" name="phone" value="<%=phone%>" />
					</div>

					<br /> <input type="submit" class="col-md-2 col-md-offset-6" value="submit" />

				</form>
				<br />
				<hr />

			</div>
		</div>
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
	</body>

</html>