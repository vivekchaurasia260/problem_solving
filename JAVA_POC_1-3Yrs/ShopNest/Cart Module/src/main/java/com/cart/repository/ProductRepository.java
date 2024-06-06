package com.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
