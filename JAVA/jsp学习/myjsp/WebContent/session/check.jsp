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
// 处理客户端的请求信息
request.setCharacterEncoding("utf-8");
//获取属性值
String name = request.getParameter("uname");
String pwd = request.getParameter("upwd");
System.out.println(request.getProtocol()+"--"+request.getScheme()+"--"+request.getServerName()+"--"+request.getServerPort());
//HTTP/1.1  
//协议类型和版本号   --请求用的计划名  --  服务器主机名 -- 服务器端口号
System.out.println(request.getRemoteAddr()+"--"+request.getRemoteHost());
// 返回此请求客户端的客户端”IP“ 和主机名  
//登录验证
if(name.equals("sofency")&&pwd.equals("abc")){
	//建立会话
	session.setAttribute("uname", name);
	session.setAttribute("upwd", pwd);
	//同一浏览器session是共享的
	//session.setMaxInactiveInterval(10);//设置10秒
	//请求转发
	request.getRequestDispatcher("welcome.jsp").forward(request,response);
}else{
	//登陆失败
	response.sendRedirect("login.jsp");
}
%>
</body>
</html>