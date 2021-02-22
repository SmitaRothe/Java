package net.codejava.BookUser.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.BookUser.model.Book;

class BookDAOTest {

	private DriverManagerDataSource dataSource;
	private BookDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/hb_book_user");
		dataSource.setUsername("bookuser");
		dataSource.setPassword("bookuser");
		
		dao= new BookDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		
		//as the date is in string format, we will convert it into localdate and then date
				//String date=request.getParameter("publishDate");
		        String date="2000-01-01";
				DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate= LocalDate.parse(date,formatter);
				//now convert localdate to date
				java.sql.Date publishDate= java.sql.Date.valueOf(localDate);
				
		Book book= new Book("John Doe", "ABC",publishDate);
		int result= dao.save(book);
		
		assertTrue(result>0);
	}

	@Test
	void testUpdate() {
		String date="2001-01-01";
		DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate= LocalDate.parse(date,formatter);
		//now convert localdate to date
		java.sql.Date publishDate= java.sql.Date.valueOf(localDate);
		//Book book= new Book(2,"Mary Jones", "XYZ",publishDate);
		Book book= new Book(2,"John Doe", "EFG",publishDate);

		int result= dao.update(book);
		
		assertTrue(result>0);
	}

	@Test
	void testGet() {
		int id=1;
		Book book= dao.get(id);
		if(book!=null) {
			System.out.println(book);
		}
		assertNotNull(book);
		
	}

	@Test
	void testDelete() {
		int id=1;
		int result=dao.delete(id);
		
		assertTrue(result>0);
	}

	@Test
	void testList() {
		List<Book> listBook=dao.list();
		
		for(Book tempbook:listBook) {
			System.out.println(tempbook);
		}
		assertTrue(!listBook.isEmpty());
	}

}
