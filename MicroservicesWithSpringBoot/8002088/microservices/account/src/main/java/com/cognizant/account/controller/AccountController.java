package com.cognizant.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.account.model.Account;

@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    /**
     * Get account details based on account number.
     * Sample Response: { "number": "00987987973432", "type": "savings", "balance": 234343 }
     */
    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {
        LOGGER.info("START: getAccount() method called with number: {}", number);

        // Dummy response without any backend connectivity
        Account account = new Account("00987987973432", "savings", 234343);

        LOGGER.info("END: getAccount() method returning: {}", account.toString());
        return account;
    }
}