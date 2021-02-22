package net.codejava.BookUser.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.BookUser.model.Book;

public class BookDAOImpl implements BookDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public BookDAOImpl(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Book b) {
		String sql="INSERT INTO books(author, publisher, publish_date)VALUES(?,?,?)";
		return jdbcTemplate.update(sql, b.getAuthor(), b.getPublisher(),b.getPublish_date());
		
	}

	@Override
	public int update(Book b) {
		 //String date="2020-09-15";
		 //DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 //LocalDate localDate= LocalDate.parse(date,formatter);
			//now convert localdate to date
			//java.sql.Date publishDate= java.sql.Date.valueOf(localDate);
		String sql="UPDATE books SET author=?, publisher=?, publish_date=? WHERE book_id=?";
			//String sql="update books set author="+b.getAuthor()+",publisher="+b.getPublisher()
			     //      +",publish_date="+b.getPublish_date()+"where book_id="+ b.getBookId();
		return jdbcTemplate.update(sql, b.getAuthor(), b.getPublisher(), b.getPublish_date(), b.getBookId());
		
		//return jdbcTemplate.update(sql, "Bianca", "Harper Collins canada",publishDate, 2);

	}

	@Override
	public Book get(Integer bookId) {
		String sql="SELECT * FROM books WHERE book_id="+ bookId;
		
		ResultSetExtractor<Book> extractor= new ResultSetExtractor<Book>() {
			
			@Override
			public Book extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String author= rs.getString("author");
					String publisher= rs.getString("publisher");
					String publish_date= rs.getString("publish_date");
					
					//DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
					//LocalDate localDate= LocalDate.parse(publish_date,formatter);
					//now convert localdate to date
					java.sql.Date publishDate= java.sql.Date.valueOf(publish_date);
					
					return new Book(bookId, author,publisher,publishDate);

				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql="DELETE FROM books WHERE book_id="+id;
		
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Book> list() {
		String sql="SELECT * FROM books";
		
		RowMapper<Book> rowMapper = new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id= rs.getInt("book_id");
				String author= rs.getString("author");
				String publisher= rs.getString("publisher");
				String publish_date= rs.getString("publish_date");
				
				DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate= LocalDate.parse(publish_date,formatter);
				//now convert localdate to date
				java.sql.Date publishDate= java.sql.Date.valueOf(publish_date);
				
				return new Book(id,author,publisher,publishDate);

			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

}
