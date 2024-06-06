package com.v2.coupons_module.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.v2.coupons_module.entity.CouponsEntity;
import com.v2.coupons_module.repository.CouponsRepository;
import com.v2.coupons_module.service.CouponsService;

@Service
public class CouponsServiceImplementation implements CouponsService {

	@Autowired
	private CouponsRepository couponsRepo;


	@Override
	public CouponsEntity createCoupon(CouponsEntity coupon) {
		Optional<CouponsEntity> existingCoupon = couponsRepo.findByCouponCode(coupon.getCouponCode());
		if (existingCoupon.isPresent()){
			throw new IllegalArgumentException("Coupon code already exists with code: " + existingCoupon.get().getCouponCode());
		}
		return couponsRepo.save(coupon);
	}

	// @Override
	// public CouponsEntity getCouponById(Long couponId) {
	// 	return couponsRepo.findById(couponId).get();
	// }

	@Override
	public List<CouponsEntity> getCouponByUserId(Long userId) {
		return couponsRepo.findByUserId(userId);
	}

	@Override
	public boolean validateCoupon(String couponCode, Double totalAmount, Long userId) {
		/**
		 * 1. If coupon exists in the DB
		 * 2. if coupon has been used or not
		 * 3. if coupon is in the validity period
		 * 4. applicable on cart amount
		 * 5. Correct User is applying the coupon
		 */
		Optional<CouponsEntity> optionalCoupon = couponsRepo.findByCouponCode(couponCode);
		if (!optionalCoupon.isPresent()) {
			return false; // coupon not present
		}

		CouponsEntity coupon = optionalCoupon.get();

		if (coupon.isUsed()) {
			return false;
		}

		LocalDateTime currentDate = LocalDateTime.now();
		if (currentDate.isAfter(coupon.getValidTill())) {
			return false; // Coupon is expired
		}

		double discountAmount = totalAmount * (1 - (coupon.getDiscount() / 100));
		if (totalAmount < discountAmount) {
			return false; // Total amount is less than the discount amount
		}

		if (userId != 0){
			if (userId != coupon.getUserId()){
				return false;
			} 
		}
		// if (discountAmount<500) {
		// return false; // discountAmount is less than 500
		// }

		// coupon.setUsed(true);
		// couponsRepo.save(coupon);

		return true;
	}

	@Override
	public double applyCoupon(String couponCode, Double totalAmount, Long userId) {
		// if (validateCoupon(couponCode, totalAmount) == true) {
		// return true;
		// }else {
		// return false;
		// }
		if (validateCoupon(couponCode, totalAmount, userId) == true) {
			return finalCartAmount(couponCode, totalAmount);
		} else {
			return totalAmount;
		}

	}

	@Override
	public double finalCartAmount(String couponCode, Double totalAmount) {
		Optional<CouponsEntity> optionalCoupon = couponsRepo.findByCouponCode(couponCode);
		CouponsEntity coupon = optionalCoupon.get();
		Double discountedAmount = totalAmount * (1 - (coupon.getDiscount() / 100));
		return discountedAmount;

	}

	@Override
	public void updateCouponsUsage(String couponCode, boolean isUsed) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateCouponsUsage'");
	}

	@Override
	public String updateCouponByCode(String couponCode, Boolean isUsed) {
		Optional<CouponsEntity> optionalCoupon = couponsRepo.findByCouponCode(couponCode);
		if (optionalCoupon.isPresent()){
			CouponsEntity coupon = optionalCoupon.get();
			coupon.setUsed(isUsed);
			couponsRepo.save(coupon);
			return "Updated Succesfully";
		} else {
			throw new NoSuchElementException("Coupon not found");
		}
	}

	// @Override
	// public Optional<CouponsEntity> updateCouponById(String couponId, Boolean isUsed) {
	// 	Optional<CouponsEntity> optionalCoupon = couponsRepo.findById(couponId).get();
	// 	if (optionalCoupon.isPresent()) {
	// 		CouponsEntity coupon = optionalCoupon.get();
	// 		coupon.setUsed(isUsed);
	// 		couponsRepo.save(coupon);
	// 	} else {
	// 		// Handle the case when the coupon is not found
	// 		throw new NoSuchElementException("Coupon not found");
	// 	}
	// }

	//Auto deletes coupon post expiry
	@Scheduled(cron = "0 40 14 * * ?") 
	public void checkCouponValidity() {
		List<CouponsEntity> expiredCoupons = couponsRepo.findByValidTillBeforeAndIsUsedFalse(LocalDateTime.now());
		for (CouponsEntity coupon : expiredCoupons) {
			coupon.setUsed(true);
			couponsRepo.save(coupon);
		}
	}
}
