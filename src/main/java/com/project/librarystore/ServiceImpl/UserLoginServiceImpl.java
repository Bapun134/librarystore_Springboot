package com.project.librarystore.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.librarystore.Entities.UserLogin;
import com.project.librarystore.Repositories.UserLoginRepository;
import com.project.librarystore.Service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Override
	public String signup(UserLogin user) {
		
		userLoginRepository.save(user);
		return "User's Account Created.";
	}

	@Override
	public String login(String email, String password) {
		
		UserLogin user = userLoginRepository.findByEmail(email);
		
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return "Welcome";
			}else {
				return "Password Incorrect";
			}
		}else {
			return "Please SignUp First .";
		}
	}

}
