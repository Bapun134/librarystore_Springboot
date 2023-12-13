package com.project.librarystore.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.librarystore.Entities.Customer;
import com.project.librarystore.Repositories.CustomerRepository;
import com.project.librarystore.Service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

}