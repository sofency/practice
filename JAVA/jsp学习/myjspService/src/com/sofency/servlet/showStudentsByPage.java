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
		//处理业务需求
		//分析  从前端获取需要跳转页的方向以及页面大小
		//然后控制器进行调度 操作数据库拿取数据
		//将数据重定向到前端 进行解析数据
		
		
	
		studentServiceImpl  s = new studentServiceImpl();
		int count = s.CountStudents();
		
		Page p = new Page();//设置page对象 存储前端的数据
		p.setTotalCount(count);//设置总信息数；		
		
		int pageSize = 3;//设置页面的大小
		p.setPageSize(pageSize);
		String cPage = request.getParameter("currentPage");
		if(cPage == null) {
			cPage="1";
		}
		int current = Integer.parseInt(cPage);//  当前页数
		if(current<=1){
			current =1;
		}
		if(current>=p.getTotalPage()) {
			current=p.getTotalPage();
		}
		System.out.println(current);
		p.setCurrentPage(current);
		ArrayList<student> students = s.showStudentsByPage(current, pageSize);
		//从前端获取当前页
		p.setStudents(students);//设置学生
		request.setAttribute("pages", p);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
