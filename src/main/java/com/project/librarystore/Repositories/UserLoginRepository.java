package com.project.librarystore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.librarystore.Entities.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin,Long> {
	
	UserLogin findUserByEmail(String email);
	
}
