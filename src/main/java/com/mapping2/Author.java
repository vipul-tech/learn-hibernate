package com.mapping2;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {
	
	@Id
	@Column(name="Author_Id")
	private int authorId;
	
	@Column(name="Author_Name")
	private String authorName;
	
	@Column(name="Birth_Date")
	private Date bithDate;
	
	//DEFAULT IS LAZY LOADING, DURING LAZY LOADING, DATA IS LOADED WHEN THERE IS NEED
	//DURING EAGER LOADING, DATA IS LOADED AT THE START UP
	@OneToMany(mappedBy="author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Book> books;
	
	public Author() {
		super();
	}

	public Author(int authorId, String authorName, Date bithDate, List<Book> books) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.bithDate = bithDate;
		this.books = books;
	}

	public int getAuthorId() {
		return authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public Date getBithDate() {
		return bithDate;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setBithDate(Date bithDate) {
		this.bithDate = bithDate;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
