package com.sofency.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class confirmServlet
 */
public class confirmServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//����ǰ�˴���������
		request.setCharacterEncoding("utf-8");//��������ı���
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");//��Ӧ�ı���
		
		//��ȡ�绰����
		String  number = request.getParameter("moblephone");
		//��ʼƥ��
		PrintWriter out=response.getWriter();
		if("13462583774".equals(number)) {
			//����json�����󷵻�Ҫ����json���͵�����
			out.write("{\"msg\":\"true\"}");
			//out.print("true");
		}else {
			//out.print("false");
			out.print("{\"msg\":\"false\"}");//json ��ʽ��������Ҫ������������
		}
		out.flush();
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
