package com.sofency.stuDao;

import java.util.ArrayList;

import com.sofency.entries.student;

public interface studentDao {
	//判断是否存在该学生
	public int isExit(String sno);
	
	//根据学号查找信息
	public student checkStudent(String sno);
	
	//添加学生信息
	public int  addstu(student stu) ;

	//根据删除学生信息
	public int deleteStu(String sno) ;

	//查询所有学生的信息
	public ArrayList<student> queryAllStudents();

	//分页查找学生的信息
	public ArrayList<student> quaryStudentsByPage(int currentPage,int pageSize);

	//查询总数据
	public int countStu();
	
	
	//修改学生信息
	public int changeStudentInfo(student stu);
}
