package kero.domain.log;

import java.lang.management.ManagementFactory;
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class ProcessIdConverter extends ClassicConverter {
  private static final String PROCESS_ID = ManagementFactory.getRuntimeMXBean().getName();

  @Override
  public String convert(final ILoggingEvent event) {
    // for every logging event return processId from mx bean
    // (or better alternative)
    return PROCESS_ID;
  }
}
