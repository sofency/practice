package com.sofency.hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.sofency.entity.User;

public class hibernateDemo {
	
	@SuppressWarnings({ "null", "resource" })

	public void testAdd() {
		//第一步  加载hiibernate的核心配置文件
		//到src下面找到名称为hibernate.cfg.xml
		//在hibernatel里面封装对象
		Configuration cfg = new  Configuration();
		cfg.configure();
		
		
		//第二步  创建sessionFactory对象
		//读取hibernate核心配置文件内容，创建sessionFactory
		//在过程中 根据映射关系  在配置数据库里面把表创建
		SessionFactory sessionFactory = null;
		Session session  = null;
		Transaction tx =null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session  = sessionFactory.getCurrentSession();//获取线程中的session 线程关闭  session就关闭了
			
			//第四步 开启事务
			tx = session.beginTransaction();
			//写具体的逻辑crud操作
			User user =new User();
			user.setUsername("jsaosjoa");
			user.setUpassword("sasa");
			user.setUaddress("xibei");
			session.save(user);//使用save方法 无法修改id的值
			tx.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			//session.close();
			sessionFactory.close();
		}
		
		
		// 第三步  类似于连接
	
		
		//查看的效果  数据库是否有表  数据库是否有数据
		
		//实体类的对象状态
		//瞬时态     对象里面没有id  与session 没有关系  添加
		//持久态   对象里面有id值  对象与session有关系  更新操作 get  更新操作   持久态会自动更新数据库
		//托管态  对象里面有id 值  对象与session没有关系 设置id  
		
		
		
		
		//第六步 提交事务
	
		
		//第七步
	
		
	}
	
	//删除操作
	public void testDelete() {
		
		//倒入配置
		Configuration cfg = new Configuration();
		cfg.configure();
		
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		//创建连接
		Session session = sessionFactory.openSession();
		
		//开启事务
		Transaction tra = session.beginTransaction();
		
		User user = session.get(User.class, 1);//获取id为1的实体 持久态
		session.delete(user);
		
//		User u= new User();  也能删除
//		u.setUid(2);
//		session.delete(u);
		
		//提交
		tra.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	//修改操作
	@Test
	public  void  testUpdate() {
		//加载配置文件
		Configuration cfg = new Configuration();
		cfg.configure();//开始布局
		
		//获取sessionFactory对象
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();//开始连接
		
		
		//开启事务
		Transaction tra = session.beginTransaction(); 
		//获取数据
		User user = session.get(User.class, 5);
		user.setUaddress("Beijing");
		session.update(user);
		
		User user1 = session.get(User.class, 5);
		user1.setUaddress("天津");
		session.update(user1);
		
		//如果这样的话  会覆盖掉之前的值  
		//User user = new User();
		//user.setUid(5);  托管态做的是修改操作
		//user.setUserName("tiger");
		//session.update(user);密码和之后的值会为NULL
		
		//saveOrUpdate  既能实现添加操作 也能实现更新操作
		//提交事务
		tra.commit();
		session.close();
		sessionFactory.close();
	}
}
