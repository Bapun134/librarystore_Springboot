package com.project.librarystore.Service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.project.librarystore.Entities.Book;
import com.project.librarystore.Entities.Customer;
import com.project.librarystore.Entities.Cart;

@Service
public interface BookService {
	
	//These are all abstract functions (un-implemented) .
	
	Book createBook(Book bookItem);
	
	List<Book> getAll();
	
	Book findBookById(Long id);
	
	Book updateBook(Long id,Book bookItem);
	
	String deleteBookById(Long id);
	
	String orderProduct(Customer customer);
	
	List<Cart> orderDetails(Long orderno);
}
