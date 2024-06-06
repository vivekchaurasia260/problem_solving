package com.cart.dto;


public class CartRequestDto {
	
	//private Integer cartItemId;

	private Integer quantity;

	private Double totalCost;

	private ProductListDto products;

//	public Integer getCartItemId() {
//		return cartItemId;
//	}
//
//	public void setCartItemId(Integer cartItemId) {
//		this.cartItemId = cartItemId;
//	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public ProductListDto getProducts() {
		return products;
	}

	public void setProducts(ProductListDto products) {
		this.products = products;
	}
	

}
