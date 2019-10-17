package com.sofency.h_annotate_web;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("studentDaoId")
//@Component
public class studentDaoImpl implements studentDao{

	@Override
	public void sayWorld() {
		// TODO Auto-generated method stub
		System.out.println("世界很大");
	}
	

}
