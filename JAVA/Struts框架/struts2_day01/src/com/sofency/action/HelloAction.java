package com.sofency.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	
	/*
	 * 1. 每次访问servlet时候，都会执行service方法
	 *   步骤 1.写类继承HttpServlet重写里面的doGet和doPost方法
	 *        2.部署xml 配置servlet访问路径
	 *        
	 * 2. 访问action 每次访问action时候，默认执行名称excute方法  action(增删改查)
	 * 
	 * 3.配置action的执行路径
	 *    a.创建struts2核心配置文件
	 *      核心配置文件名称和位置是固定的
	 *      位置必须在src 下面  名称为struts.xml
	 * 
	 * 
	 * */
	
	public String execute() {
		System.out.println("action..");
		return "ok";
	}
	
	public String delete() {
		System.out.println("delete.....");
		return NONE;//不用配置响应的result
	}
	public String add() {
		System.out.println("add.....");
		return NONE;//不用配置响应的result
	}
	public String update() {
		System.out.println("update.....");
		return NONE;//不用配置响应的result
	}
}
