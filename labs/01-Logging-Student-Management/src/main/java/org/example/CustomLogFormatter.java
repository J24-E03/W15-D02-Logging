package org.example;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

class CustomLogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return String.format(
                "[%1$tF %1$tT] [%2$s] [%3$s] %4$s %n",
                new java.util.Date(record.getMillis()), // Timestamp
                record.getLevel(),                     // Log Level
                record.getLoggerName(),                // Logger Name
                record.getMessage()                    // Log Message
        );
    }
}
