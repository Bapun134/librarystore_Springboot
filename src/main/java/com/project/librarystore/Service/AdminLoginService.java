package com.project.librarystore.Service;

import org.springframework.stereotype.Service;

import com.project.librarystore.Entities.AdminLogin;

@Service
public interface AdminLoginService {
	
	String signup(AdminLogin admin);
	String login(String email, String password);
}
