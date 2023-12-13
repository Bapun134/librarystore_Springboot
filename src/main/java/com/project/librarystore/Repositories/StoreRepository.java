package com.project.librarystore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.librarystore.Entities.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
