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
String name = request.getParameter("uname");
String pwd = request.getParameter("upwd");
//设置Cookie 存储数据
if(name.equals("sofency")&&pwd.equals("abc")){
	// 如果登录成功记住密码
	Cookie uname_cookie = new Cookie("uname",name);
	response.addCookie(uname_cookie);
	Cookie upwd_cookie = new Cookie("upwd",pwd);
	response.addCookie(upwd_cookie);
	// 重定向位置将cookie发给客户端
	response.sendRedirect("index.jsp");
	
}else{
	//返回出错的界面
	response.sendRedirect("login.jsp");
}
%>
</body>
</html>