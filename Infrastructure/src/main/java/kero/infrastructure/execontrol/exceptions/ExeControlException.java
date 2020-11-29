package kero.infrastructure.execontrol.exceptions;

import kero.domain.exceptions.AppException;

public class ExeControlException extends AppException {

  private String msg;

  public ExeControlException(String string) {
    this.msg = string;
  }

}
