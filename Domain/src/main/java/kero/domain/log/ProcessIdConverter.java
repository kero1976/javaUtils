package kero.domain.log;


import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import java.lang.management.ManagementFactory;

public class ProcessIdConverter extends ClassicConverter {
  private static final String PROCESS_ID = ManagementFactory.getRuntimeMXBean().getName();

  @Override
  public String convert(final ILoggingEvent event) {
    return PROCESS_ID;
  }
}
