package com.project.librarystore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.librarystore.Entities.Book;
import com.project.librarystore.Entities.Cart;
import com.project.librarystore.Entities.Customer;
import com.project.librarystore.Service.BookService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/book") 
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	
	@PostMapping("/create")
	public Book createBook(@RequestBody Book bookItem) {
		
		return bookService.createBook(bookItem);
	}
	
	@GetMapping("/showAllBooks")
	public List<Book> getAllBooks(){
		return bookService.getAll();
	}
	
	@GetMapping("/find/{id}")
	public Book findBook(@PathVariable Long id) {
		
		return bookService.findBookById(id);
	}
	
	@PutMapping("/update/{id}")
	public Book updateBook(@PathVariable Long id,@RequestBody Book bookItem) {
		
		return bookService.updateBook(id, bookItem);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id)
	{
		return bookService.deleteBookById(id);
	}
	
	@PostMapping("/orderbook")
	public String orderProduct(@RequestBody Customer customer)
	{
		return bookService.orderProduct(customer);
	}
	   
	@GetMapping("/displayorder/{orderno}")
	public List<Cart> orderDetails(@PathVariable Long orderno)
	{
		return bookService.orderDetails(orderno);
	}
	
}
