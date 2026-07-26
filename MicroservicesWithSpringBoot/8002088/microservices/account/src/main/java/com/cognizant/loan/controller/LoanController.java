package com.cognizant.loan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loan.model.Loan;

@RestController
public class LoanController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    /**
     * Get loan details based on loan number.
     * Sample Response: { "number": "H00987987972342", "type": "car", "loan": 400000, "emi": 3258, "tenure": 18 }
     */
    @GetMapping("/loans/{number}")
    public Loan getLoan(@PathVariable String number) {
        LOGGER.info("START: getLoan() method called with number: {}", number);

        // Dummy response without any backend connectivity
        Loan loan = new Loan("H00987987972342", "car", 400000, 3258, 18);

        LOGGER.info("END: getLoan() method returning: {}", loan.toString());
        return loan;
    }
}