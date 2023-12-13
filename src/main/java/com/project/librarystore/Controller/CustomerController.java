package com.project.librarystore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.librarystore.Entities.Customer;
import com.project.librarystore.Service.CustomerService;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired 
	private CustomerService customerService;

	@PostMapping("/create")
	public Customer createCustomer(@RequestBody Customer customer)
	{
		return customerService.createCustomer(customer);
	}
}
