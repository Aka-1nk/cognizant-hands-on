package com.cognizant.jwt_auth_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwt_auth_service.model.JwtResponse;
import com.cognizant.jwt_auth_service.service.UserService;
import com.cognizant.jwt_auth_service.utils.JwtUtil;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Authenticate endpoint that receives Basic Auth credentials and returns JWT.
     * Example: curl -s -u user:pwd http://localhost:8090/authenticate
     */
    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START: authenticate() method called");

        // Step 1: Decode the Authorization header
        String[] credentials = userService.decodeBasicAuth(authHeader);

        if (credentials == null || credentials.length != 2) {
            LOGGER.warn("Invalid Authorization header format");
            throw new RuntimeException("Invalid Authorization header");
        }

        String username = credentials[0];
        String password = credentials[1];

        LOGGER.debug("Username: {}, Password: [PROTECTED]", username);

        // Step 2: Validate credentials
        if (!userService.validateCredentials(username, password)) {
            LOGGER.warn("Invalid credentials for username: {}", username);
            throw new RuntimeException("Invalid username or password");
        }

        // Step 3: Generate JWT token
        String token = jwtUtil.generateToken(username);

        LOGGER.info("END: authenticate() method - Token generated successfully for user: {}", username);
        return new JwtResponse(token);
    }
}