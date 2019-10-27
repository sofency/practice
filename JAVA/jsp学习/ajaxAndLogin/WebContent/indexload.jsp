<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery.js"></script><!-- 引入ajax文件 -->
<script>
//load方法实现
	function confirmMoble(){
		var phone = $("#moblephone").val();
		$("#showerror").load("confirmServlet","moblephone="+phone);
	}
	
	//ajax实现
	function  register(){
		var phone = $("#moblephone").val();//获取号码
		$.ajax({
			url:"confirmServlet",
			method:"get",
			//"moblephone="+phone, 两种方式都可以
			data:{//json格式
				"moblephone":phone
			},
			success:function(result,testStatus){//成功之后拿到数据验证的结果
				alert(result);
				if(result=="true"){
					alert("已存在！注册成功");
				}else{
					alert("注册失败");
				}
			},
			error:function(xhr,errorMessage,e){
				alert("系统异常");
			}
		})
	}
	//get方法实现
	function confirmMobleGet(){
		var  phone = $("#moblephone").val();
		$.get(
			"confirmServlet", //服务器地址
			"moblephone="+phone,//传输的数据
			function(result){
				if(result=='true'){
					alert("成功");
				}else{
					alert("失败");
				}
			}
		);
	}
	
	function  confirmMobleJSON(){
		var  phone = $("#moblephone").val();
		alert(phone);
		$.getJSON(
			"confirmServlet", //服务器地址
			{
				"moblephone":phone
			},//传输的数据
			function(result){//返回的结果是json格式
				alert(result);
				if(result.msg=='true'){
					alert("成功");
				}else{
					alert("失败");
				}
			}
		);
		
	}
	
	function  confirmMoblePost(){
		var  phone = $("#moblephone").val();
		$.post(
			"confirmServlet", //服务器地址
			"moblephone="+phone,//传输的数据
			function(result){
				if(result=='true'){
					alert("成功");
				}else{
					alert("失败");
				}
			},"text"//期待服务端返回值类型
		);
	}
	
	function testJSON(){
		$.getJSON(
			"jsonServlet",
			{"name":"sofency","age":24},
			
			function(result){
				//js需要通过eval()函数将返回值转为一个js能够识别的json对象
				//var jsonObject =eval(result.stu1);//只能获取一个对象  获取之后结果就被销毁了
				//alert(jsonObject);
				//var jsonObject2 =eval(result.stu2);//只能获取一个对象
				//alert(jsonObject);
				var json= eval(result);//获取到后台传进来的json
				$.each(json,function(i,element){
					alert(this.name+"---"+this.age);
				})
			}
		)
	}
</script>
</head>
<body>
<input type="text" id="moblephone"/><br>
<input type="button" value="验证"   onclick="confirmMobleJSON()"><span id="showerror"></span><br>
<input  type="submit" onclick="testJSON()" value="测试json"/>

</body>
</html>