<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="upAndDown" method="post" enctype="multipart/form-data">
学号：<input type="text" name ="sno"><br/>
姓名：<input type="text" name="Sname" /><br/>
上传文件<input type="file"  name="spicture" /><br/>
<input type="submit" value="提交">
</form>
<a href="downloadServlet?fileName=图片1.jpg">download</a>
<img src="<%= %>"/>
</body>
</html>