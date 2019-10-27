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
		// ��ȡ���ص��ļ���
		String  fileName= request.getParameter("fileName");
		System.out.println(fileName);
		//�����ļ�������Ӧͷ
		response.addHeader("contentType", "application/octet-stream");//MIME����  ���ö������ļ�
		
		String agent   = request.getHeader("User-Agent");
		if(agent.toLowerCase().contains("firefox")) {
			//��������������
			response.addHeader("content-Dsiposition", "attachment;filename==?UTF-8?B?"+ new String( Base64.encode(fileName.getBytes("UTF-8")))+"?=");
		}else {
			//ie  �͹ȸ�������Ĵ����������뷽��
			response.addHeader("content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8"));//�����������
		}
		
		//servletͨ���ļ��ĵ�ַ ���ļ�תΪ������ ����servlet��
		InputStream in = getServletContext().getResourceAsStream("/ͼƬ1.jpg");  
		
		//������͵��û�����
		ServletOutputStream out = response.getOutputStream();//��ȡ�����
		
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
