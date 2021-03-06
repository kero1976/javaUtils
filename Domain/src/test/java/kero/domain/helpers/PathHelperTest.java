package kero.domain.helpers;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import kero.TestBase;
import kero.domain.exceptions.AppIllegalArgumentException;
import kero.domain.exceptions.base.AppException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    void カレントのファイル() throws AppIllegalArgumentException {
      File f = PathHelper.getAbsoluteFile("abc.txt");
      assertThat(f.toString()).endsWith("\\Domain\\src\\test\\work\\abc.txt");
    }

    @Test
    void 親階層のファイル() throws AppIllegalArgumentException {
      File f = PathHelper.getAbsoluteFile("../abc.txt");
      assertThat(f.toString()).endsWith("\\Domain\\src\\test\\abc.txt");
    }

    @Test
    void 子階層のファイル() throws AppIllegalArgumentException {
      File f = PathHelper.getAbsoluteFile("sub/abc.txt");
      assertThat(f.toString()).endsWith("\\Domain\\src\\test\\work\\sub\\abc.txt");
    }

    @Test
    void 存在しないファイル() throws AppIllegalArgumentException {
      File f = PathHelper.getAbsoluteFile("D:\\test\\このフォルダは存在しない\\abc.txt");
      assertThat(f.toString()).isEqualTo("D:\\test\\このフォルダは存在しない\\abc.txt");
    }

    @Test
    void 例外_null() throws AppIllegalArgumentException {
      AppException e = assertThrows(AppException.class, () -> PathHelper.getAbsoluteFile(null));
      assertEquals("PathHelper.toAbsoluteメソッドでエラー。path:null", e.getUserMessage());
    }
  }

  @Nested
  class getCurrentDirName {

    @Test
    void 正常系() {
      String str = PathHelper.getCurrentDirName();
      log.debug("作業フォルダのフォルダ名を取得する:{}", str);
      assertThat(str.toString()).isEqualTo("work");
    }
  }

  @Nested
  class getCurrentDirFullPath {

    @Test
    void 正常系() {
      String str = PathHelper.getCurrentDirFullPath();
      log.debug("作業フォルダのFullPathを取得する:{}", str);
      assertThat(str.toString()).endsWith("\\Domain\\src\\test\\work");
    }
  }
}
