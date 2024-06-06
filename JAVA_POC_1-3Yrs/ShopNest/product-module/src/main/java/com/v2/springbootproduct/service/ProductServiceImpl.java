package com.v2.springbootproduct.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.v2.springbootproduct.entity.Product;
import com.v2.springbootproduct.exception.ResourceNotFoundException;

import com.v2.springbootproduct.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		Product getProduct = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		return getProduct;
	}

	@Override
	public Product updateProduct(Long id, Product updatedProduct) {
		Product updateProduct = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		updateProduct.setName(updatedProduct.getName());
		updateProduct.setDescription(updatedProduct.getDescription());
		updateProduct.setPrice(updatedProduct.getPrice());
		updateProduct.setCategory(updatedProduct.getCategory());
		return productRepo.save(updateProduct);

	}

	@Override
	public void deleteProduct(Long id) {
		productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		productRepo.deleteById(id);
	}

	@Override
	public Product getProductByName(String name) {
		Optional<Product> productOptional = productRepo.findByName(name);
		Product products = productOptional.orElseThrow(() -> new NoSuchElementException("Product not found"));
		return products;
	}

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		List<Product> findByCategory = productRepo.findByCategory(category);
		return findByCategory;
	}

	@Override
	public Page<Product> searchProduct(String search, Pageable pageable) {
		return productRepo.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrCategoryContainingIgnoreCase(search, search, search, pageable);
	}

}
