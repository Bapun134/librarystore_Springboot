package com.project.librarystore.Service;

import org.springframework.stereotype.Service;

import com.project.librarystore.Entities.UserLogin;

@Service
public interface UserLoginService {

	String signup(UserLogin user);
	String login(String email, String password);
	
}
