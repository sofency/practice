package com.sofency.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sofency.service.studentServiceImpl;

/**
 * Servlet implementation class deleteStu
 */
public class deleteStu extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String sno = request.getParameter("sno");
		
		studentServiceImpl stuService= new studentServiceImpl();
		
		int count = stuService.deleteStu(sno);
		if(count>0) {
			request.setAttribute("decide", "success");
		}else if(count == 0){
			request.setAttribute("decide","nosuccess");
		}
		request.getRequestDispatcher("showStudentsByPage").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
