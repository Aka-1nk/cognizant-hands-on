package com.cognizant.spring_rest_country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestCountryApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestCountryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringRestCountryApplication.class, args);
		LOGGER.info("SpringRestCountryApplication started successfully on port 8083!");
		LOGGER.info("Access the Country REST service at: http://localhost:8083/country/{code}");
		LOGGER.info("Examples:");
		LOGGER.info("  http://localhost:8083/country/in");
		LOGGER.info("  http://localhost:8083/country/US");
		LOGGER.info("  http://localhost:8083/country/jp");
	}
}