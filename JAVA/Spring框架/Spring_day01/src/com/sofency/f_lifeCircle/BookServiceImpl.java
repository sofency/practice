package com.sofency.f_lifeCircle;

public class BookServiceImpl implements BookDao {
	/* (non-Javadoc)
	 * @see com.sofency.f_lifeCircle.BookDao#addBook()
	 */
	@Override
	public void addBook() {
		System.out.println("������������鼮");
	}

	@Override
	public void initMethod() {
		System.out.println("��ʼ������");
		
	}

	@Override
	public void destoryMethod() {
		// TODO Auto-generated method stub
		System.out.println("��������");
	}
}
