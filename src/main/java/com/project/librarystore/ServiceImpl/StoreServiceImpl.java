package com.project.librarystore.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.librarystore.Repositories.StoreRepository;
import com.project.librarystore.Service.StoreService;
import com.project.librarystore.Entities.Store;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	StoreRepository storeRepository;
	
	@Override
	public Store createStore(Store store) {
		return storeRepository.save(store);
	}

	
	@Override
	public List<Store> getAll() {
		return storeRepository.findAll();
	}

}
