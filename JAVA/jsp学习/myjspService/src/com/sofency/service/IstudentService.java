package com.sofency.service;

import java.util.ArrayList;

import com.sofency.entries.student;

public interface IstudentService {
	public  int addstudent(student stu);
	//ɾ��ѧ����Ϣ
	public int deleteStu(String sno);
	//չʾ���е�ѧ����Ϣ
	public ArrayList<student> showStudents();
	
	//����ҳ��չʾѧ����Ϣ
	public ArrayList<student> showStudentsByPage(int currentPage, int pageSize);
	
	
	//��ѯ���ݿ��е�������
	public int CountStudents();
	
	
	//�޸�ѧ����Ϣ
	public int changeStu(student stu);
	
	public student searchStu(String sno);
}
