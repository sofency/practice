package com.sofency.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sofency.entries.student;
import com.sofency.service.studentServiceImpl;

/**
 * Servlet implementation class searchStudent
 */
public class searchStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String sno = request.getParameter("sno");//获取学号
		studentServiceImpl stum =new studentServiceImpl();
		student stu = stum.searchStu(sno);
		
		//传递给前端
		request.setAttribute("student", stu);
		request.getRequestDispatcher("changeStuInfo.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
