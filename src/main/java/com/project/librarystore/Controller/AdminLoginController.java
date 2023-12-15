package com.project.librarystore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.librarystore.Entities.AdminLogin;
import com.project.librarystore.Entities.UserLogin;
import com.project.librarystore.Service.AdminLoginService;

@RestController
@RequestMapping("/api/admin")
public class AdminLoginController {

	@Autowired
	private AdminLoginService adminLoginService;
	
	
	
	@PostMapping("/signup")
	String adminSignup(@RequestBody AdminLogin admin) {
		return adminLoginService.signup(admin);
	}
	
	
	@PostMapping("/login/{email}/{password}")
	ResponseEntity<String> adminLogin(@PathVariable String email,@PathVariable String password) {
		
		return ResponseEntity.ok(adminLoginService.login(email, password));
	}
	
	
	
	
	
	
}


