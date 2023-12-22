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
@Table(name="Store")
public class Store {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Storeid;
	
	private String name;
	private String address;
	
//	store<------>book
	@OneToMany(mappedBy="store",cascade=CascadeType.PERSIST)
	@JsonManagedReference
    List<Book> Allbooks;

	public Store(Long storeid, String name, String address) {
		super();
		Storeid = storeid;
		this.name = name;
		this.address = address;
	}

	public Store() {
		
	}
	
	
	public Long getStoreid() {
		return Storeid;
	}

	public void setStoreid(Long storeid) {
		Storeid = storeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Store [Storeid=" + Storeid + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
}
