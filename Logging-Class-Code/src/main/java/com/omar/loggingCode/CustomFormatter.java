package com.omar.loggingCode;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return "Time: " + record.getMillis() + ", Logging Level: " + record.getLevel() + ", Logger Name: "
                + record.getLoggerName() + ", Message: " + record.getMessage() + "\n";
    }
}
