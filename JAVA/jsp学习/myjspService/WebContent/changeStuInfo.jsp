<%@page import="com.sofency.entries.student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChangeStuInfo Page</title>
<style type="text/css">
*{
	margin:0;
	padding:0;
}
.container{
	width:260px;
	height:300px;
	margin:10px auto;
	border:1px solid #ccc;
	background-color:#7f8fa6;
	position:relative;
}

form{
	width:244px;
	margin:10px auto;
	text-align:center;
}
input[type="text"]{
	height:25px;
	margin-top:5px;
}
.common{
    border:none;
    background-color:#00a8ff;
	display:inline-block;
    width:80px;
    height:30px;
    font-size:15px;
    color:black;
    border-radius:15px;
}
input[type="submit"]{
	position:absolute;
	bottom:10px;
    left:40px;
}
a{
    position:absolute;
	bottom:10px;
    right:40px;
    text-decoration:none;
}
span{
	line-height:30px;
}
</style>
</head>
<body>
<% //传输学生信息
	student stu = (student)request.getAttribute("student");
%>
<div class="container">
	<form action="changeStudent">
		学号：<input type="text" name="sno" value="<%=stu.getSnoString() %>"  readonly="readonly"/><br>
		姓名：<input type="text" name="sname" value="<%=stu.getNameString()%>"/><br>
		年龄：<input type="text" name="sage" value="<%=stu.getAge() %>"/><br>
		<input type="submit" class="common" value="修改" />  <a href="showStudentsByPage" class="common"><span>返回</span></a> 
	</form>
</div>
</body>
</html>