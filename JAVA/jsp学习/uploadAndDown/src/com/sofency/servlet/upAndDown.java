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
		
		request.setCharacterEncoding("utf-8");//��ǰ�˻�ȡ���ļ�����
		response.setCharacterEncoding("utf-8");//��Ӧ���ļ�����
		response.setContentType("text/html;charset=UTF-8");//��Ӧ�ļ�������
		//�ϴ��ļ���servlet��
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart) {//ȷ��ǰ��form�����Ƿ���enctypeԪ��
			
			DiskFileItemFactory factory =  new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory); //�����Ϳ��������Ĵ���������
			
			//���û������Ĵ�С
			factory.setSizeThreshold(10240);
			//���ù�����λ��
			factory.setRepository(new File("H:\\eclipse\\uploadtemp"));
			//���Ƶ����ļ��Ĵ�С
			upload.setSizeMax(20480);  //�ϴ������λ��
			
			//ͨ��parseRequest����form�е������ֶ� �����浽items������
			try {
				List<FileItem> items = upload.parseRequest(request);//����ǰ�˵���������  ��ǰ�˴�������sname sno spicture �ʹ洢��items��
				
				Iterator<FileItem> iter = items.iterator();//���ñ���������
				
				while(iter.hasNext()) {
					
					FileItem item = iter.next();//����ȡ������ ���ݿ��Կ������ֵ����
					String itemName = item.getFieldName();//��ȡname����ֵ
					
					//�ж��ϴ������Ƿ����Ҫ��  ������Ҫ�󷵻�
					int sno=-1;
					String sname = null;
					if(item.isFormField()) {
						if(itemName.equals("sno")) {//�ж��Ƿ���sno����
							sno = Integer.parseInt(item.getString());	
						}else {//�ж��Ƿ���sname����
							sname = item.getString();
						}
					}else {//���ļ��ֶ�
						String fileName = item.getName();//��ȡ�ļ���
						String  path="H:\\eclipse\\upload";//����·��Ϊ��ֵ
						String type = fileName.substring(fileName.indexOf(".")+1);//��ȡ�ļ��ĺ�׺
						
						if(type.equals("jpg")||type.equals("txt")||type.equals("gif")) {
							//��ȡ�ļ�������
							//�����ļ�·��
							File file=new  File(path,fileName);
							//�����ļ��ϴ�ʱ�õ�����ʱ�ļ��Ĵ�С
							item.write(file);
							
							
							
							
						}else {
							System.out.println("ͼƬ�ϴ�����");
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
