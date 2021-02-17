package kero.domain.log;

import java.lang.management.ManagementFactory;
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * logbackのログメッセージにプロセスIDを出力するのに使用する
 *
 * @author けろ
 *
 */
public class ProcessIdConverter extends ClassicConverter {
  private static final String PROCESS_ID = ManagementFactory.getRuntimeMXBean().getName();

  @Override
  public String convert(final ILoggingEvent event) {
    return PROCESS_ID;
  }
}
