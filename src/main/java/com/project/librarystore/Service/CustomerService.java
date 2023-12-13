package com.project.librarystore.Service;

import org.springframework.stereotype.Service;

import com.project.librarystore.Entities.Customer;

@Service
public interface CustomerService {
	
	Customer createCustomer(Customer customer);

}
