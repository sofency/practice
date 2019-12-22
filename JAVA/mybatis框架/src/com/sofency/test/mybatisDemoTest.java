package com.sofency.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sofency.Dao.UserDao;
import com.sofency.domain.User;
import com.sofency.domain.UserCustom;
import com.sofency.domain.UserQueryVo;

public class mybatisDemoTest {
	public void test() {
        //��ȡ�����ļ�
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            //����sqlSessionFactory����
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            //ʹ�ù�������sqlSession����
            SqlSession session = factory.openSession();
            //ʹ��sqlSession����Dao�ӿڵĴ������
            UserDao userDao = session.getMapper(UserDao.class);
            //ʹ�ô������ִ�з���
            System.out.println("--------------------");
//	            List<User> list = userDao.findAllUser();
//	            for (User user:list){
//	                System.out.println(user.toString());
//	            }
            
            User user = userDao.findByUsername("����");
            System.out.println(user.toString());
            //�ͷ���Դ
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	 }
	
	//�����Ա�����ֽ���ģ����ѯ
	public void find() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		SqlSession session = factory.openSession();
		
		UserDao userdao = session.getMapper(UserDao.class);
		
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("Ů");
		userCustom.setUsername("С��");
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		List<User> list = userdao.findByUsernameAndIdWithSql(userQueryVo);
		
