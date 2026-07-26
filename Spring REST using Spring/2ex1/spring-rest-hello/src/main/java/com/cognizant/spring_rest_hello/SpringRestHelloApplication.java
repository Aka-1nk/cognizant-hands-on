package com.cognizant.spring_rest_hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestHelloApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestHelloApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringRestHelloApplication.class, args);
        LOGGER.info("SpringRestHelloApplication started successfully on port 8083!");
        LOGGER.info("Access the REST service at: http://localhost:8083/hello");
        LOGGER.info("Access the Country REST service at: http://localhost:8083/country");
    }
}