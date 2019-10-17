package com.sofency.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sofency.entries.student;
import com.sofency.service.studentServiceImpl;

/**
 * Servlet implementation class dealStudent
 */
public class addStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nameString = request.getParameter("uname");
		String snoString = request.getParameter("sno");
		int age = Integer.parseInt(request.getParameter("sage"));
		
		student stu = new student(nameString,snoString,age);
		studentServiceImpl stuService = new studentServiceImpl();
		
		int flag = stuService.addstudent(stu);
		
		//需要将结果返回到前端
		/**
		 * 
		 * out  PrintWriter out = response.getWriter();
		 * session: resquest.getsession();
		 * application   request.getServletContext();
		 */
		//一定要在响应之前设置响应编码
		
		
//		response.setContentType("text/html;charset=UTF-8");
//		response.setCharacterEncoding("utf-8");
//		
//		PrintWriter out = response.getWriter();
//		
//		
		if(flag>0) {
			request.setAttribute("submitString", "success");
		}else if(flag == 0){
			request.setAttribute("submitString", "nosuccess");
		}
		//请求转发模式
		request.getRequestDispatcher("showStudentsByPage").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
