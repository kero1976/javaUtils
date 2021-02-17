package kero.domain.log;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;

/**
 * logbackのログメッセージにプロセスIDを出力するのに使用する
 *
 * @author けろ
 *
 */
public class ExtendedPatternLayoutEncoder extends PatternLayoutEncoder {
  @Override
  public void start() {
    // put your converter
    PatternLayout.defaultConverterMap.put("process_id", ProcessIdConverter.class.getName());
    super.start();
  }
}
