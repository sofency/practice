package com.sofency.h_annotate_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class studentServiceImpl implements stuentService{

	//Dao²ã
	
	private studentDao studentDao;
	
	@Autowired
	@Qualifier("studentDaoId")
	public void setStudentDao(studentDao studentDao) {
		this.studentDao = studentDao;
	}


	@Override
	public void say() {
		studentDao.sayWorld();
	}
	
}
