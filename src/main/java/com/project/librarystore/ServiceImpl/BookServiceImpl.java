package com.project.librarystore.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.librarystore.Entities.Book;
import com.project.librarystore.Entities.BookException;
import com.project.librarystore.Entities.Cart;
import com.project.librarystore.Entities.Customer;
import com.project.librarystore.Repositories.BookRepository;
import com.project.librarystore.Repositories.CartRepository;
import com.project.librarystore.Repositories.CustomerRepository;
import com.project.librarystore.Repositories.StoreRepository;
import com.project.librarystore.Service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired 
	CustomerRepository customerRepository;
	
	@Override
	public Book createBook(Book bookItem) {
		
		return bookRepository.save(bookItem);
		
	}

	@Override
	public List<Book> getAll() {
		
		return bookRepository.findAll();
	}

	@Override
	public Book findBookById(Long id) {

		return bookRepository.findById(id).get();
	}

	@Override
	public Book updateBook(Long id, Book bookItem) {
		
		Book b =bookRepository.findById(id).get();
		b.setBookName(bookItem.getBookName());
		b.setAuthorName(bookItem.getAuthorName());
		b.setStk(bookItem.getStk());
		b.setPrice(bookItem.getPrice());
		
		return bookRepository.save(b);
	}

	@Override
	public String deleteBookById(Long id) {
		
		Optional<Book> b =bookRepository.findById(id);
		
		if(b.isPresent()) {
			Book book = b.get();
	        bookRepository.delete(book);
	        return "Book Deleted";
		}
		else {
			return "Book not found with ID: " + id;
		}
		
	}

	
	@Override
	public String orderProduct(Customer customer) {
		List<Cart> cart=customer.getCart();
		Double sum=0.00;
		
		for(Cart i:cart)
		{
			Book p=bookRepository.findById(i.getBookId()).get();
		
			try
			{
				if(i.getQty()>p.getStk())
					throw new BookException("Out of stock");
			}
			catch(BookException e)
			{
				return p.getBookName()+" is "+e.getMessage();
			}
			
			i.setTotal(i.getQty()*p.getPrice());
			i.setOrderno(customer);
		
			cartRepository.save(i);
			sum=sum+i.getTotal();  
			p.setStk(p.getStk()-i.getQty());
			bookRepository.save(p);
		
		}

		
		customer.setTotalPrice(sum);
		customerRepository.save(customer);
	
		return "your order has been placed successfully";
		
	}
	
	
	@Override
	public List<Cart> orderDetails(Long orderno)
	{
		Customer customer=customerRepository.findById(orderno).get();
		List<Cart> cart=customer.getCart();		
		return cart;
	}

}
