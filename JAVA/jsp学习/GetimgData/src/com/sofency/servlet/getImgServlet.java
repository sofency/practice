package com.sofency.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sofency.Dao.getImg;
import com.sofency.entry.img;

/**
 * Servlet implementation class getImgServlet
 */
public class getImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int  imgid = Integer.parseInt(request.getParameter("imgid"));
		
		System.out.println("imgid---"+imgid);
		img imgpic = getImg.getimgmsg(imgid);
		if(imgpic!=null) {
			String imgpath = imgpic.getImgurl();
			System.out.println("servlet---"+imgpath);
			request.setAttribute("imgpath", imgpath);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
