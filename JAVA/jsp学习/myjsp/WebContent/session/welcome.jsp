<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎你：
<%
//根据属性获取会话中的值
String name = (String)session.getAttribute("uname");
if(name!=null){
	out.print(name);
%>
<a href="invalidate.jsp">注销</a>
<%
	}else{
		response.sendRedirect("login.jsp");
	}
%>
</body>
</html>