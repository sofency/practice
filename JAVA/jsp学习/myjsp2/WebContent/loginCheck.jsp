<%@page import="myjsp2.loginDao"%>
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
	String uname = request.getParameter("uname");
	String upwd = request.getParameter("upwd");
	loginDao login = new loginDao();
	boolean flag = login.login(uname, upwd);

	if(flag){
		session.setAttribute("uname", uname);//不要登记密码
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}else{
		response.sendRedirect("login.jsp");
	}
%>
</body>
</html>