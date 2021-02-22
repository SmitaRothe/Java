package net.codejava.BookUser.model;

import java.sql.Date;

public class Book {

	private Integer bookId;

	private String author;

	private String publisher;

	private Date publish_date;

	public Book(Integer id, String author, String publisher, Date publish_date) {
		this(author,publisher,publish_date);
		this.bookId = id;
		
	}

	public Book(String author, String publisher, Date publish_date) {
		this.author = author;
		this.publisher = publisher;
		this.publish_date = publish_date;
	}

	public Book() {
	}

	

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", author=" + author + ", publisher=" + publisher + ", publish_date="
				+ publish_date + "]";
	}

}
