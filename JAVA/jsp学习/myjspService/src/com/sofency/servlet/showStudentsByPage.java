package com.sofency.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sofency.entries.Page;
import com.sofency.entries.student;
import com.sofency.service.studentServiceImpl;

/**
 * Servlet implementation class showStudentsByPage
 */
public class showStudentsByPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ҵ������
		//����  ��ǰ�˻�ȡ��Ҫ��תҳ�ķ����Լ�ҳ���С
		//Ȼ����������е��� �������ݿ���ȡ����
		//�������ض���ǰ�� ���н�������
		
		
	
		studentServiceImpl  s = new studentServiceImpl();
		int count = s.CountStudents();
		
		Page p = new Page();//����page���� �洢ǰ�˵�����
		p.setTotalCount(count);//��������Ϣ����		
		
		int pageSize = 3;//����ҳ��Ĵ�С
		p.setPageSize(pageSize);
		String cPage = request.getParameter("currentPage");
		if(cPage == null) {
			cPage="1";
		}
		int current = Integer.parseInt(cPage);//  ��ǰҳ��
		if(current<=1){
			current =1;
		}
		if(current>=p.getTotalPage()) {
			current=p.getTotalPage();
		}
		System.out.println(current);
		p.setCurrentPage(current);
		ArrayList<student> students = s.showStudentsByPage(current, pageSize);
		//��ǰ�˻�ȡ��ǰҳ
		p.setStudents(students);//����ѧ��
		request.setAttribute("pages", p);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
