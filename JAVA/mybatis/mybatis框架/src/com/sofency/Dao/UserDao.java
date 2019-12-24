package com.sofency.Dao;

import java.util.List;

import com.sofency.domain.User;
import com.sofency.domain.UserQueryVo;

public interface UserDao {
	List<User> findAllUser();//��ѯ���е��û�
	//�������ֲ���
	User findByUsername(String username);
	//��������������С�����û�
	List<User> fuzzyQuery(String str);
	//��������
	void  insertUser(User user);
	//ɾ������
	void  deleteUser(int userId);
	//��������
	void updateUser(User user);
	
	//�����û������в�ѯ
	List<User> findByUsernameAndSex(UserQueryVo userQueryVo);
	
	//��ѯ��������  �������ص���User����
	List<User> findPartUser(String sex);
	
	List<User> findByUsernameAndIdWithSql(UserQueryVo userQueryVo);
	
	//����ids���в�ѯ����
	List<User>  findByIds(UserQueryVo userQueryVo);
	
	User findUserById(String id);
}
