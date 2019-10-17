package com.sofency.service;

import java.util.ArrayList;

import com.sofency.entries.student;

public interface IstudentService {
	public  int addstudent(student stu);
	//删除学生信息
	public int deleteStu(String sno);
	//展示所有的学生信息
	public ArrayList<student> showStudents();
	
	//根据页数展示学生信息
	public ArrayList<student> showStudentsByPage(int currentPage, int pageSize);
	
	
	//查询数据库中的总数据
	public int CountStudents();
	
	
	//修改学生信息
	public int changeStu(student stu);
	
	public student searchStu(String sno);
}
