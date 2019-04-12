<%@page import="cn.edu.swu.mvcapp.domain.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(function(){
	$(".delete").click(function(){
		var content =$(this).parent().parent().find("td:eq(1)").text();
		var flag=confirm("确定删除"+content+"的信息吗？");
		return flag;
	});
});
</script>
</head>
<body>
<form action="query.do" method="post">
	<table>
		<tr>
			<td>customername:</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>address:</td>
			<td><input type="text" name="address" /></td>
		</tr>
		<tr>
			<td>phone:</td>
			<td><input type="text" name="phone" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="query" /></td>
			<td><a href="newcustomer.jsp">add new  customer</a></td>
		</tr>
	</table>
</form>
<br /><br />
<%
	List<Customer> customers=(List<Customer>)request.getAttribute("customers");
	if(customers==null )System.out.println("null");
	if(customers!=null && customers.size()>0){
%>
<hr>
<br /><br />
<table border="3px" cellpadding="10px" cellspacing="0">
	<tr>
		<th>id</th>
		<th>customername</th>
		<th>address</th>
		<th>phone</th>
		<th>update/delete</th>
	</tr>

	<%
		for(Customer customer :customers){
	%>
	<tr>
		<td><%= customer.getId() %></td>
		<td><%= customer.getName() %></td>
		<td><%= customer.getAddress() %></td>
		<td><%= customer.getPhone() %></td>
		<td>
			<a href="edit.do?id=<%= customer.getId()%>"> update</a>
			<a href="delete.do?id=<%= customer.getId() %>" class="delete"> delete</a>
		</td>
	</tr>

<% 		
	}}else{
		System.out.println("oh no");
	}
%>
</table>
</body>
</html>