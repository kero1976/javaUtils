package kero.domain.exceptions.base;

public class AppIllegalArgumentException extends AppException {

  private String msg;
  private Exception e;

  public AppIllegalArgumentException(String msg) {
    this(msg, null);
  }

  public AppIllegalArgumentException(String msg, Exception e) {
    this.msg = msg;
    this.e = e;
  }

  @Override
  protected Exception getOriginalException() {
    // TODO 自動生成されたメソッド・スタブ
    return e;
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
