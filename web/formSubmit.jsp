<%@page import="cn.edu.swu.formIssue.TokenProcessor"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		body{
			background:rgb(248,249,252);
		}
	</style>
</head>
<body>

	<%-- 
		String tokenValue = new Date().getTime() + "";
		session.setAttribute("token", tokenValue);
	--%>
	<div style="text-align:center; margin-top:60px">
	<h2> testing about preventing multiple submission</h2>
	<form action="<%= request.getContextPath() %>/tokenServlet" method="post">
		  
		<input type="hidden" name="COM.ATGUIGU.TOKEN_KEY" 
			value="<%= TokenProcessor.getInstance().saveToken(request) %>"/>
		
	   input something:<input type="text"  name="content"/>
			
		<input type="submit" value="please click wildly or tap it once"/>
	</form>
	<br/>
	<% Object msg2=session.getAttribute("msg2");
		if(msg2!=null){
		%>
		the submitted content:
		<% 
		out.print(msg2);
	}
		
	%>
	<br/>
	<% Object msg=session.getAttribute("msg");
		if(msg!=null){
			
			out.print(msg);
		}
	%>
	

	</div>
</body>
</html>
