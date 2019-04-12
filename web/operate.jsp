<%@page import="cn.edu.swu.mvcapp.domain.Customer"%>
<%@page import="java.util.List"%>
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
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">
<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 18px;
	line-height: 1.42857143;
	color: #333;
	background-color: rgb(248, 249, 252);
}
</style>
<script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
<script type="text/javascript">
			$(function() {
				$(".delete").click(function() {
					var content = $(this).parent().parent().find("td:eq(1)").text();
					var flag = confirm("确定删除" + content + "的信息吗？");
					return flag;
				});
			});
		</script>
</head>

<body id="page-top">
	<div id="wrapper">
		<div class="container">
			<br />
			<br />
			<form action="query.do" method="post">
				<div class="row ">
					<div class="col-md-1  col-md-offset-4">name</div>
					<input class="col-md-3" type="text" name="name" />
				</div>
				<br />
				<div class="row ">
					<div class="col-md-1 col-md-offset-4">address</div>
					<input class="col-md-3" type="text" name="address" />
				</div>
				<br />
				<div class="row ">
					<div class="col-md-1 col-md-offset-4">phone</div>
					<input class="col-md-3" type="text" name="phone" />
				</div>

				<br /> 
					<input type="submit" class="col-md-2 col-md-offset-6" value="query" />
				 <br /> <br />
				 <a href="newcustomer.jsp " class="col-md-2 col-md-offset-6  active"
					style="height: 1.8em; text-align: center;"> add new customer </a>
			</form>
			<br />
			<hr />
			<br />
			<%
				List<Customer> customers=(List<Customer>)request.getAttribute("customers");
				if(customers==null ){%>
				<h3 style="padding-left:23em;">不输入条件的查询会输出所有内容</h3>
				<% } 
				else if(customers!=null && customers.size()>0){
				%>
			<div class="row justify-content-center">
				<div class="col-md-6 ">
					<table class="table table-bordered table-striped table-hover">
						<thead>
							<tr>
								<th>id</th>
								<th>name</th>
								<th>phone</th>
								<th>address</th>
								<th>update/delete</th>
							</tr>
						</thead>
						<tbody>
							<%
									for(Customer customer :customers){
								%>
							<tr>
								<td><%= customer.getId() %></td>
								<td><%= customer.getName() %></td>
								<td><%= customer.getAddress() %></td>
								<td><%= customer.getPhone() %></td>
								<td><a href="edit.do?id=<%= customer.getId()%>"> update</a>
									<a href="delete.do?id=<%= customer.getId() %>" class="delete">
									delete</a>
								</td>
							</tr>
							<% 			}}else{%>
											<h3 style="padding-left:23em;">there is no record that matches your query</h3>
										<% }
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>

</html>