package com.sofency.User;

import org.springframework.jdbc.core.JdbcTemplate;


//Dao层获取模板进行操作数据库
public class TestDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//根据 名字查询
	public void AddUser(User user) {
		String sql="insert into User(username,password) values(?,?)";
		Object[] object= {user.getUsername(),user.getPassword()};
		jdbcTemplate.update(sql, object);
	}

}
