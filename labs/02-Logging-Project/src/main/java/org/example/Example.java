package org.example;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Example {
    private static final Logger logger = Logger.getLogger(Example.class.getName());

    public static void main(String[] args) {
        // Set logging level
        logger.setLevel(Level.ALL);

        // Startup log
        logger.info("Application startup initiated");

        try {
            // Example logic
            performKeyAction();

        } catch (Exception e) {
            // Log any exceptions
            logger.log(Level.SEVERE, "An exception occurred", e);
        }

        // Indicating the application is shutting down
        logger.info("Application shutdown completed");
    }

    private static void performKeyAction() {
        // Log key action
        logger.info("Key action being performed");

        // Check an important condition
        double randomValue = Math.random();
        logger.info("Generated random value: " + randomValue); // Log the value to understand condition effectiveness

        if (randomValue > 0.5) {
            logger.log(Level.WARNING, "Important condition met: randomValue exceeds threshold (> 0.5)");
            throw new RuntimeException("Simulated error due to important condition breach");
        }

        logger.info("Important condition met: randomValue is within acceptable range (<= 0.5)");

        logger.info("Key action completed successfully");

    }
}
