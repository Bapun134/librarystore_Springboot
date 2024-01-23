package com.project.librarystore.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="AdminLogin")
public class AdminLogin {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	private String password;
	
	
	public AdminLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public AdminLogin() {
		
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "AdminLogin [id=" + id + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	

}
