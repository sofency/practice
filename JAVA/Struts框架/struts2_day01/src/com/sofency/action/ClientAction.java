package com.sofency.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 通过接口方式获取request对象
 * @author sofency
 *
 */
public class ClientAction extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request= request;
	}

	//使用request接口注入的方式进行获取表单数据
	@Override
	public String execute() throws Exception {
		
		String uaccount = request.getParameter("uaccount");
		String upwd = request.getParameter("upwd");
		
		System.out.println(uaccount+"--"+upwd);
		return SUCCESS;
	}
	
	
}
