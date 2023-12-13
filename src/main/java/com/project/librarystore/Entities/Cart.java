package com.project.librarystore.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Cart")

public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long bookId;
	private Long qty;
	private Long total;
	
//	cart<---------->customer
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "orderno") // Specify the name of the foreign key column
	@JsonBackReference
	private Customer orderno;

	
	public Cart(Long id, Long bookId, Long qty, Long total, Customer orderno) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.qty = qty;
		this.total = total;
		this.orderno = orderno;
	}

	public Cart() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Customer getOrderno() {
		return orderno;
	}

	public void setOrderno(Customer orderno) {
		this.orderno = orderno;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", bookId=" + bookId + ", qty=" + qty + ", total=" + total + ", orderno=" + orderno
				+ "]";
	}
	
	
	
	
}
