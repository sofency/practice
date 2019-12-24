<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询商品列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Item/queryItem.action" method="post">
	<table width="100%" border=1>
		<tr>
			<td><input type="submit" value="查询"/></td>
		</tr>
	</table>
商品列表
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemList}" var="Item">
	<tr>
		<td>${Item.itemname}</td>
		<td>${Item.itemprice}</td>
		<td><a href="${pageContext.request.contextPath}/Item/editItem.action?id=${Item.itemid}">修改</a></td>
	</tr>
</c:forEach>
</table>
</form>
</body>
</html>