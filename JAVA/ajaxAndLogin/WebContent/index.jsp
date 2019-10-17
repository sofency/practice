<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax实现异步验证</title>
</head>
<body>
<span>失去焦点验证输入号码的合法性</span><br>
<input type="text" id="moblephone" onblur="testOnblur()"/><span id="showerror"></span><br>
<span>点击验证向数据库中拿数据进行验证</span><br>
<input type="button" value="验证"   onclick="confirmMoble()">

<script>
	function testOnblur(){
		 var phone = document.getElementById("moblephone").value;
		 if(phone!=''){
		 		if(!(/^1[0-9]{10}$/.test(phone))){
					document.getElementById("showerror").innerHTML="号码格式不正确";
					document.getElementById("moblephone").value='';
		 	}
		 }
	}	
	function confirmMoble(){
		var phone= document.getElementById("moblephone").value;//获取号码值
		var xhr=new XMLHttpRequest();//创建连接
		
		//设置回调函数
		xhr.onreadystatechange=callback;
		xhr.open("post","confirmServlet",true);//建立连接
        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
		xhr.send("moblephone="+phone);
		
		function callback(){
			//数据成功的标志
			console.log(xhr.readyState);
			if(xhr.readyState==4&& xhr.status==200){
				var data = xhr.responseText;
				if(data=='true'){
					alert("号码成功");
				}else{
					alert("号码错误");
					document.getElementById("moblephone").value="";
				}
			}
		}
	}
	
</script>
</body>
</html>
