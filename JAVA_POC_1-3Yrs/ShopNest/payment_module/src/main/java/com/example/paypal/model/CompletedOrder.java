package com.example.paypal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class CompletedOrder {
    private String status;
	@Id
    private String payId;
	private String coupon = "";
	@CreationTimestamp
	private LocalDateTime completedOrderDateTime;
	private Long userId;

    public CompletedOrder(String status) {
        this.status = status;
    }

	public CompletedOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompletedOrder(String status, String payId, String coupon,Long userId) {
		super();
		this.status = status;
		this.payId = payId;
		this.coupon = coupon;
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
    
}
