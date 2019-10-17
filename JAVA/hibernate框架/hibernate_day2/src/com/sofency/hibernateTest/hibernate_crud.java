package com.sofency.hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.sofency.entity.Company;
import com.sofency.entity.Customer;
import com.sofency.entity.Employee;
import com.sofency.entity.linkMan;

public class hibernate_add {
	
	//级联添加

	public void testAdd(){
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		Company company = new Company();
		company.setCompany_level(1);
		company.setCompany_position("杭州");
		company.setCompany_name("阿里巴巴");
		
		Employee employee1 = new Employee();
		employee1.setEmployee_name("sofency");
		employee1.setEmployee_sex("male");
		
		Employee employee2 = new Employee();
		employee2.setEmployee_name("ahoj");
		employee2.setEmployee_sex("male");	
		
		company.getSetEmployee().add(employee1);
		employee1.setCompany(company);
		company.getSetEmployee().add(employee2);
		employee2.setCompany(company);
		session.save(company);
		session.save(employee1);
		session.save(employee2);//双向维护表
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	//假设百度倒闭了要注销掉百度
	
	public void testDelete1() {
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Company company = session.get(Company.class, 2);
		session.delete(company);
		
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
	}
	
	
	@Test
	public void testUpdate1() {
		Session session = hibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Company company = session.get(Company.class, 2);
		company.setCompany_level(4);//公司的级别提高了
		//不用执行update操作
		
		transaction.commit();
		session.close();
		hibernateUtils.closeSessionFactory();
	}
	public void testAdd1() {
		Session session = hibernateUtils.getCurrentSession();
		Transaction tra =  session.beginTransaction();
		
		Customer customer = new Customer();//湖区对象进行 添加联系人
		customer.setCustName("TenXun");
		customer.setCustLevel("普通会员");
		customer.setCustSource("internet");
		customer.setCustMobile("218291");
		customer.setCustPhone("1109010");
	
//		Customer customer = session.get(Customer.class, 6);
		
		linkMan linkman = new linkMan();
		linkman.setLkm_name("吴婷");
		linkman.setLkm_gender("female");
		linkman.setLkm_phone("1314110");
		
		
		
		//级联添加
		customer.getSetLinkMan().add(linkman);
		linkman.setCustomer(customer);
		
		session.save(customer);
		session.save(linkman);
		
		tra.commit();
		hibernateUtils.closeSessionFactory();
		
	}
	
	//级联删除

	public void testDelete() {
		Session session = hibernateUtils.getCurrentSession();
		Transaction tra =  session.beginTransaction();
		
		Customer custotmer = session.get(Customer.class, 6);
		session.delete(custotmer);
		
//		linkMan linkman = session.get(linkMan.class, 6);
//		
//		session.delete(linkman);
		tra.commit();
		hibernateUtils.closeSessionFactory();
		
	}
	
	public void testInverse() {
		
		Session session = hibernateUtils.getCurrentSession();
		Transaction tra =  session.beginTransaction();
		
		
//		session.delete(custotmer);
		
		
		//吴婷跳槽到alibaba
		Customer alibaba = session.get(Customer.class, 1);
		linkMan wuTing = session.get(linkMan.class, 8);
		
		alibaba.getSetLinkMan().add(wuTing);
		wuTing.setCustomer(alibaba);//可以不进行修改
		tra.commit();
		hibernateUtils.closeSessionFactory();
		
		
		
	}
}
