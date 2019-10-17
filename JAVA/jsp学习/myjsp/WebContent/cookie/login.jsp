<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
String uname;
String upwd;
Boolean flag=false;// 用来确定是否存储密码
%>
<%
Cookie[] cookies = request.getCookies();
for(Cookie item:cookies){
	if(item.getName().equals("uname")){
		uname = item.getValue();
	}else if(item.getName().equals("upwd")){
		upwd = item.getValue();
	}
	out.print(item.getName()+"---"+item.getValue()+"<br>");
}
if(uname!=null&&upwd!=null){
	if(uname.equals("sofency")&&upwd.equals("abc")){
		 out.print(uname+","+upwd);
		 response.sendRedirect("index.jsp");
	}else{
		uname=null;
		upwd=null;
	}
}
%>
<form action="check.jsp" method="get">
账户:<input type="text" placeholder="uname"   name="uname" value= "<%=uname==null ?"":uname%>"/><br>
密码:<input type="password"  name="upwd" value= "<%=upwd==null ?"":upwd%>"/>
<input type="submit" value="login" onclick="test()">

<script type="text/javascript">
function test(){
	flag = confirm("请问是否存储账户和密码，以便下次快速登录");
	console.log(flag);
}
</script>
</form>
</body>
</html>