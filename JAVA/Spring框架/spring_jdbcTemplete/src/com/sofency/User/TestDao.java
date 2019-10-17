package com.sofency.User;

import org.springframework.jdbc.core.JdbcTemplate;


//Dao���ȡģ����в������ݿ�
public class TestDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//���� ���ֲ�ѯ
	public void AddUser(User user) {
		String sql="insert into User(username,password) values(?,?)";
		Object[] object= {user.getUsername(),user.getPassword()};
		jdbcTemplate.update(sql, object);
	}

}
