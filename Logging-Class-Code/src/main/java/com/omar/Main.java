package com.omar;


import com.omar.loggingCode.CustomFormatter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class Main {
//    always configure our logger to be static and final
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static Map<String, Boolean> books = new HashMap<>();

    public static void main(String[] args) throws IOException {
        setUpLogger();
        initializeBooks();
        healthCheck();
        borrowBook("Data Science");
    }

    public static void setUpLogger() throws IOException {

//     2 main 3rd party Logging framework:
//        1. Log4j
//        2. Logback
//        3. SFL4J


//        by default the log level is set to Info

        logger.setLevel(Level.ALL);

//        create the console handler and attach it to the logger
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new CustomFormatter());
        logger.addHandler(consoleHandler);

        FileHandler fileHandler = new FileHandler("library.log",true);
        fileHandler.setLevel(Level.WARNING);
        fileHandler.setFormatter(new CustomFormatter());
        logger.addHandler(fileHandler);

//        logger.info("Information Logged in my application");
//        logger.severe("Severe Error in the code out of memory");
//        logger.log(Level.WARNING,"Warning username incorrect");
//
//        logger.config("Configuration settings: ask Maryam");

//        2 fundemental places where we will mostly be logging in java
//            1. console (terminal)
//            2. file
    }

    public static void initializeBooks(){
        books.put("Catcher and the Rye",true);
        books.put("Java Programming",false);
        books.put("Harry Potter",true);
        books.put("Data Science", false);

        logger.config("Populating database upon boot");
    }

    public static void borrowBook(String bookName){
        logger.log(Level.FINE,"Attempting to borrow book with name {0}",bookName);

        if(!books.containsKey(bookName)){
            logger.log(Level.SEVERE,"Book is not found in DB {0}", bookName);
            return;
        }

        if(!books.get(bookName)){
            logger.log(Level.WARNING,"Book is already borrowed out {0}",bookName);
            return;
        }

        books.put(bookName,false);
        logger.log(Level.INFO, "Successfully Borrowed Book {0}", bookName);
    }

    public static void returnBook (String bookName){
        logger.log(Level.FINE,"Attempting to return book with name {0}",bookName);

        if(!books.containsKey(bookName)){
            logger.log(Level.SEVERE,"Book was not found in DB {0}", bookName);
            return;
        }
        if(books.get(bookName)){
            logger.log(Level.WARNING,"Book is not checked out out {0}",bookName);
        }
        else{
            books.put(bookName,true);
            logger.log(Level.FINE,"Book has been returned {0}", bookName);
        }

    }

    public static void healthCheck(){
        logger.log(Level.FINE, "Performing Health Check");

        if(books.isEmpty()){
            logger.log(Level.SEVERE,"Library is empty! No books found severe issue");
        }
        else{
            logger.log(Level.INFO, "Library has books and is in good health, number of books available: {0}",books.size());
        }
    }

//    custom formatter




//    borrowing a book
//    returning a book
//    check if library is empty (health check)
//    Get all the available books
//    get available book count
//    custom formatting

}

