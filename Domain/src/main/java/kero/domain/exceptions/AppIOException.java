package kero.domain.exceptions;

import kero.domain.exceptions.base.AppException;

/**
 * AppIOException
 *
 * @author けろ
 *
 */
public class AppIOException extends AppException {

  private String msg;
  private Exception exception;

  public AppIOException(String msg) {
    this(msg, null);
  }

  public AppIOException(String msg, Exception e) {
    this.msg = msg;
    this.exception = e;
  }

  @Override
  protected Exception getOriginalException() {
    return exception;
  }

  @Override
  protected String getOptionMessage() {
    // TODO 自動生成されたメソッド・スタブ
    return msg;
  }

  @Override
  public String getUserMessage() {
    // TODO 自動生成されたメソッド・スタブ
    return msg;
  }
}
