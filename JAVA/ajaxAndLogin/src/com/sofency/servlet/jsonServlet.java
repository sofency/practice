package com.sofency.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sofency.entities.student;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class jsonServlet
 */
public class jsonServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//���ñ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//����ǰ�˴�����������
		String name = request.getParameter("name");
		int age =Integer.parseInt(request.getParameter("age"));
		
		System.out.println(name+"---"+age);
		
		PrintWriter out = response.getWriter();
		student stu1=new student("sofency",18);
		student stu2=new student("alice",19);
		student stu3=new student("sophia",20);
		
		JSONObject json = new JSONObject();
		json.put("stu1", stu1);
		json.put("stu2", stu2);//��json����Ž�json����
		json.put("stu3", stu3);
		
		out.print(json);//��json�Ž�ȥ  ��Ϊprint����������Դ��ݶ���  ��writer���ܴ�����
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
