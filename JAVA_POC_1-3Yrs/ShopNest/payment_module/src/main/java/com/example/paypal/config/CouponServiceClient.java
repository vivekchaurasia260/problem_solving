package com.example.paypal.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "couponService", url = "http://localhost:8081/api/coupons")  //, value = "coupons_module"
public interface CouponServiceClient {

    @GetMapping("/apply")
    double applyCoupon(@RequestParam String couponCode, @RequestParam Double totalAmount, @RequestParam Long userId);

    @PutMapping("/update/{code}")
    public String updateCouponByCode(@PathVariable("code") String couponCode, @RequestBody boolean isUsed);

    @GetMapping("/finalamount")
    public double finalCartAmount(@RequestParam String couponCode, @RequestParam Double totalAmount);
}
