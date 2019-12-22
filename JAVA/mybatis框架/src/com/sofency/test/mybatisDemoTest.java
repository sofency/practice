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
        //读取配置文件
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            //创建sqlSessionFactory工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            //使用工厂生产sqlSession对象
            SqlSession session = factory.openSession();
            //使用sqlSession创建Dao接口的代理对象
            UserDao userDao = session.getMapper(UserDao.class);
            //使用代理对象执行方法
            System.out.println("--------------------");
//	            List<User> list = userDao.findAllUser();
//	            for (User user:list){
//	                System.out.println(user.toString());
//	            }
            
            User user = userDao.findByUsername("吴婷");
            System.out.println(user.toString());
            //释放资源
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	 }
	
	//根据性别和名字进行模糊查询
	public void find() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		SqlSession session = factory.openSession();
		
		UserDao userdao = session.getMapper(UserDao.class);
		
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("女");
		userCustom.setUsername("小明");
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		List<User> list = userdao.findByUsernameAndIdWithSql(userQueryVo);
		
		for (User user:list){
            System.out.println(user.toString());
        }
		session.close();
		in.close();
		
	}
	
	//测试根据ids进行查询
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
	
	
	
	//查询部分数据
    public void findPart() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");	
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		UserDao userDao = session.getMapper(UserDao.class);
		
		List<User> list = userDao.findPartUser("男");

		for (User user:list){
            System.out.println(user.toString());
        }
		session.close();
		in.close();
		
	}
	
	 public void testdemo() {
        //读取配置文件
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            //创建sqlSessionFactory工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            //使用工厂生产sqlSession对象
            SqlSession session = factory.openSession();
            //通过sqlsession操作数据库
            List<User> list = session.selectList("dao.findAllUser");//参数介绍 参数1 就是mapper下面的namespace.id所对应的方法,如果有参数的话，第二个参数就是 查询的参数
            //使用代理对象执行方法
            System.out.println("--------------------");
            for (User user:list){
                System.out.println(user.toString());
            }
            //释放资源
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
		
	//模糊查询
		
	  public void  testFuzzyQuery() {
		 //读取配置文件
		  InputStream in = null;
		  SqlSessionFactory factory =null;
		  SqlSession session=null;
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
            //创建sqlSessionFactory工厂
            factory = new SqlSessionFactoryBuilder().build(in);
            //使用工厂生产sqlSession对象
            session = factory.openSession();
            //通过sqlsession操作数据库
            List<User> list = session.selectList("dao.fuzzyQuery","小明");//参数介绍 参数1 就是mapper下面的namespace.id所对应的方法,如果有参数的话，第二个参数就是 查询的参数
            //使用代理对象执行方法
            System.out.println("--------------------");
            for (User user:list){
                System.out.println(user.toString());
            }
           
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        	  //释放资源
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
		
		//插入数据
	public void insert() {
		InputStream in = null;
		SqlSessionFactory factory=null;
		SqlSession session=null;
		try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(in);
			session = factory.openSession();
			User user = new User();
			user.setUsername("嘻嘻");
			user.setBirthday(new Date(System.currentTimeMillis()));
			user.setSex("女");
			user.setAddress("南阳");
			session.insert("dao.insertUser", user);
			System.out.println(user.getUserId());
			session.commit();//mybatis 不是自动提交的
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
        	  //释放资源
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
			
			session.delete("dao.deleteUser", 1);//删除userId为1的用户
			session.commit();//mybatis 不是自动提交的
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
        	  //释放资源
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
			session.update("dao.updateUser", user);//将userId为12的用户更新名字
			session.commit();//mybatis 不是自动提交的
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
        	  //释放资源
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
 * mybatis 的总结
 * mybatis是什么
 * mybatis是一个持久层的框架 mybatis是一个不完全的orm框架,sql语句需要程序员自己去编写，但是mybatis也是有映射，输入参数映射,输出结果映射
 * mybatis 入门门槛不高，学习成本低，让程序员把精力放在sql语句上面，对于sql语句优化非常方便，适应需求变化较多的项目
 * 
 * mybatis框架的执行过程
 * 1. 通过配置mybatis的配置文件MsqlMapConfig.xml(名称不固定)
 * 2. 通过配置文件，加载mybatis运行环境，创建sqlSessionFactory会话工厂
 *  sqlSessionFactory在实际使用的时候按单例模式
 * 3. 通过sqlSessionFactory创建sqlSession
 * sqlSession 是一个面向用户接口（提供操作数据库方法）实现对象是线程不安全的  建议sqlSession写在方法体内部 
 * 4.调用sqlSession的方法区操作数据库
 *   如果需要提交事务，需要执行sqlSession的commit()方法
 * 5. 释放资源 关闭SqlSession
 * 
 * 
 * mapper开发dao的方法
 * 1. 原始dao的方法
 *  需要程序员编写dao的接口和实现类
 *  需要在dao实现类中注入一个sqlSessionFactory工厂
 *  
 *  
 * 2.mapper 代理开发方法（建议使用）
 *   只需要程序员编写mapper接口，就是dao接口
 *   程序员在编写mapper.xml（映射文件）和mapper.java 需要遵循一个开发的规范
 *   1. mapper.xml 中namespace 就是mapper.java的全限定路径
 *   2. mapper.xml 中statement的id和mapper.java中方法名一致
 *   3. mapper.xml 中的statement的parameterType指定输入参数的类型和mapper.java的方法输入参数类型一致
 *   4. mapper.xml 中statement的resultType指定输出结果的类型和mapper.java的方法返回值类型一致
 *   
 * sqlMapperConfig.xml 配置文件 可以配置properties属性 别名(可以在全局文件中引用) mapper加载
 * 
 * 输入映射：
 * parameterType: 指定输入参数类型可以简单类型 pojo hashmap
 * 		对于综合查询，建议parameterType 使用包装的pojo 有利于系统的扩展
 * 输出类型
 * resultType： 执行输出的参数类型可以是简单的类型或者是pojo 类型  注 查询到的列名和resultType指定的pojo属性名一致才能映射成功
 * resultMap:  可以通过resultMap  完成一个高级映射 
 *   如果查询的列名和pojo的属性名不一致时 可以通过resultMap设置列名和属性名之间的对应关系 可以完成映射
 *  高级映射：
 *  	将关联查询的列映射到一个pojo属性中 一对一
 *  	将关联查询的列映射到一个List<pojo> 中完成一对多
 * 
 * 
 * 动态sql(重点)
 * 	 if test判断
 * 	where 
 *   foreach
 *   sql片段  使用include refid进行引用
 */

/**
 * 
 * 
 * 
 */


