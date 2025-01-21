package org.dcistudent;

import java.time.ZonedDateTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomLogger extends Formatter {
  @Override
  public String format(LogRecord logRecord) {
    return String.format("%s-%s: %s%n", logRecord.getLevel(), ZonedDateTime.now(), logRecord.getMessage());
  }
}
