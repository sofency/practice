package com.sofency.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	
	/*
	 * 1. ÿ�η���servletʱ�򣬶���ִ��service����
	 *   ���� 1.д��̳�HttpServlet��д�����doGet��doPost����
	 *        2.����xml ����servlet����·��
	 *        
	 * 2. ����action ÿ�η���actionʱ��Ĭ��ִ������excute����  action(��ɾ�Ĳ�)
	 * 
	 * 3.����action��ִ��·��
	 *    a.����struts2���������ļ�
	 *      ���������ļ����ƺ�λ���ǹ̶���
	 *      λ�ñ�����src ����  ����Ϊstruts.xml
	 * 
	 * 
	 * */
	
	public String execute() {
		System.out.println("action..");
		return "ok";
	}
	
	public String delete() {
		System.out.println("delete.....");
		return NONE;//����������Ӧ��result
	}
	public String add() {
		System.out.println("add.....");
		return NONE;//����������Ӧ��result
	}
	public String update() {
		System.out.println("update.....");
		return NONE;//����������Ӧ��result
	}
}
