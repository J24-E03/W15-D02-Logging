package org.dci;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public String format(LogRecord record) {
        LocalDateTime localDateTime = Instant.ofEpochMilli(record.getMillis())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        return "Time: " + localDateTime.format(formatter)
                + ", Level: " + record.getLevel()
                + ", Message: " + record.getMessage() + "\n";
    }
}
