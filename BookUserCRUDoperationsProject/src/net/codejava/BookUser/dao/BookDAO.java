package net.codejava.BookUser.dao;

import java.util.List;

import net.codejava.BookUser.model.Book;

public interface BookDAO {

	public int save(Book book);
	public int update(Book book);
	public Book get(Integer id);
	public int delete(Integer id);
	public List<Book> list();
	
}
