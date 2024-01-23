package com.project.librarystore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.librarystore.Entities.UserLogin;
import com.project.librarystore.Service.UserLoginService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserLoginController {

	@Autowired
	UserLoginService userLoginService;
	
	
	//signup
	
	@PostMapping("/signup")
	String userSignup(@RequestBody UserLogin user) {
		return userLoginService.signup(user);
	}
	
	
	//login
	
	@PostMapping("/login")
	ResponseEntity<String> userLogin(@RequestBody UserLogin user) {
	    String email = user.getEmail();
	    String password = user.getPassword();
	    return ResponseEntity.ok(userLoginService.login(email, password));
	}
	
	
	
	
}
