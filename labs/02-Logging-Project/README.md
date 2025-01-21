# Logging Lab: Enhance Your Banking Application

## Objective
The goal of this lab is to incorporate proper logging into your existing Banking Application project using Java's built-in `java.util.logging` library. Logging helps monitor application behavior, debug issues, and provide insights into application execution.

## Instructions

1. **Set Up Java Logging**  
   No external dependencies are needed for this lab. Java's `java.util.logging` is built-in and ready to use. You can configure it programmatically or with a `logging.properties` file.  

   - Example of basic configuration:
     ```java
     import java.util.logging.Logger;
     import java.util.logging.Level;

     public class Example {
         private static final Logger logger = Logger.getLogger(Example.class.getName());

         public static void main(String[] args) {
             logger.setLevel(Level.ALL); // Set logging level
             logger.info("Application started");
         }
     }
     ```

2. **Identify Logging Points**  
   Add meaningful log messages in your application. Include logs for the following:
   - **Startup**: Log when the application starts.
   - **Key Actions**: Log important events like customer creation, transactions, and loan processing.
   - **Errors and Exceptions**: Log all exceptions with meaningful messages.
   - **Important Conditions**: Log when certain thresholds or conditions are met (e.g., low account balance, loan overdue).

3. **Use Appropriate Logging Levels**  
   Use the correct log level based on the situation:
   - `SEVERE`: For critical errors.
   - `WARNING`: For potential issues or unexpected conditions.
   - `INFO`: For general application progress (e.g., "Transaction successful").
   - `CONFIG`: For configuration details.
   - `FINE`, `FINER`, `FINEST`: For detailed debugging.

