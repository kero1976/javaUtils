package kero.domain.helpers;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.File;
import kero.TestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
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

  @Nested
  class getAbsoluteFile {
    @Test
    void カレントのファイル() {
      File f = PathHelper.getAbsoluteFile("abc.txt");
      assertThat(f.toString()).endsWith("\\Domain\\src\\test\\work\\abc.txt");
    }

    @Test
    void 親階層のファイル() {
      File f = PathHelper.getAbsoluteFile("../abc.txt");
      assertThat(f.toString()).endsWith("\\Domain\\src\\test\\abc.txt");
    }

    @Test
    void 子階層のファイル() {
      File f = PathHelper.getAbsoluteFile("sub/abc.txt");
      assertThat(f.toString()).endsWith("\\Domain\\src\\test\\work\\sub\\abc.txt");
    }

    @Test
    void 存在しないファイル() {
      File f = PathHelper.getAbsoluteFile("D:\\test\\このフォルダは存在しない\\abc.txt");
      assertThat(f.toString()).isEqualTo("D:\\test\\このフォルダは存在しない\\abc.txt");
    }
  }

  @Nested
  class getCurrentDirName {

    @Test
    void 正常系() {
      String str = PathHelper.getCurrentDirName();
      assertThat(str.toString()).isEqualTo("work");
    }
  }

  @Nested
  class getCurrentDirFullPath {

    @Test
    void 正常系() {
      String str = PathHelper.getCurrentDirFullPath();
      assertThat(str.toString()).endsWith("\\Domain\\src\\test\\work");
    }
  }
}
