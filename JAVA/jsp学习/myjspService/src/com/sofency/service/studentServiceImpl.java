package com.sofency.service;

import java.util.ArrayList;

import com.sofency.entries.student;
import com.sofency.stuDao.studentDaoImpl;

//�����ݿ���ʲ�����߼�������ɾ�Ĳ�
public class studentServiceImpl implements IstudentService{
	//���ѧ����Ϣ
	public int addstudent(student stu) {
		studentDaoImpl stuDao = new studentDaoImpl();
		//����⵽stuDao����ʱ �����ʧ��
		if(stuDao.isExit(stu.getSnoString())== 0) {
			 return 0;//˵������
		}else {//������ִ�����
			return stuDao.addstu(stu);
		}
	}
	//ɾ��ѧ����Ϣ
	public int deleteStu(String sno) {
		studentDaoImpl stuDao = new studentDaoImpl(); 
		return stuDao.deleteStu(sno);
	}
	
	//չʾ���е�ѧ����Ϣ
	public ArrayList<student> showStudents(){
		studentDaoImpl stuDao = new studentDaoImpl();
		ArrayList<student> studentList = stuDao.queryAllStudents();
		return studentList;
		
	}
	
	@Override
	//����ҳ��չʾѧ����Ϣ
	public ArrayList<student> showStudentsByPage(int currentPage, int pageSize) {
		
		studentDaoImpl stuImpl = new studentDaoImpl();
		ArrayList<student> list= stuImpl.quaryStudentsByPage(currentPage, pageSize);
		return list;
	}
	
	@Override
	public int CountStudents() {
		studentDaoImpl stuImpl= new studentDaoImpl();
		return stuImpl.countStu();
	}
	
	//�޸�ѧ����Ϣ
	@Override
	public int changeStu(student stu) {
		studentDaoImpl stuImpl = new studentDaoImpl();
		return stuImpl.changeStudentInfo(stu);
	}
	
	//����ѧ�Ų���ѧ����Ϣ
	public student searchStu(String sno) {
		studentDaoImpl stuImpl = new studentDaoImpl();
		return stuImpl.checkStudent(sno);//����ѧ����Ϣ
		
	}
	
	
	

}
