<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>遍历list集合的方法</h1>
<s:property value="list[0].userName"/>
<s:property value="list[0].userAge"/>

<s:iterator value="list" var="user"> 
<s:property value="#user.userName"/>
<s:property value="#user.userAge"/>
</s:iterator>
</body>
</html>