package com.cognizant.spring_rest_country.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_rest_country.model.Country;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    private static List<Country> countryList;

    /**
     * Method to get all countries from XML configuration.
     * Uses lazy initialization to load only once.
     */
    private List<Country> getAllCountries() {
        LOGGER.debug("START: getAllCountries() method called");

        if (countryList == null) {
            LOGGER.debug("Loading countries from XML for the first time");
            countryList = new ArrayList<>();

            ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

            // Get all country beans from XML
            countryList.add((Country) context.getBean("countryIN"));
            countryList.add((Country) context.getBean("countryUS"));
            countryList.add((Country) context.getBean("countryDE"));
            countryList.add((Country) context.getBean("countryJP"));
            countryList.add((Country) context.getBean("countryGB"));
            countryList.add((Country) context.getBean("countryFR"));
            countryList.add((Country) context.getBean("countryAU"));
            countryList.add((Country) context.getBean("countryCA"));
            countryList.add((Country) context.getBean("countryBR"));
            countryList.add((Country) context.getBean("countryCN"));
        }

        LOGGER.debug("END: getAllCountries() method returning {} countries", countryList.size());
        return countryList;
    }

    /**
     * Method to get a country by its code (case-insensitive).
     */
    public Country getCountry(String countryCode) {
        LOGGER.info("START: getCountry() method called with countryCode: {}", countryCode);

        // Get all countries
        List<Country> countries = getAllCountries();

        // Method 1: Using Lambda expression to find the country
        Country foundCountry = countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(countryCode))
                .findFirst()
                .orElse(null);

        // Log the result
        if (foundCountry != null) {
            LOGGER.info("END: getCountry() method returning: {}", foundCountry.toString());
        } else {
            LOGGER.warn("END: getCountry() method - Country with code '{}' not found", countryCode);
        }

        return foundCountry;
    }
}