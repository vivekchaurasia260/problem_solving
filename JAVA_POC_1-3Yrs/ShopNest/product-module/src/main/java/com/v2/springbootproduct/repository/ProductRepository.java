package com.v2.springbootproduct.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.v2.springbootproduct.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByName(String name);
    List<Product> findByCategory(String category);
    Page<Product> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrCategoryContainingIgnoreCase(
            String search, String search2, String search3, Pageable pageable);
}
