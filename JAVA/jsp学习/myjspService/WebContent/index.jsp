<%@page import="com.sofency.entries.student"%>
<%@page import="com.sofency.entries.Page"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	margin :0;
	padding:0;
}
.container{
    margin:20px auto;
	width:400px;
	height:600px;
	background-color:#ccc;
	border:1px solid #008c8c;
	border-radius:10px;
	padding:20px;
	box-sizing:border-box;
}
.container .add{
	width:360px;
	height:200px;
	margin-bottom:30px;
}
h2{
    margin:auto;
    text-align:center;
    width:150px;
    background-color:green;
    height:35px;
    line-hight:35px;
    border-radius:10px;
    margin-bottom:10px;
}
#name,#sno,#age{
	font-size:20px;
	font-weight:400;
	font-family:"仿宋";
	margin-left:40px;
}
input[type="text"]{
	height:20px;
	vertical-align:middle;
	width:200px;
	margin:2px 0px;
}
.container .add #submit{
    border:none;
    background-color:red;
    display:inline-block;
	width:80px;
	height:30px;
	margin-top:10px;
	margin-left:140px;
	border-radius:10px;
}
.container .allStu{
	height:250px;
}
table{
	margin-left:40px;
	border:1px solid #008c8c;
}
table tr{
	height:25px;
	border:1px solid #008c8c;
}
table tr td{
    width:65px;
    border:1px solid #008c8c;
}
.prompt{
    display:inline-block;
	text-align:center;
	width:90px;
	height:25px;
	background-color:red;
	margin:2px 135px;
	border-radius:10px;
	line-height:25px;
	font-size:15px;
}
ul{
    text-align:center;
}
ul li{
 display:inline-block;
 list-style:none;
 height:20px;
 width:60px;
 margin-right:4px;
 border:1px  solid #fff; 
 background-color:#95a5a6;
 line-height:20px;
 cursor:pointer;
 border-radius:10px;
}
a{
 text-decoration:none;
}
.container .showPageInfo{
    width:278px;
	height:26px;
	box-sizeing:border-box;
	margin-bottom:5px;
	margin-left:40px;
}
.common{
  width:110px;
  height:20px;
  margin:0 0 4px 0px; 
  border:1px solid #ecf0f1;
  border-radius:10px;
  font-size:10px;
}
.container .showPageInfo .left{
	float:left;
	padding-left:5px;
}
.container .showPageInfo .right{
    width:70px;
    text-align:right;
	float:right;
	padding-right:5px;
}
</style>
</head>
<body>
<!-- 视图层 -->
<div class="container">
	<div class="add">
		<h2>添加学生</h2>
		<form action="addStudent">
			<label for="uname" id="name">姓名：</label><input type="text"  id="uname" name="uname" placeholder="uname"/><br>
			<label for="usno" id="sno">学号：</label><input type="text" id="usno" name="sno"  placeholder="sno"/><br>
			<label for="uage" id="age">年龄：</label><input type="text" id="uage" name="sage" placeholder="sage"><br>
			<input  type="submit"  value="提交" id="submit">
		</form>
		<%
			String submitString = (String)request.getAttribute("submitString");
			if(submitString!=null){
				if(submitString.equals("success")){
					out.print("<span class='prompt'>添加成功</span>");
				}else if(submitString.equals("nosuccess")){
					out.print("<span class='prompt'>添加失败</span>");
				}
			}
		%>
	</div>
	<div class="allStu">
		<h2>所有学生</h2>
		<!-- 展示页面信息的数目 -->
		<%   
		    Page p = (Page)request.getAttribute("pages");
		%>
		<div class="showPageInfo">
			<span class="left common">current/total: <%=p.getCurrentPage() %>/<%=p.getTotalPage() %></span>
			<span class="right common">records: <%=p.getTotalCount() %></span>
		</div>
		<table>
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>操作</td>
			</tr>
			<%
			    for(student stu : p.getStudents()){
			%>
					<tr>
						<td><a href="searchStudent?sno=<%=stu.getSnoString() %>"><%=stu.getSnoString() %></a></td>
						<td><%=stu.getNameString()%></td>
						<td><%=stu.getAge()%></td>
						<td><a href="deleteStu?sno=<%=stu.getSnoString()%>">删除</a></td>
					</tr>
			<% 
			   }
		    %>
		</table>
		<%
			String error = (String)request.getAttribute("decide");
			if(error!=null){
				if(error.equals("success")){
					out.print("<span class='prompt'>删除成功</span>");
				}else if(error.equals("nosuccess")){
					out.print("<span class='prompt'>删除失败</span>");
				}
			}
		%>
	</div>
	
	<!-- 实现分页功能 -->
	<div class="morePage">
		<ul>
			    <li><a href="showStudentsByPage?currentPage=<%=1 %>">首页</a></li>
				<li><a href="showStudentsByPage?currentPage=<%=p.getCurrentPage()-1%>">上一页</a></li>
				<li><a href="showStudentsByPage?currentPage=<%=p.getCurrentPage()+1%>">下一页</a></li>
				<li><a href="showStudentsByPage?currentPage=<%=p.getTotalPage()%>">尾页</a></li>
			
	   </ul>
	</div>
</div>
</body>
</html>