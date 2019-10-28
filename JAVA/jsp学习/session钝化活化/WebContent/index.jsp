<%@page import="com.sofency.BeanListener.BeanListenerDemo"%>
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
		BeanListenerDemo bean = new BeanListenerDemo("sofency","19980120");
		session.setAttribute("bean", bean);//绑定自己
	%>
</body>
</html>