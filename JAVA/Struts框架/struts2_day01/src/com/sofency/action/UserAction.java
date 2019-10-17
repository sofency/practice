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
 * ʵ��action�ӿ�
 * @author sofency
 *
 */

public class UserAction extends ActionSupport{
	
	public String register(){
		//дע����߼�  ����� Dao�� 
		System.out.println("register");
		return SUCCESS;//�ӿ��еĳ���
	}
	
	public String login(){		
		//��һ�ַ�ʽʹ��ActionContext���л�ȡ���еĲ��� �洢��map�н��б�����ȡ
//		//1.ʹ��ActionContext���ȡ
//		ActionContext context = ActionContext.getContext();
//		//2. ���÷�����ȡ������
//		// key��ʾ�ı���name����  value ��ʾ�������ֵ
//		Map<String,Object> map = context.getParameters();
//		
//		Set<String> set = map.keySet();//�ײ����map��ʽ��
//		
//		for(String key:set) {
//			Object[] obj = (Object[])map.get(key);//��ѡ��ʱ���õ�
//			System.out.println(Arrays.toString(obj));
//		}
		//�ڶ��ַ�ʽ  ʹ��servletActionContext���л�ȡservlet������  ����������servlet��ȡ���ķ�ʽ���л�ȡ����
		//ServletActionContext  ����ķ���  ��������� request(һ������)  session(һ�λỰ)  ServletContext(���÷�Χ  �����������ر�)
	
		HttpServletRequest request = ServletActionContext.getRequest();//�ײ�ᴦ���Ϊ���ĵ�����  ת�����
		String uaccount = request.getParameter("uaccount");
		String upwd = request.getParameter("upwd");
		System.out.println(uaccount+"--"+upwd);
		
		//����session ��
		HttpSession session = request.getSession();//��ȡsession������в���
		//session.setAttribute(name, value);
		//ҵ���߼�
		System.out.println("login");
		return SUCCESS;//�ӿ��еĳ���
	}
}
