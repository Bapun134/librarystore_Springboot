package com.project.librarystore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.librarystore.Service.StoreService;
import com.project.librarystore.Entities.Store;

@RestController
@RequestMapping("api/store")
public class StoreController {

	@Autowired
	StoreService storeservice;
	
	
	@PostMapping("/create")
	public Store createStore(@RequestBody Store store)
	{
		return storeservice.createStore(store);
	}
	
	
	@GetMapping("/show")
	public List<Store> getAll()
	{
		return storeservice.getAll();
	}
	

}
