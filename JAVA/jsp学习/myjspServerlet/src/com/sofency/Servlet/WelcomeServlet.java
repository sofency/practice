package com.sofency.Servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet{
	
	/**
	 * 可以借助eclipse 创建servlet快速进行生成servlet以及xml
	 * Servlet3.0之后的版本可以通过注解进行查找对应的类进行执行
	 * "@webScoket("/login")"<-----  前端通过注解进行查找
	 * 
	 * 在启动tomcat时进行初始化操作做法  设置参数
	 * @webScoket(value="/login",loadOnStartup =1,initParams={@webInitParam(name="servletName",value="servletValue")});
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Override
	public void init() throws ServletException {
		String value = super.getInitParameter("servletName");
		System.out.println("当前的servlet的参数值是"+value);
		
		
		//获取全局容器的参数值
		
		ServletContext servletContext = super.getServletContext();
		String valueString = servletContext.getInitParameter("globalName");
		System.out.println("全局容器的值是"+valueString);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 一般的处理方式都是放在doPost里面进行
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoPost...");
		//接收表单提交的数据并且处理
		
	}
}
