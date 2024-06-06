package com.cart.dto;

import java.util.List;

public class ProductRequestDto {
	
	private List<ProductListDto> products;

	public List<ProductListDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductListDto> products) {
		this.products = products;
	}

}
