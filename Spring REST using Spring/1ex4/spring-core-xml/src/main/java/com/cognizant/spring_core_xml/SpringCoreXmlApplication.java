package com.cognizant.spring.core.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.core.xml.model.Country;

@SpringBootApplication
public class SpringCoreXmlApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringCoreXmlApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreXmlApplication.class, args);
        LOGGER.info("Inside main method - SpringCoreXmlApplication started successfully!");
        displayCountry();
    }

    private static void displayCountry() {
        LOGGER.info("Starting displayCountry() method");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
        LOGGER.info("Ending displayCountry() method");
    }
}