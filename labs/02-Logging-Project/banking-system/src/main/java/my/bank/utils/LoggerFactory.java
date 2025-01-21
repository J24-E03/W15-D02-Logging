package my.bank.utils;

import java.io.IOException;
import java.util.logging.*;

public class LoggerFactory {
    private static final String LOG_FILE = "application.log";
    private static final boolean APPEND_TO_LOG = true;
    private static final Level GLOBAL_LOG_LEVEL = Level.ALL;
    private static FileHandler fileHandler;

    static {
        try {
            fileHandler = new FileHandler(LOG_FILE, APPEND_TO_LOG);
            fileHandler.setLevel(GLOBAL_LOG_LEVEL);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            System.err.println("Failed to initialize logger FileHandler: " + e.getMessage());
        }
    }

    public static Logger getLogger(String className) {
        Logger logger = Logger.getLogger(className);
        logger.setLevel(GLOBAL_LOG_LEVEL);

        if (fileHandler != null) {
            logger.addHandler(fileHandler);
        }

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        logger.addHandler(consoleHandler);

        return logger;
    }
}
