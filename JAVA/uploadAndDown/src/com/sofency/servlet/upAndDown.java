package com.sofency.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class upAndDown
 */
public class upAndDown extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");//从前端获取的文件类型
		response.setCharacterEncoding("utf-8");//响应的文件类型
		response.setContentType("text/html;charset=UTF-8");//响应文件的类型
		//上传文件到servlet中
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart) {//确定前端form表单中是否有enctype元素
			
			DiskFileItemFactory factory =  new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory); //这样就可以完美的处理数据了
			
			//设置缓冲区的大小
			factory.setSizeThreshold(10240);
			//设置工厂的位置
			factory.setRepository(new File("H:\\eclipse\\uploadtemp"));
			//控制单个文件的大小
			upload.setSizeMax(20480);  //上传的最大位置
			
			//通过parseRequest解析form中的所有字段 并保存到items集合中
			try {
				List<FileItem> items = upload.parseRequest(request);//处理前端的请求数据  即前端传过来的sname sno spicture 就存储在items中
				
				Iterator<FileItem> iter = items.iterator();//设置遍历的类型
				
				while(iter.hasNext()) {
					
					FileItem item = iter.next();//依次取出数据 数据可以看做是字典对象
					String itemName = item.getFieldName();//获取name属性值
					
					//判断上传类型是否符合要求  不符合要求返回
					int sno=-1;
					String sname = null;
					if(item.isFormField()) {
						if(itemName.equals("sno")) {//判断是否是sno属性
							sno = Integer.parseInt(item.getString());	
						}else {//判断是否是sname属性
							sname = item.getString();
						}
					}else {//是文件字段
						String fileName = item.getName();//获取文件名
						String  path="H:\\eclipse\\upload";//设置路径为定值
						String type = fileName.substring(fileName.indexOf(".")+1);//获取文件的后缀
						
						if(type.equals("jpg")||type.equals("txt")||type.equals("gif")) {
							//获取文件的内容
							//定义文件路径
							File file=new  File(path,fileName);
							//设置文件上传时用到的临时文件的大小
							item.write(file);
							
							
							
							
						}else {
							System.out.println("图片上传有误");
							return;
						}
					}
				}		
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
