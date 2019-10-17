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
		
		//接收前端传进的数据
		request.setCharacterEncoding("utf-8");//设置请求的编码
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");//响应的编码
		
		//获取电话号码
		String  number = request.getParameter("moblephone");
		//开始匹配
		PrintWriter out=response.getWriter();
		if("13462583774".equals(number)) {
			//对于json的请求返回要返回json类型的数据
			out.write("{\"msg\":\"true\"}");
			//out.print("true");
		}else {
			//out.print("false");
			out.print("{\"msg\":\"false\"}");//json 格式的数据需要用括号括起来
		}
		out.flush();
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
