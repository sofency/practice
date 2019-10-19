package com.sofency.transferDaoImpl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sofency.transferDao.transferMoney;

public class transferMoneyImpl extends JdbcDaoSupport implements transferMoney{
	@Override
	public void out(String send, int money) {
		// TODO Auto-generated method stub
		String sql ="update account set money=money-? where username =?";
		Object[] object= {money,send};
		this.getJdbcTemplate().update(sql, object);
	}

	@Override
	public void in(String get, int money) {
		// TODO Auto-generated method stub
		String sql ="update account set money=money+? where username =?";
		Object[] object= {money,get};
		this.getJdbcTemplate().update(sql, object);
	}
}
