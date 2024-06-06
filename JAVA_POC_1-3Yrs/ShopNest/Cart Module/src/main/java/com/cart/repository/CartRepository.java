package com.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	List<Cart> findByUserId(Long userId);

}
