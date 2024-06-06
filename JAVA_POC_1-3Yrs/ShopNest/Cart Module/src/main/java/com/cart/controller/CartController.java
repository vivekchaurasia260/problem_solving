package com.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cart.dto.AddToCartDto;
import com.cart.model.Cart;
import com.cart.model.PaymentOrder;
import com.cart.service.CartService;



@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;

	@GetMapping("/test")
	public String test() {
		return "Application running successfully";

	}

	@PostMapping("/addProduct")
	public String addItemToCart(@RequestBody AddToCartDto addToCartDto) {
		  String addItemToCart = cartService.addItemToCart(addToCartDto);

		return addItemToCart;

	}

	@DeleteMapping("/delete/{cartItemId}")
	public String deleteItemsByCartId(@PathVariable Integer cartItemId) {
		return cartService.deleteItemsByCartId(cartItemId);

	}

	@PutMapping("/updateProduct/{cartItemId}")
	public Cart updateItemInCart(@PathVariable Integer cartItemId, @RequestBody AddToCartDto AddToCartDto) {
		return cartService.updateItemInCart(cartItemId, AddToCartDto);

	}
	
	@GetMapping("/getcart")
	public List<Cart> getAllCartItems(){
	List<Cart> allCartItems = cartService.getAllCartItems();
		
		return allCartItems;
	}
	
//	@GetMapping("/CartPayment/{cartItemId}") 
//	 public PaymentOrder getCartItemsById(@PathVariable Integer cartItemId,@RequestParam(required = false) String cuponCode ) {
//		  PaymentOrder cartItemsById = cartService.getCartItemsById(cartItemId,cuponCode);
//		 return cartItemsById;
//	}	
	
	 @GetMapping("/getcartCost/{cartItemId}") 	 
	 public Double getCartTotalCost(@PathVariable Integer cartItemId) {
		return cartService.getCartTotalCost(cartItemId) ;
			 
	}
	 
	 @GetMapping("/usercartCost/{userId}") 
	 public Double getCartTotalCostByUserId(@PathVariable Long userId) {
		 Double cartTotalCost = cartService.getCartTotalCost(userId);
		return cartTotalCost;
		 
	 }
	 
	 	 @GetMapping("/CartPaymentByUser/{userId}") 
	 public PaymentOrder CartPaymentByUser(@PathVariable Long userId,@RequestParam(required = false) String cuponCode ) {
		    PaymentOrder cartPayment = cartService.cartPayment(userId, cuponCode);
		 return cartPayment;
	}	
	 
 
	 
}
