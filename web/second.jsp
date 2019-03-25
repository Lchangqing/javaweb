<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript">
			/*
			 * onload事件会在整个页面加载完成之后才触发
			 * 为window绑定一个onload事件
			 * 		该时间对应的相应函数将会在页面加载完成之后才执行
			 * 		这样可以确保我们的代码执行时所有的DOM对象已经加载完毕了
			 */
			function myclick(str,fun){
				var btn=document.getElementById(str);
				btn.onclick=fun;
			}
			window.onload=function(){
				
				var class1=document.getElementById("class1");
				var count=1;
				myclick("b1",function(){
					/*
					 * 如果需要读取元素节点的属性，
					 * 		直接使用 元素名.属性名
					 * 			例如：元素.id  元素.name 元素.value
					 * 		注意：class属性不能采用这种方式，读取class需要使用 元素.className
					 */
					count--;
					if(count<1){
						count=5;
					}
					class1.style.backgroundImage="url(img/"+count+".jpg)";
				});
				myclick("b2",function(){
					count++;
					if(count>5){
						count=1;
					}
					class1.style.backgroundImage="url(img/"+count+".jpg)";
				});
				myclick("class3",function(){
				count--;
					if(count<1){
						count=5;
					}
					class1.style.backgroundImage="url(img/"+count+".jpg)";
			});
				myclick("class4",function(){
					count++;
					if(count>5){
						count=1;
					}
					class1.style.backgroundImage="url(img/"+count+".jpg)";
				});
				
			}
			
		</script>
		<style type="text/css">
			#class1{
				width: 720px;
				height: 405px;
				border: burlywood solid 0.5px;
				margin: 100px auto  10px;
				background-image: url(img/1.jpg);
			}
			#class3{
				width: 240px;
				height: 405px;	
				display: inline-block;			
			}
			#class3:hover{			}
			#class4{
				width: 240px;
				height: 405px;
				display: inline-block;			
			}
			#class4:hover{			}
			#class5{
				width: 240px;
				height: 405px;
				display: inline-block;	
			}
			
			.class2{
				margin: 0 auto;
				width: 200px;
			}
		</style>
	</head>
	<body>
		<div id="class1">
			<a href="#" id="class3"></a><div id="class5"></div><a href="#" id="class4"></a>
		</div>
		<div class="class2">
			<button type="button" id="b1">上一张</button>
			<button type="button" id="b2">下一张</button>
		</div>
	</body>
</html>

