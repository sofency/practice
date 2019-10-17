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
		//��һ��  ����hiibernate�ĺ��������ļ�
		//��src�����ҵ�����Ϊhibernate.cfg.xml
		//��hibernatel�����װ����
		Configuration cfg = new  Configuration();
		cfg.configure();
		
		
		//�ڶ���  ����sessionFactory����
		//��ȡhibernate���������ļ����ݣ�����sessionFactory
		//�ڹ����� ����ӳ���ϵ  ���������ݿ�����ѱ���
		SessionFactory sessionFactory = null;
		Session session  = null;
		Transaction tx =null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session  = sessionFactory.getCurrentSession();//��ȡ�߳��е�session �̹߳ر�  session�͹ر���
			
			//���Ĳ� ��������
			tx = session.beginTransaction();
			//д������߼�crud����
			User user =new User();
			user.setUsername("jsaosjoa");
			user.setUpassword("sasa");
			user.setUaddress("xibei");
			session.save(user);//ʹ��save���� �޷��޸�id��ֵ
			tx.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			//session.close();
			sessionFactory.close();
		}
		
		
		// ������  ����������
	
		
		//�鿴��Ч��  ���ݿ��Ƿ��б�  ���ݿ��Ƿ�������
		
		//ʵ����Ķ���״̬
		//˲ʱ̬     ��������û��id  ��session û�й�ϵ  ���
		//�־�̬   ����������idֵ  ������session�й�ϵ  ���²��� get  ���²���   �־�̬���Զ��������ݿ�
		//�й�̬  ����������id ֵ  ������sessionû�й�ϵ ����id  
		
		
		
		
		//������ �ύ����
	
		
		//���߲�
	
		
	}
	
	//ɾ������
	public void testDelete() {
		
		//��������
		Configuration cfg = new Configuration();
		cfg.configure();
		
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		//��������
		Session session = sessionFactory.openSession();
		
		//��������
		Transaction tra = session.beginTransaction();
		
		User user = session.get(User.class, 1);//��ȡidΪ1��ʵ�� �־�̬
		session.delete(user);
		
//		User u= new User();  Ҳ��ɾ��
//		u.setUid(2);
//		session.delete(u);
		
		//�ύ
		tra.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	//�޸Ĳ���
	@Test
	public  void  testUpdate() {
		//���������ļ�
		Configuration cfg = new Configuration();
		cfg.configure();//��ʼ����
		
		//��ȡsessionFactory����
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();//��ʼ����
		
		
		//��������
		Transaction tra = session.beginTransaction(); 
		//��ȡ����
		User user = session.get(User.class, 5);
		user.setUaddress("Beijing");
		session.update(user);
		
		User user1 = session.get(User.class, 5);
		user1.setUaddress("���");
		session.update(user1);
		
		//��������Ļ�  �Ḳ�ǵ�֮ǰ��ֵ  
		//User user = new User();
		//user.setUid(5);  �й�̬�������޸Ĳ���
		//user.setUserName("tiger");
		//session.update(user);�����֮���ֵ��ΪNULL
		
		//saveOrUpdate  ����ʵ����Ӳ��� Ҳ��ʵ�ָ��²���
		//�ύ����
		tra.commit();
		session.close();
		sessionFactory.close();
	}
}
