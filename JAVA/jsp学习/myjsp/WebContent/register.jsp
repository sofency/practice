<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- language 是指定的脚本语言  import 导入类       pageEncoding :jsp指定的编码 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- !全部声明变量 嵌入java代码 -->
<form action="getInfo.jsp" method="post">
	姓名：<input type="text" name="uname"><br>
	年龄：<input type="text" name="uage"><br>
	密码：<input type="password" name="upwd"><br>
	爱好：<br>
	<input type="checkbox" name="uhabbies" value="篮球">篮球
	<input type="checkbox" name="uhabbies" value="足球">足球
	<input type="checkbox" name="uhabbies" value="乒乓球">乒乓球<br>
	<input type="submit" value="提交">
</form>
<!--  <%!
	public String bookName;
	public  void init(){
		bookName = "java书";
	}
%>
hello index1 你好<br/>
<% 
	String name ="sofency";
//System.out会输出到控制台 直接写out会输出到界面
	out.print(name);//ln不会回车
    out.print("<br>");// 写html的代码
	init();
%>
<%="hello.."+bookName %>-->
</body>
</html>