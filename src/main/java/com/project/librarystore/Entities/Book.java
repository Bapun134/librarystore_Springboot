package com.project.librarystore.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)     
	private Long Id;
	
	
	private String bookName;
	private String authorName;
	private Long stk;
	private Long price;
	
	
//	book<------>store
	@ManyToOne
    @JoinColumn(name = "store_id") // Name of the foreign key column in Book table
    @JsonBackReference
    private Store store;
	
	public Book(Long id, String bookName, String authorName, Long stk, Long price) {
		super();
		this.Id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.stk = stk;
		this.price = price;
	}
	
	public Book() {
		
	}
	
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Long getStk() {
		return stk;
	}

	public void setStk(Long stk) {
		this.stk = stk;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookItem [Id=" + Id + ", bookName=" + bookName + ", authorName=" + authorName + ", stk=" + stk
				+ ", price=" + price + "]";
	}
	
	
	
	   
}
