package com.project.librarystore.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity 
@Table(name="Customer")
public class Customer {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderno;
	
	private String customerName;
	private Long phone;
	private Double totalPrice;
	
	
//	customer<---------->cart
	@OneToMany(mappedBy="orderno",cascade=CascadeType.PERSIST)
	@JsonManagedReference
	private List<Cart> cart;

	
		
	public Customer(Long orderno, String customerName, Long phone, Double totalPrice, List<Cart> cart) {
		super();
		this.orderno = orderno;
		this.customerName = customerName;
		this.phone = phone;
		this.totalPrice = totalPrice;
		this.cart = cart;
	}
	
	public Customer() {
		
	}

	public Long getOrderno() {
		return orderno;
	}

	public void setOrderno(Long orderno) {
		this.orderno = orderno;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [orderno=" + orderno + ", customerName=" + customerName + ", phone=" + phone + ", totalPrice="
				+ totalPrice + ", cart=" + cart + "]";
	}
	
	
}
