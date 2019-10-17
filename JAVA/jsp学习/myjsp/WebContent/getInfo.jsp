<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name =request.getParameter("uname");
	int age = Integer.parseInt(request.getParameter("uage"));
	String pwd = request.getParameter("upwd");
	String[] hobbies = request.getParameterValues("uhabbies");
%>
注册成功，信息如下
姓名:<%=name%><br>
年龄:<%=age%><br>
密码:<%=pwd%><br>
爱好:<br><%
for(String item:hobbies){
	out.print(item+"<br>");
}
%>
</body>
</html>