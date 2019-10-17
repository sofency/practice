package com.sofency.f_lifeCircle;

public class BookServiceImpl implements BookDao {
	/* (non-Javadoc)
	 * @see com.sofency.f_lifeCircle.BookDao#addBook()
	 */
	@Override
	public void addBook() {
		System.out.println("生命周期添加书籍");
	}

	@Override
	public void initMethod() {
		System.out.println("初始化方法");
		
	}

	@Override
	public void destoryMethod() {
		// TODO Auto-generated method stub
		System.out.println("结束方法");
	}
}
