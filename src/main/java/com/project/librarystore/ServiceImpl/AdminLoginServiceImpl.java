package com.project.librarystore.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.librarystore.Entities.AdminLogin;
import com.project.librarystore.Repositories.AdminLoginRepository;
import com.project.librarystore.Service.AdminLoginService;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private AdminLoginRepository adminLoginRepository;
	
	@Override
	public String signup(AdminLogin admin) {
		adminLoginRepository.save(admin);
		return "Admins's Account Created.";
	}

	@Override
	public String login(String email, String password) {
		AdminLogin admin = adminLoginRepository.findAdminByEmail(email);
		
		if(admin!=null) {
			
			if(admin.getPassword().equals(password)) {
				return "you are welcome";
			}else {
				return "Password Incorrect";
			}
		}else {
			return "Please SignUp First .";
		}
	}

}
