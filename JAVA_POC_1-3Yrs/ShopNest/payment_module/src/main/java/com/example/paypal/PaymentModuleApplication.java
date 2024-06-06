package com.example.paypal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentModuleApplication.class, args);
	}

}
