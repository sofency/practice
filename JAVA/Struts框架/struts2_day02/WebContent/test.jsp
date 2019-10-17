<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 使用%和#获取context属性域里面的值 -->
<s:debug></s:debug>
<s:property value="#request.uname"/><!-- 从不同的对象中取值eg session -->
<h1>在struts2标签里面使用ognl表达式</h1>
<s:textfield name="username" value="%{#request.uname}"/>
<s:property value="GirlObject"></s:property>

<s:property value="uname"></s:property><!-- 不是在标签里面的值不需要写符号 直接写action里面的属性名字 -->
<s:property value="[0].top"/><!-- 不用使用# 从值栈李敏取值     -->

<s:property  value="user.userName"/>
</body>
</html>