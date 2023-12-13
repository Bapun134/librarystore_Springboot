package com.project.librarystore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.librarystore.Entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
