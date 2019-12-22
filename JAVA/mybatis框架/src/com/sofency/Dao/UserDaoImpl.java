package com.sofency.Dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.sofency.domain.User;
import com.sofency.domain.UserQueryVo;

public class UserDaoImpl implements UserDao{

	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {//构造函数
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<User> findAllUser() {
		SqlSession session = this.sqlSessionFactory.openSession();
		List<User> list = session.selectList("dao.findAllUser");
		session.close();
		return list;
	}

	@Override
	public User findByUsername(String username) {
		SqlSession session = sqlSessionFactory.openSession();
//		User user = session.selectOne("dao.findByUsername",new Date());//这样写不会检验出错误
		User user = session.selectOne("dao.findByUsername",username);
		session.close();
		return user;
	}

	@Override
	public List<User> fuzzyQuery(String str) {
		SqlSession session = sqlSessionFactory.openSession();
		return null;
	}

	@Override
	public void insertUser(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		
	}

	@Override
	public void deleteUser(int userId) {
		SqlSession session = sqlSessionFactory.openSession();		
	}

	@Override
	public void updateUser(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		
	}

	@Override
	public List<User> findByUsernameAndSex(UserQueryVo userQueryVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findPartUser(String sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByUsernameAndIdWithSql(UserQueryVo userQueryVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByIds(UserQueryVo userQueryVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
