package com.cart.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cart.dto.AddToCartDto;
import com.cart.model.Cart;
import com.cart.model.PaymentOrder;
import com.cart.model.Product;
import com.cart.repository.CartRepository;
import com.cart.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ApiClient apiClient;
	
	@Value("${url}")
	private String url;

	@Override
	public String addItemToCart(AddToCartDto addToCartDto) {
		ResponseEntity<Product> forEntity = restTemplate
				.getForEntity(url + addToCartDto.getId(), Product.class);
		Product product = forEntity.getBody();
		
		System.out.println(addToCartDto.getId());

		Cart cart = new Cart();
		cart.setQuantity(addToCartDto.getQuantity());
		cart.setUserId(addToCartDto.getUserId());
		Double totalCost = 0d;
		totalCost = addToCartDto.getQuantity() * product.getPrice();
		cart.setTotalCost(totalCost);
		cart.setProduct(product);

		Cart save = cartRepository.save(cart);
		return "Product added successfully to cart";

	}

	@Override
	public String deleteItemsByCartId(Integer cartItemId) {
		cartRepository.deleteById(cartItemId);

		return "Items are deleted sucessfully";
	}

	@Override
	public Cart updateItemInCart(Integer cartItemId, AddToCartDto addToCartDto) {
		Optional<Cart> findById = cartRepository.findById(cartItemId);
		Cart cartItem = findById.get();
		ResponseEntity<Product> forEntity = restTemplate
				.getForEntity(url + addToCartDto.getId(), Product.class);
		Product product = forEntity.getBody();

		cartItem.setQuantity(addToCartDto.getQuantity());
		cartItem.setTotalCost(addToCartDto.getQuantity() * product.getPrice());

		Cart save = cartRepository.save(cartItem);
		return save;
	}

	@Override
	public List<Cart> getAllCartItems() {
		List<Cart> CartList = cartRepository.findAll();
		return CartList;
	}

	@Override
	public PaymentOrder getCartItemsById(Integer cartItemId,String cuponCode) {
		Optional<Cart> findById = cartRepository.findById(cartItemId);
		Cart cart = findById.get();
			Double totalCost = cart.getTotalCost();
			Long userId = cart.getUserId();
			PaymentOrder createPayment = apiClient.createPayment(totalCost,cuponCode,userId);

	        return createPayment;
		
	}
	
	
	public Double getCartTotalCost(Integer cartItemId) {
		Optional<Cart> findById = cartRepository.findById(cartItemId);
		Cart cart = findById.get();
		return cart.getTotalCost();
	
	}
		
	
	@Override
	public Double getCartTotalCost(Long userId) {
		Double cost=0d;
		List<Cart> userCartItems = cartRepository.findByUserId(userId);
		for(Cart c: userCartItems) {
			double totalCost = c.getTotalCost();
			cost=cost+totalCost;
			
			
		}
	return cost;

	}
	
	public PaymentOrder cartPayment(Long userId,String cuponCode) {
		
		Double cost=0d;
		cartRepository.findByUserId(userId);
		List<Cart> userCartItems = cartRepository.findByUserId(userId);
		for(Cart c: userCartItems) {
			double totalCost = c.getTotalCost();
			cost=cost+totalCost;

	}
		PaymentOrder createPayment = apiClient.createPayment(cost,cuponCode,userId);
		 return createPayment;
		
}

	
	
}
