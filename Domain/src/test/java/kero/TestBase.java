package kero;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;

/**
 * テスト用基本クラス.
 *
 * <p>
 * テストクラスを作成する場合は、本クラスを実装または本クラスを拡張したクラスを実装してください. テストの作業フォルダは「src/test/work」フォルダ固定とします.
 * テスト用のデータは「src/test/resources/テストデータ」以下のフォルダとします。
 * </p>
 *
 * @author kero
 *
 */
public abstract class TestBase {
  private static final String TEST_FILE_BASE_DIR = "../src/test/resources/テストデータ/";

  @BeforeEach
  void setUp() throws Exception {
    File workDir = new File("../work");
    // FileUtils.cleanDirectory(workDir);
  }

  protected abstract String setTestDir();

  private String getTestDir() {
    return TEST_FILE_BASE_DIR + setTestDir() + "/";
  }

  protected void copy(String dir) throws TestException {
    try {
      File f = new File(getTestDir() + dir);
      FileUtils.copyDirectory(f, new File("./"));
    } catch (Exception e) {
      throw new TestException();
    }

  }
}
