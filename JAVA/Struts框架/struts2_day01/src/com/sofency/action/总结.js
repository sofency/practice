setInterval(function(){
	var test = document.querySelector(".tb-btn-buy .J_LinkBuy");
	var price = document.querySelector(".tb-promo-price .tb-rmb-num");
	var price_num = price.innerHTML;
	var content = test.innerHTML;
	if("立即购买" == content && price_num == 10.10){
		test.click();
	}
},1000);

setTimeout(function(){
	if(test=="sofency"&& password=="19980120"){
		alert("登陆成功");
	}
},2000);

struts2的正确使用姿势
对于前端来说
在没有框架的年代，我们前段表单的数据要传送到后端,点击提交后数据以键值对的形式传递到后端的servlet后端再通过request.getParameter("name")方法获取值。
通常我们会将一个表单中的数据封装成一个对象存储在一个javabean中。

我们所要做的工作如下
1. 写表单 写响应的javabean
2. 配置action到的servlet
3. 在xml中配置相应的servlet
4. 在servlet中接受数据  这就是web层没有框架时所要做的工作

但是随着前端表单的数据越来越多。我们在servlet中所要获取的数据就越来越多即 Request.getParameter("name")就越来越多  会变得很臃肿
struts2就优化了没有框架时所带来的的不足 在struts.xml配置响应的action 我们可以直接将数据存储到响应的javabean中
1.struts.xml中的默认配置如下
1.引入struts的约束
<struts>
	<package name="专属的名字" extends = "struts-default" namespaces="/">
		<action name="urlaction" class="action类的位置" method="使用的方法">
			<result name="返回的值" type="dispatcher">到的界面</result>
			<!--默认值是请求转发的方式-->
			type="redirect" 是重定向的意思
		</action>
	</package>

</struts>
