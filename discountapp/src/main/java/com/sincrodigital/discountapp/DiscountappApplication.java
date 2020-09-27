package com.sincrodigital.discountapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.sincrodigital.controllers", "com.sincrodigital.services", "com.sincrodigital.configurations"} )
public class DiscountappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountappApplication.class, args);
	}

}
