package com.sofency.servlet;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sofency.entries.student;
import com.sofency.service.studentServiceImpl;

/**
 * Servlet implementation class showAllStudent
 */
public class changeStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sname=request.getParameter("sname");
		String sno=request.getParameter("sno");
		int sage=Integer.parseInt(request.getParameter("sage"));
		
		//对象封装
		student stu=new student(sname,sno,sage);
		
 		studentServiceImpl stuService = new studentServiceImpl();
		int count = stuService.changeStu(stu);//更新的标志
		
		//当请求有数据时  要使用请求转发  重定向会丢失数据
		request.setAttribute("change", count);//用来判断是否跟新完毕的
		request.setAttribute("sno", sno);
		request.getRequestDispatcher("searchStudent").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
