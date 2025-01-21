package my.bank;

import my.bank.utils.LoggerFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Starting the Banking Management System...");

        try {
            ConsoleApplication application = new ConsoleApplication();
            application.run();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error occurred during application run", e);
        } finally {
            logger.info("Shutting down the Banking Management System.");
        }
    }
}