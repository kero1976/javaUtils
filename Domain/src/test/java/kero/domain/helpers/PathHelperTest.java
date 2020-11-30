package kero.domain.helpers;

import kero.TestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PathHelperTest extends TestBase {

  @Test
  void test() {
    Assertions.assertThat(PathHelper.getCurrentDirName()).isEqualTo("work");
  }

  @Override
  protected String setTestDir() {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }

}
