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
	${sessionScope.bean.name}
	${sessionScope.bean.sex}
</body>
</html>