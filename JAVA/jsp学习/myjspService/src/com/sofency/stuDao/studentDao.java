package com.sofency.stuDao;

import java.util.ArrayList;

import com.sofency.entries.student;

public interface studentDao {
	//�ж��Ƿ���ڸ�ѧ��
	public int isExit(String sno);
	
	//����ѧ�Ų�����Ϣ
	public student checkStudent(String sno);
	
	//���ѧ����Ϣ
	public int  addstu(student stu) ;

	//����ɾ��ѧ����Ϣ
	public int deleteStu(String sno) ;

	//��ѯ����ѧ������Ϣ
	public ArrayList<student> queryAllStudents();

	//��ҳ����ѧ������Ϣ
	public ArrayList<student> quaryStudentsByPage(int currentPage,int pageSize);

	//��ѯ������
	public int countStu();
	
	
	//�޸�ѧ����Ϣ
	public int changeStudentInfo(student stu);
}
