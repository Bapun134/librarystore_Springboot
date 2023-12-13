package com.project.librarystore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.librarystore.Entities.UserLogin;
import com.project.librarystore.Service.UserLoginService;

@RestController
@RequestMapping("/api")
public class UserLoginController {

	@Autowired
	UserLoginService userLoginService;
	
	
	
	@PostMapping("/signup")
	String userSignup(@RequestBody UserLogin user) {
		return userLoginService.signup(user);
	}
	
	
	@PostMapping("/login/{email}/{password}")
	ResponseEntity<String>  userLogin(@PathVariable String email,@PathVariable String password) {
		
		return ResponseEntity.ok(userLoginService.login(email, password));
	}
	
	
	
	
}
