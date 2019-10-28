<%@page import="com.sofency.BeanListener2.Beandemo2"%>
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
	//测试钝化和活化
	Beandemo2 bean = new  Beandemo2("alice","女");
	session.setAttribute("bean", bean);
	%>
</body>
</html>