package com.sofency.transferServiceImpl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sofency.transferDao.transferMoney;
import com.sofency.transferService.transfer;


@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class transferImpl implements transfer{

	private transferMoney transfer;
	public void setTransfer(transferMoney transfer) {
		this.transfer = transfer;
	}
	@Override
	public void transferMoney(String send,String get,int money) {
		// TODO Auto-generated method stub
		transfer.out(send, money);
	    //int i=1/0;
		transfer.in(get, money);
	}
}
