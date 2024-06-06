package com.example.paypal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.paypal.model.CompletedOrder;

public interface PaymentRepository extends JpaRepository<CompletedOrder, String>{

    public CompletedOrder findByPayId(String payId);
    
}
