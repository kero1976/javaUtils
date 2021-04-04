package kero.domain.exceptions;

import kero.domain.exceptions.base.AppException;

public class AppIllegalArgumentException extends AppException {

  private String msg;
  private Exception exception;

  public AppIllegalArgumentException(String msg) {
    this(msg, null);
  }

  public AppIllegalArgumentException(String msg, Exception e) {
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
