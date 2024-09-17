package com.mapping2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@Column(name="Book_Id")
	private int bookId;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Publication_Year")
	private String publicationYear;
	
	@ManyToOne
	private Author author;

	public Book() {
		super();
	}

	public Book(int bookId, String title, String publicationYear, Author author) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.publicationYear = publicationYear;
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
