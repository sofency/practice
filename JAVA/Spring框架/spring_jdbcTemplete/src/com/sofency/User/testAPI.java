package com.sofency.User;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class testAPI {
	public static void main(String[] args) {
		
		//1.��������Դ
		BasicDataSource dataSource = new BasicDataSource();
		//����������
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sofency?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("19980120");
		
		
		//2.����ģ��
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);

		//3.ͨ��api���в���
		jdbcTemplate.update("insert into spring(username,password) values(?,?);","alice","12354");
		
		System.out.println("sofeny");
		
	}
}
