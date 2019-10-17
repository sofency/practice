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
String imgpath  = request.getContextPath()+"/image/"+request.getAttribute("imgpath");
System.out.print(imgpath);
%>
<a href="getImgServlet?imgid=<%=1 %>">获取图片</a><br>
选择图标<input type="file" /><br>
<img src=<%=imgpath %> alt="好看的图片" style="width:40px;height:40px"/>
</body>
</html>