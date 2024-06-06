package com.cart.service;

import java.util.List;

import com.cart.dto.AddToCartDto;
import com.cart.model.Cart;
import com.cart.model.PaymentOrder;

public interface CartService {
	
	String addItemToCart( AddToCartDto addToCartDto );

	String deleteItemsByCartId(Integer cartItemId);
	
	public Cart updateItemInCart( Integer cartItemId, AddToCartDto addToCartDto);
	
	public List<Cart> getAllCartItems();
    
	public PaymentOrder getCartItemsById(Integer cartItemId,String cuponCode);
	
	public Double getCartTotalCost(Integer cartItemId);

	public Double getCartTotalCost(Long userId);
	 
	public PaymentOrder cartPayment(Long userId,String cuponCode);
	
	
}
