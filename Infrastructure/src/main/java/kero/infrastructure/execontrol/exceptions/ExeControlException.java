package kero.infrastructure.execontrol.exceptions;

import kero.domain.exceptions.base.AppException;

public class ExeControlException extends AppException {

  private String msg;

  public ExeControlException(String string) {
    this.msg = string;
  }

  @Override
  protected Exception getOriginalException() {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }

  @Override
  protected String getOptionMessage() {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }

  @Override
  public String getUserMessage() {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }

}
