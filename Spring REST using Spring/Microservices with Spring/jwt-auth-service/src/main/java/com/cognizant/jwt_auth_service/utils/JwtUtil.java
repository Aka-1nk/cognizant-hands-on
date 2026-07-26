package com.cognizant.jwt_auth_service.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * Generate JWT token for the given username.
     */
    public String generateToken(String username) {
        LOGGER.info("START: generateToken() method called for username: {}", username);

        Map<String, Object> claims = new HashMap<>();
        String token = createToken(claims, username);

        LOGGER.info("END: generateToken() method - Token generated successfully");
        return token;
    }

    /**
     * Create JWT token with claims and subject.
     */
    private String createToken(Map<String, Object> claims, String subject) {
        LOGGER.debug("Creating token for subject: {}", subject);

        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignKey())
                .compact();
    }

    /**
     * Get the signing key from secret.
     */
    private SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Extract username from token.
     */
    public String extractUsername(String token) {
        LOGGER.debug("Extracting username from token");
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extract expiration date from token.
     */
    public Date extractExpiration(String token) {
        LOGGER.debug("Extracting expiration from token");
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extract specific claim from token.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extract all claims from token.
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Check if token is expired.
     */
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Validate token for given username.
     */
    public Boolean validateToken(String token, String username) {
        LOGGER.debug("Validating token for username: {}", username);
        final String extractedUsername = extractUsername(token);
        boolean isValid = (extractedUsername.equals(username) && !isTokenExpired(token));
        LOGGER.debug("Token validation result: {}", isValid);
        return isValid;
    }
}