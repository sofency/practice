package com.sofency.transferServiceImpl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.sofency.transferDao.transferMoney;
import com.sofency.transferService.transfer;

public class transferImpl implements transfer{

	private transferMoney transfer;
	
	public void setTransfer(transferMoney transfer) {
		this.transfer = transfer;
	}

	//注入事务模板
	private  TransactionTemplate transaction;
	public void setTransaction(TransactionTemplate transaction) {
		this.transaction = transaction;
	}

	@Override
	public void transferMoney(String send,String get,int money) {
		// TODO Auto-generated method stub
		transaction.execute(new TransactionCallbackWithoutResult() {
			@Override
			//jdk8 不需要使用匿名内部类
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				transfer.out(send, money);
			    //int i=1/0;
				transfer.in(get, money);
			}
		});
	}

}
