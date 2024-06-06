package com.cart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cart.model.PaymentOrder;



@FeignClient(url="http://localhost:8080/paypal",value="payment-module")
public interface ApiClient {
	
	@PostMapping(value = "/init")
	public PaymentOrder createPayment(@RequestParam("sum") Double sum,
									  @RequestParam(value = "coupon", required = false) String couponCode, 
									  @RequestParam("userId") Long userId);
	
	
}