		for (User user:list){
            System.out.println(user.toString());
        }
		session.close();
		in.close();
		
	}
	
	//���Ը���ids���в�ѯ
	@Test
	public void findByIds() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		SqlSession session = factory.openSession();
		
		UserDao userdao = session.getMapper(UserDao.class);
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(11);
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setIds(list);
		List<User> list1 = userdao.findByIds(userQueryVo);
		
		for (User user:list1){
            System.out.println(user.toString());
        }
		session.close();
		in.close();
		
	}
	
	
	
	//��ѯ��������
    public void findPart() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");	
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		UserDao userDao = session.getMapper(UserDao.class);
		
		List<User> list = userDao.findPartUser("��");

		for (User user:list){
            System.out.println(user.toString());
        }
		session.close();
		in.close();
		
	}
	
	 public void testdemo() {
        //��ȡ�����ļ�
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            //����sqlSessionFactory����
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            //ʹ�ù�������sqlSession����
            SqlSession session = factory.openSession();
            //ͨ��sqlsession�������ݿ�
            List<User> list = session.selectList("dao.findAllUser");//�������� ����1 ����mapper�����namespace.id����Ӧ�ķ���,����в����Ļ����ڶ����������� ��ѯ�Ĳ���
            //ʹ�ô������ִ�з���
            System.out.println("--------------------");
            for (User user:list){
                System.out.println(user.toString());
            }
            //�ͷ���Դ
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
		
	//ģ����ѯ
		
	  public void  testFuzzyQuery() {
		 //��ȡ�����ļ�
		  InputStream in = null;
		  SqlSessionFactory factory =null;
		  SqlSession session=null;
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
            //����sqlSessionFactory����
            factory = new SqlSessionFactoryBuilder().build(in);
            //ʹ�ù�������sqlSession����
            session = factory.openSession();
            //ͨ��sqlsession�������ݿ�
            List<User> list = session.selectList("dao.fuzzyQuery","С��");//�������� ����1 ����mapper�����namespace.id����Ӧ�ķ���,����в����Ļ����ڶ����������� ��ѯ�Ĳ���
            //ʹ�ô������ִ�з���
            System.out.println("--------------------");
            for (User user:list){
                System.out.println(user.toString());
            }
           
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        	  //�ͷ���Դ
            try {
            	if(in!=null) {
            		in.close();
            	}
            	if(session!=null) {
            		 session.close();
            	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	  }
		
		//��������
	public void insert() {
		InputStream in = null;
		SqlSessionFactory factory=null;
		SqlSession session=null;
		try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(in);
			session = factory.openSession();
			User user = new User();
			user.setUsername("����");
			user.setBirthday(new Date(System.currentTimeMillis()));
			user.setSex("Ů");
			user.setAddress("����");
			session.insert("dao.insertUser", user);
			System.out.println(user.getUserId());
			session.commit();//mybatis �����Զ��ύ��
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
        	  //�ͷ���Դ
            try {
            	if(in!=null) {
            		in.close();
            	}
            	if(session!=null) {
            		 session.close();
            	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	  
	  
	
	public void delete() {
		InputStream in = null;
		SqlSessionFactory factory=null;
		SqlSession session=null;
		try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(in);
			session = factory.openSession();
			
			session.delete("dao.deleteUser", 1);//ɾ��userIdΪ1���û�
			session.commit();//mybatis �����Զ��ύ��
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
        	  //�ͷ���Դ
            try {
            	if(in!=null) {
            		in.close();
            	}
            	if(session!=null) {
            		 session.close();
            	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public void update() {
		InputStream in = null;
		SqlSessionFactory factory=null;
		SqlSession session=null;
		try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(in);
			session = factory.openSession();
			User user = new User();
			user.setUserId(12);
			user.setUsername("alice");
			session.update("dao.updateUser", user);//��userIdΪ12���û���������
			session.commit();//mybatis �����Զ��ύ��
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
        	  //�ͷ���Դ
            try {
            	if(in!=null) {
            		in.close();
            	}
            	if(session!=null) {
            		 session.close();
            	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
}

/**
 * mybatis ���ܽ�
 * mybatis��ʲô
 * mybatis��һ���־ò�Ŀ�� mybatis��һ������ȫ��orm���,sql�����Ҫ����Ա�Լ�ȥ��д������mybatisҲ����ӳ�䣬�������ӳ��,������ӳ��
 * mybatis �����ż����ߣ�ѧϰ�ɱ��ͣ��ó���Ա�Ѿ�������sql������棬����sql����Ż��ǳ����㣬��Ӧ����仯�϶����Ŀ
 * 
 * mybatis��ܵ�ִ�й���
 * 1. ͨ������mybatis�������ļ�MsqlMapConfig.xml(���Ʋ��̶�)
 * 2. ͨ�������ļ�������mybatis���л���������sqlSessionFactory�Ự����
 *  sqlSessionFactory��ʵ��ʹ�õ�ʱ�򰴵���ģʽ
 * 3. ͨ��sqlSessionFactory����sqlSession
 * sqlSession ��һ�������û��ӿڣ��ṩ�������ݿⷽ����ʵ�ֶ������̲߳���ȫ��  ����sqlSessionд�ڷ������ڲ� 
 * 4.����sqlSession�ķ������������ݿ�
 *   �����Ҫ�ύ������Ҫִ��sqlSession��commit()����
 * 5. �ͷ���Դ �ر�SqlSession
 * 
 * 
 * mapper����dao�ķ���
 * 1. ԭʼdao�ķ���
 *  ��Ҫ����Ա��дdao�Ľӿں�ʵ����
 *  ��Ҫ��daoʵ������ע��һ��sqlSessionFactory����
 *  
 *  
 * 2.mapper ����������������ʹ�ã�
 *   ֻ��Ҫ����Ա��дmapper�ӿڣ�����dao�ӿ�
 *   ����Ա�ڱ�дmapper.xml��ӳ���ļ�����mapper.java ��Ҫ��ѭһ�������Ĺ淶
 *   1. mapper.xml ��namespace ����mapper.java��ȫ�޶�·��
 *   2. mapper.xml ��statement��id��mapper.java�з�����һ��
 *   3. mapper.xml �е�statement��parameterTypeָ��������������ͺ�mapper.java�ķ��������������һ��
 *   4. mapper.xml ��statement��resultTypeָ�������������ͺ�mapper.java�ķ�������ֵ����һ��
 *   
 * sqlMapperConfig.xml �����ļ� ��������properties���� ����(������ȫ���ļ�������) mapper����
 * 
 * ����ӳ�䣺
 * parameterType: ָ������������Ϳ��Լ����� pojo hashmap
 * 		�����ۺϲ�ѯ������parameterType ʹ�ð�װ��pojo ������ϵͳ����չ
 * �������
 * resultType�� ִ������Ĳ������Ϳ����Ǽ򵥵����ͻ�����pojo ����  ע ��ѯ����������resultTypeָ����pojo������һ�²���ӳ��ɹ�
 * resultMap:  ����ͨ��resultMap  ���һ���߼�ӳ�� 
 *   �����ѯ��������pojo����������һ��ʱ ����ͨ��resultMap����������������֮��Ķ�Ӧ��ϵ �������ӳ��
 *  �߼�ӳ�䣺
 *  	��������ѯ����ӳ�䵽һ��pojo������ һ��һ
 *  	��������ѯ����ӳ�䵽һ��List<pojo> �����һ�Զ�
 * 
 * 
 * ��̬sql(�ص�)
 * 	 if test�ж�
 * 	where 
 *   foreach
 *   sqlƬ��  ʹ��include refid��������
 */

/**
 * 
 * 
 * 
 */


