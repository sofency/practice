package com.sofency.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * Servlet implementation class downloadServlet
 */
public class downloadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取下载的文件名
		String  fileName= request.getParameter("fileName");
		System.out.println(fileName);
		//下载文件设置响应头
		response.addHeader("contentType", "application/octet-stream");//MIME类型  设置二进制文件
		
		String agent   = request.getHeader("User-Agent");
		if(agent.toLowerCase().contains("firefox")) {
			//火狐解决乱码问题
			response.addHeader("content-Dsiposition", "attachment;filename==?UTF-8?B?"+ new String( Base64.encode(fileName.getBytes("UTF-8")))+"?=");
		}else {
			//ie  和谷歌浏览器的处理中文乱码方案
			response.addHeader("content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8"));//解决中文乱码
		}
		
		//servlet通过文件的地址 将文件转为输入流 读到servlet中
		InputStream in = getServletContext().getResourceAsStream("/图片1.jpg");  
		
		//输出流送到用户界面
		ServletOutputStream out = response.getOutputStream();//获取输出流
		
		byte[] bs = new byte[1024];
		int len = -1;
		while((len=in.read(bs))!= -1) {
			out.write(bs,0,len);
		}
		
		out.close();
		in.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
