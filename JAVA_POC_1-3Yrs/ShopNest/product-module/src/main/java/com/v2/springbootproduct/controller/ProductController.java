package com.v2.springbootproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.v2.springbootproduct.entity.Product;
import com.v2.springbootproduct.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
    @Autowired
	private ProductService productService;
    
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
    	return productService.addProduct(product);
    }
    
    @GetMapping
    public List<Product> getAllProducts(){
    	return productService.getAllProducts();
    }
    
    @GetMapping("/getid/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
    	Product productById = productService.getProductById(id);
    	return ResponseEntity.ok(productById);
    }
    @GetMapping("/getname/{name}")
    public ResponseEntity<Product> getProductByname(@PathVariable String name){
    	 Product productByName = productService.getProductByName(name);
    	return ResponseEntity.ok(productByName);
    }
    
  @GetMapping("/getcategory/{category}")
  public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category){
   List<Product> productsByCategory = productService.getProductsByCategory(category);
   	return ResponseEntity.ok(productsByCategory);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product updatedProduct){
    	Product updateProduct = productService.updateProduct(id, updatedProduct);
    	return ResponseEntity.ok(updateProduct);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
       productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully!.");
}
}