package com.sofency.b_DI;

public class BookServiceImpl implements BookService {
	private BookDao bookDao=new BookDaoImpl();

	/* (non-Javadoc)
	 * @see com.sofency.DI.BookService#setBookDao(com.sofency.DI.BookDao)
	 */
	@Override
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	/* (non-Javadoc)
	 * @see com.sofency.DI.BookService#addBookService()
	 */
	@Override
	public void addBookService() {
		this.bookDao.addBook();
	}
}
