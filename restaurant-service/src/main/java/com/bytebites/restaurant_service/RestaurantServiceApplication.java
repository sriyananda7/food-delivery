package com.bytebites.restaurant_service;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantServiceApplication {

	public static void main(String[] args) {
	    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));

		SpringApplication.run(RestaurantServiceApplication.class, args);
	}

}
