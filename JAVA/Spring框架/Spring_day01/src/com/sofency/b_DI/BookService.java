package com.sofency.b_DI;

public interface BookService {

	//依赖注入
	void setBookDao(BookDao bookDao);
	//基于set方法

	void addBookService();

}