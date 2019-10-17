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
//会话取消 即其中所有的属性都取消了
session.invalidate();
//session.removeAttribute("sofency");
//重定向到页面login
response.sendRedirect("login.jsp");
%>
</body>
</html>