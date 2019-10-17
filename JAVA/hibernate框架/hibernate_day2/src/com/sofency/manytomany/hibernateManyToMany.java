package com.sofency.manytomany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sofency.hibernateTest.hibernateUtils;

public class hibernateManyToMany {
	
	
	public void testAdd() {
		Session session = hibernateUtils.openSession();
		Transaction tra = session.beginTransaction();
		
		User user1 = new User();
		user1.setUser_name("sophia");
		user1.setUser_sex("female");
		user1.setUser_age("18");
		
		User user2 = new User();
		user2.setUser_name("sofency");
		user2.setUser_sex("male");
		user2.setUser_age("29");
		
		
		Role role1 = new Role();
		role1.setRole_level("2");
		role1.setRole_desc("总经理");
		
		Role role2 = new Role();
		role2.setRole_level("3");
		role2.setRole_desc("策划总监");
		
		Role role3 = new Role();
		role3.setRole_level("5");
		role3.setRole_desc("项目经理");
		
		
		user1.getSetRole().add(role1);
		user1.getSetRole().add(role2);//董事长兼任主管
		
		user2.getSetRole().add(role3);
		session.save(user1);
		session.save(user2);
		
		tra.commit();
		session.close();
	}

	//删除用户
	@Test
	public void testDeleteUser() {
		
		Session session = hibernateUtils.openSession();
		Transaction tra = session.beginTransaction();
		
		User user1 = session.get(User.class, 2);
		session.delete(user1);
		
		tra.commit();
		session.close();
		
		
	}
	
	//删除用户的角色  维护第三张表

	public void testDeleteRole() {
			
			Session session = hibernateUtils.openSession();
			Transaction tra = session.beginTransaction();
			
			User user1 = session.get(User.class, 3);
			Role role1 = session.get(Role.class, 4);
		    user1.getSetRole().remove(role1);
			
			tra.commit();
			session.close();
			
			
		}
	

}
