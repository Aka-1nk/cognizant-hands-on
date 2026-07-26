package com.cognizant.jwt_auth_service.service;

import java.util.ArrayList;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    /**
     * Hardcoded user for demonstration.
     * In production, this would fetch from database.
     */
    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "pwd";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("START: loadUserByUsername() method called for username: {}", username);

        if (!VALID_USERNAME.equals(username)) {
            LOGGER.warn("User not found: {}", username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        LOGGER.info("END: loadUserByUsername() method - User found: {}", username);
        return new User(VALID_USERNAME, VALID_PASSWORD, new ArrayList<>());
    }

    /**
     * Validate user credentials from Basic Auth header.
     */
    public boolean validateCredentials(String username, String password) {
        LOGGER.debug("Validating credentials for username: {}", username);
        boolean isValid = VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
        LOGGER.debug("Credentials validation result: {}", isValid);
        return isValid;
    }

    /**
     * Decode Basic Auth header to extract username and password.
     */
    public String[] decodeBasicAuth(String authHeader) {
        LOGGER.debug("Decoding Basic Auth header");

        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String decodedString = new String(decodedBytes);
            String[] credentials = decodedString.split(":", 2);

            LOGGER.debug("Decoded username: {}", credentials[0]);
            return credentials;
        }

        LOGGER.warn("Invalid Basic Auth header");
        return null;
    }
}