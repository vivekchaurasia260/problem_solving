package com.v2.coupons_module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.v2.coupons_module.entity.CouponsEntity;
import com.v2.coupons_module.service.CouponsService;

@RestController
@RequestMapping("/api/coupons")
public class CouponsController {

	@Autowired
	private CouponsService couponService;

	// Create Coupon
	@PostMapping("/createcoupon")
	public CouponsEntity createCoupon(@RequestBody CouponsEntity coupon) {
		return couponService.createCoupon(coupon);
	}

	// Fetch Coupon
	// @GetMapping("/{id}")
	// public CouponsEntity getCouponsById(@PathVariable("id") Long coupondId) {
	// return couponService.getCouponById(coupondId);
	// }

	// Fetch coupons by used id
	@GetMapping("/userid/{id}")
	public List<CouponsEntity> getCouponsByUserId(@PathVariable("id") Long userId) {
		return couponService.getCouponByUserId(userId);
	}

	// Validate the coupon
	@GetMapping("/validate")
	public ResponseEntity<String> validateCoupon(@RequestParam String couponCode, @RequestParam double totalAmount, @RequestParam Long userId) {

		boolean isValid = couponService.validateCoupon(couponCode, totalAmount, userId);

		if (isValid) {
			return ResponseEntity.ok("Coupon is valid");
		} else {
			return ResponseEntity.badRequest().body("Invalid coupon or criteria not met");
		}
	}

	@GetMapping("/apply")
	public ResponseEntity<Double> applyCoupon(@RequestParam String couponCode, @RequestParam Double totalAmount, @RequestParam Long userId) {
		double finalAmount = couponService.applyCoupon(couponCode, totalAmount, userId);
		if (finalAmount != totalAmount) {
			return ResponseEntity.ok(finalAmount);
		} else {
			return ResponseEntity.ok(finalAmount);
		}
	}

	@PutMapping("/update/{code}")
	public String updateCouponByCode(@PathVariable("code") String couponCode,
			@RequestBody Boolean isUsed) {
		return couponService.updateCouponByCode(couponCode, isUsed);
	}

	//API GAteway
}
