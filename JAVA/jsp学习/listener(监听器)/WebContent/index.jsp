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
	application.setAttribute("uname", "sofency");//监听器会监听属性的变化
	session.setAttribute("password", "1998-0120");
	request.setAttribute("subject", "物理");
	request.removeAttribute("subject");
	session.setAttribute("password", "1998");
%>>
</body>
</html>