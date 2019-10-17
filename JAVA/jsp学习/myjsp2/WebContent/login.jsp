<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.container{
	   position:fixed;
	   top:0;
	   bottom:0;
	   left:0;
	   right:0;
	   margin: auto;
	   width:600px;
	   height:400px;
	   border:1px solid #ccc;
	   padding:20px;
	   background-color:#dfe6e9;
	}
	form{
		width:360px;
		height:240px;
		margin:80px auto;
		border:1px solid #ccc;
		box-sizing:border-box;
	}
	#unameContent,#upwdContent{
	    display:inline-block;
	    padding-top:20px;
	    font-size:18px;
	    width:80px;
	    height:40px;
	    line-height:40px;
	    text-align:center;
	}
	#uname,#pwd{
	    border:1px  solid #ccc;
	    border-radius:5px;
	    height: 30px;
	    width:250px;
	    text-indent:10px;
	    opcity:0.7;
	    background-color:white;
	}
	.submit{
		display:inline-block;
		background-color:#2c3e50;
		color:white;
		border:none;
		border-radius:10px;
		width:200px;
		height:30px;
		text-align:center;
		margin:10px 79px;
	}
</style>
</head>
<body>
<div class="container">
	<form action="loginCheck.jsp" method="post">
		<label for="uname" id="unameContent">用户名:</label><input type="text" id="uname" name="uname" placeholder="uname"/><br>
		<label for="pwd" id="upwdContent">密&nbsp;&nbsp;码:</label><input type="password" name="upwd" id="pwd" /><br>
		<input type="submit" value="提交"  class="submit"/>
	</form>
</div>
</body>
</html>