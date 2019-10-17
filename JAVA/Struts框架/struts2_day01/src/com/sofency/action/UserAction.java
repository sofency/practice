package com.sofency.action;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 实现action接口
 * @author sofency
 *
 */

public class UserAction extends ActionSupport{
	
	public String register(){
		//写注册的逻辑  服务层 Dao层 
		System.out.println("register");
		return SUCCESS;//接口中的常量
	}
	
	public String login(){		
		//第一种方式使用ActionContext进行获取所有的参数 存储到map中进行遍历读取
//		//1.使用ActionContext类获取
//		ActionContext context = ActionContext.getContext();
//		//2. 调用方法获取表单数据
//		// key表示的表单的name属性  value 表示表单输入的值
//		Map<String,Object> map = context.getParameters();
//		
//		Set<String> set = map.keySet();//底层就是map形式的
//		
//		for(String key:set) {
//			Object[] obj = (Object[])map.get(key);//多选框时会用到
//			System.out.println(Arrays.toString(obj));
//		}
		//第二种方式  使用servletActionContext进行获取servlet的请求  按照类似于servlet获取表单的方式进行获取数据
		//ServletActionContext  里面的方法  操作域对象 request(一次请求)  session(一次会话)  ServletContext(作用范围  服务器启动关闭)
	
		HttpServletRequest request = ServletActionContext.getRequest();//底层会处理表单为中文的问题  转码操作
		String uaccount = request.getParameter("uaccount");
		String upwd = request.getParameter("upwd");
		System.out.println(uaccount+"--"+upwd);
		
		//操作session 域
		HttpSession session = request.getSession();//获取session对象进行操作
		//session.setAttribute(name, value);
		//业务逻辑
		System.out.println("login");
		return SUCCESS;//接口中的常量
	}
}
