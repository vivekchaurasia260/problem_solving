package com.v2.springbootproduct.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.v2.springbootproduct.entity.Product;

public interface ProductService {
    public Product addProduct(Product product);

    public List<Product> getAllProducts();

    public Product getProductById(Long id);

    public Product getProductByName(String name);

    public Product updateProduct(Long id, Product updatedProduct);

    public void deleteProduct(Long id);

    public List<Product> getProductsByCategory(String category);

    public Page<Product> searchProduct(String search, Pageable pageable);
}
