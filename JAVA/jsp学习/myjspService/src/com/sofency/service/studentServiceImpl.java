package com.sofency.service;

import java.util.ArrayList;

import com.sofency.entries.student;
import com.sofency.stuDao.studentDaoImpl;

//对数据库访问层进行逻辑化的增删改查
public class studentServiceImpl implements IstudentService{
	//添加学生信息
	public int addstudent(student stu) {
		studentDaoImpl stuDao = new studentDaoImpl();
		//当检测到stuDao存在时 则添加失败
		if(stuDao.isExit(stu.getSnoString())== 0) {
			 return 0;//说明存在
		}else {//不存在执行添加
			return stuDao.addstu(stu);
		}
	}
	//删除学生信息
	public int deleteStu(String sno) {
		studentDaoImpl stuDao = new studentDaoImpl(); 
		return stuDao.deleteStu(sno);
	}
	
	//展示所有的学生信息
	public ArrayList<student> showStudents(){
		studentDaoImpl stuDao = new studentDaoImpl();
		ArrayList<student> studentList = stuDao.queryAllStudents();
		return studentList;
		
	}
	
	@Override
	//根据页数展示学生信息
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
	
	//修改学生信息
	@Override
	public int changeStu(student stu) {
		studentDaoImpl stuImpl = new studentDaoImpl();
		return stuImpl.changeStudentInfo(stu);
	}
	
	//根据学号查找学生信息
	public student searchStu(String sno) {
		studentDaoImpl stuImpl = new studentDaoImpl();
		return stuImpl.checkStudent(sno);//查找学生信息
		
	}
	
	
	

}
