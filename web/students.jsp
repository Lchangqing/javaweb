<%@page import="cn.edu.swu.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
		body{
			background-image: url(Wopop_files/login_bgx.gif);
			}
			#box2{
				width:400px;
				margin:60px auto;
				border: 3px solid black;	
			}
			.box3 {
				margin:10px auto;
				text-align:center;
			}
			table {
				width:400px;
				margin:60px auto;
				/*
				 * table和td边框之间默认有一个距离
				 * 	通过border-spacing属性可以设置这个距离
				 */  
				 border-spacing: 0px;
				 /*
				  * border-collapse可以用来设置表格的边框合并
				  * 	如果设置了边框合并，则border-spacing自动失效
				  */
				 border-collapse: collapse;
							}
							
			#table1 td{
				border: 3px solid black;
			}
			#table1 th{
				border: 3px solid black;
			}
			#table1 tr:nth-child(even){
				background-color:#EEE8AA;
			}
			#table1 tr:hover{
				background-color:#DEB887;
			}
		</style>
		
		<script type="text/javascript">
			function forA(){
				var flag=false;
				var tr=this.parentNode.parentNode;
				if(confirm("确认删除？")) {
					flag=true;
					return flag;
				}
				return flag;
			}
			window.onload=function(){
			var all=document.getElementsByTagName("a");
			for(var i=0;i<all.length;i++){
				all[i].onclick=forA;
			}
			
			}
			
		</script>
</head>
<body>
<%
	List<Student> stus=(List<Student>)request.getAttribute("students");
%>
<table id="table1">
 	<tr>
		<th>学号</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>删除该条记录</th>
	</tr> 
	<%
		if(stus==null){
			System.out.println("空");
		}else{
		for(Student student: stus){
	%>
	<tr>
		<td><%= student.getId() %></td>
		<td><%= student.getStudentName() %></td>
		<td><%= student.getAge() %></td>
		<td><a href="${pageContext.request.contextPath}/deletrecord?studentid=<%= student.getId()
		%>">删除该条记录</a></td>
	</tr> 
	<%
	}}
	%>
</table>

<div id="box2">
        <form action="submit" method="POST">
				<div class="box3"><h4>新添</h4></div>
				<div class="box3">学号（int）:<input type="text" name="id" /></div>
				<div class="box3">姓名(string):<input type="text" name="name"/></div>
				<div class="box3">年龄（int）:<input type="text" name="age"/></div>
				<div class="box3"><input type="submit" value="提交"/></div>
		</form>
		</div>
</body>
</html>