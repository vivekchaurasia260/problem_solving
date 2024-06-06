package com.v2.springbootproduct.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.v2.springbootproduct.entity.Product;
import com.v2.springbootproduct.service.ProductService;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    ProductService productService;
    
    /*
     * Added paging support with default page size as 10 and page number as 0
     */
    @GetMapping
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("search") String search,
                                                        @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                        @RequestParam(value = "size", defaultValue = "10", required = false) int size){
        Pageable pageable = PageRequest.of(page, size);
        System.out.println(pageable);
        Page<Product> searchResults = productService.searchProduct(search, pageable);
        System.out.println(searchResults);
        return ResponseEntity.ok(searchResults.getContent());
    }
}
