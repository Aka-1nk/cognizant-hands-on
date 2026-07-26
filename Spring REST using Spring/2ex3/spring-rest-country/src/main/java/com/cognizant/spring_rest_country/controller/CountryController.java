package com.cognizant.spring_rest_country.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_rest_country.model.Country;
import com.cognizant.spring_rest_country.service.CountryService;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    /**
     * REST endpoint to get a country by its code.
     * The country code is case-insensitive.
     * Example: GET /country/in  returns India
     *          GET /country/US  returns United States
     */
    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START: getCountry() controller method called with code: {}", code);

        // Call service method to get country
        Country country = countryService.getCountry(code);

        LOGGER.info("END: getCountry() controller method returning: {}",
                country != null ? country.toString() : "null");

        return country;
    }
}