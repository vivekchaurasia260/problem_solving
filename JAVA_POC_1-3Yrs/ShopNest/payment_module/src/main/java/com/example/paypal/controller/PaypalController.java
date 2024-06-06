package com.example.paypal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.paypal.config.CouponServiceClient;
import com.example.paypal.model.CompletedOrder;
import com.example.paypal.model.PaymentOrder;
import com.example.paypal.service.PaypalService;

@RestController
@RequestMapping(value = "/paypal")
public class PaypalController {

	@Autowired
	private PaypalService paypalService;

	@Autowired
	private CouponServiceClient couponServiceClient;

	@PostMapping(value = "/init")
	public PaymentOrder createPayment(@RequestParam("sum") Double sum,
									  @RequestParam(value = "coupon", required = false) String couponCode, 
									  @RequestParam("userId") Long userId) {

		if (couponCode != null) {
			double finalAmount = couponServiceClient.applyCoupon(couponCode, sum, userId);
			CompletedOrder completeOrder = new CompletedOrder();
			// PaymentOrder order = paypalService.createPayment(finalAmount);
			// order.setCoupon(couponCode);

			completeOrder.setCoupon(couponCode);
			return paypalService.createPayment(finalAmount, couponCode, userId);

			// if(order.getStatus().equals("success")){
			// couponServiceClient.updateCouponsUsage(couponCode, true);
			// } else {
			// throw new RuntimeException("Payment failed");
			// }
			// return order;
		} else {
			return paypalService.createPayment(sum, "", userId);
		}
	}

	@GetMapping(value = "/capture/{userId}/{coupon}")
	public CompletedOrder completePayment(@PathVariable(required = false) String coupon,
			@RequestParam("token") String token, @PathVariable("userId") Long userId) {
		CompletedOrder completedOrder = new CompletedOrder();
		// coupon = completedOrder.getCoupon();
		return paypalService.completePayment(token, coupon, userId);
	}

	@GetMapping(value = "/capture/{userId}")
	public CompletedOrder completePayment2(@PathVariable(required = false) String coupon,
			@RequestParam("token") String token, @PathVariable Long userId) {
		System.out.println("Coupon is " + coupon);
		CompletedOrder completedOrder = new CompletedOrder();
		// coupon = completedOrder.getCoupon();
		return paypalService.completePayment(token, coupon, userId);
	}

	@GetMapping("/cancel")
	public ResponseEntity<String> handlePayPalCancel() {
		return ResponseEntity.ok("Cancellation");
	}

}
