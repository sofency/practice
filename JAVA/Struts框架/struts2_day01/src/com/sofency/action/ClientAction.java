package com.sofency.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ͨ���ӿڷ�ʽ��ȡrequest����
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

	//ʹ��request�ӿ�ע��ķ�ʽ���л�ȡ������
	@Override
	public String execute() throws Exception {
		
		String uaccount = request.getParameter("uaccount");
		String upwd = request.getParameter("upwd");
		
		System.out.println(uaccount+"--"+upwd);
		return SUCCESS;
	}
	
	
}
