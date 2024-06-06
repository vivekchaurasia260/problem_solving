package com.v2.coupons_module.service;

import java.util.List;
import java.util.Optional;

import com.v2.coupons_module.entity.CouponsEntity;

public interface CouponsService {

	//Create Coupon
	public CouponsEntity createCoupon(CouponsEntity coupon);

	// //get Coupon by id
	// public CouponsEntity getCouponById(Long couponId);

	//get coupons by userId
	public List<CouponsEntity> getCouponByUserId(Long userId);

	
	//Validate Coupon
	public boolean validateCoupon(String couponCode, Double totalAmount, Long userId);

	//Apply Coupon
	public double applyCoupon(String couponCode, Double totalAmount, Long userId);
	
	//Final Cart Amount
	public double finalCartAmount(String couponCode, Double totalAmount);

	//Updating the coupons usage 
	public void updateCouponsUsage(String couponCode, boolean isUsed);

	public String updateCouponByCode(String couponId, Boolean isUsed); 
	
	//Auto-delete coupon after expiry
		
		
	//Delete Coupon after successful payment
}
