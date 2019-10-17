package com.sofency.Servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet{
	
	/**
	 * ���Խ���eclipse ����servlet���ٽ�������servlet�Լ�xml
	 * Servlet3.0֮��İ汾����ͨ��ע����в��Ҷ�Ӧ�������ִ��
	 * "@webScoket("/login")"<-----  ǰ��ͨ��ע����в���
	 * 
	 * ������tomcatʱ���г�ʼ����������  ���ò���
	 * @webScoket(value="/login",loadOnStartup =1,initParams={@webInitParam(name="servletName",value="servletValue")});
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Override
	public void init() throws ServletException {
		String value = super.getInitParameter("servletName");
		System.out.println("��ǰ��servlet�Ĳ���ֵ��"+value);
		
		
		//��ȡȫ�������Ĳ���ֵ
		
		ServletContext servletContext = super.getServletContext();
		String valueString = servletContext.getInitParameter("globalName");
		System.out.println("ȫ��������ֵ��"+valueString);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// һ��Ĵ���ʽ���Ƿ���doPost�������
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoPost...");
		//���ձ��ύ�����ݲ��Ҵ���
		
	}
}
