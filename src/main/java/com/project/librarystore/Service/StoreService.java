package com.project.librarystore.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.librarystore.Entities.Store;

@Service
public interface StoreService {
	
	Store createStore(Store store);
	
	List<Store> getAll();
	
	
	
}
