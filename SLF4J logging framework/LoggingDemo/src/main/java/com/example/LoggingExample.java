package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    // Create a logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Log error messages
        logger.error("This is an error message");
        logger.error("This is another error message with value: {}", 42);

        // Log warning messages
        logger.warn("This is a warning message");
        logger.warn("Warning: Disk space is running low at {}%", 85);

        // Log info messages (for completeness)
        logger.info("Application started successfully");
        logger.info("User {} logged in", "john_doe");

        // Log debug messages (for completeness)
        logger.debug("This is a debug message - only shown if debug level is enabled");

        // Log trace messages (for completeness)
        logger.trace("This is a trace message - most detailed");

        System.out.println("Logging completed. Check the console output above.");
    }
}