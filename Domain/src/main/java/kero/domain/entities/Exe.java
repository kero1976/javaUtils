package kero.domain.entities;

import java.util.List;

public class Exe {

  private String name;
  private List<String> params;

  public String getName() {
    return name;
  }

  public List<String> getParams() {
    return params;
  }

  /**
   * コンストラクタ.
   *
   * @param name 実行モジュール名
   * @param params 起動パラメータ
   */
  public Exe(String name, List<String> params) {
    super();
    this.name = name;
    this.params = params;
  }

  @Override
  public String toString() {
    return "Exe [name=" + name + ", params=" + params + "]";

  }

}
