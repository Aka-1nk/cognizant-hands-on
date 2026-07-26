package com.cognizant.jwt_auth_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtAuthServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthServiceApplication.class, args);
		LOGGER.info("JWT Authentication Service started successfully on port 8090!");
		LOGGER.info("Authentication endpoint: http://localhost:8090/authenticate");
		LOGGER.info("Example curl command:");
		LOGGER.info("curl -s -u user:pwd http://localhost:8090/authenticate");
	}
}