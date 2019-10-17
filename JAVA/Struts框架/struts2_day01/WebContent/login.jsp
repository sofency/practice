<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 封装数据到list 中 -->
<form action="${pageContext.request.contextPath}/loginBy.action" method="post">
	用户:<input type="text" name="list[0].uaccount" /><br><!-- map["one"].uaccount -->
	密码：<input type="password" name="list[0].upwd" ><br><!-- map["one"].upwd -->
	
	用户:<input type="text" name="list[1].uaccount"  /><br><!-- map["two"].uaccount -->
	密码：<input type="password" name="list[1].upwd" ><br><!-- map["two"].upwd -->
	<input type="submit" value="提交">
</form>
</body>
</html>