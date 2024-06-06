package com.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
//@EntityScan(basePackages = "com.example.paypal.model")
public class ShoppingCartModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartModuleApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() 
	{
	 return new RestTemplate();
	}
 
}
