package kero;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import kero.domain.helpers.PathHelper;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
  private static Logger log = LoggerFactory.getLogger(TestBase.class);
  private static final String TEST_FILE_BASE_DIR = "../resources/テストデータ/";

  @BeforeAll
  static void setWorkDir() {
    if (PathHelper.getCurrentDirName() != "work") {
      Path p = Paths.get("./src/test/work");
      System.setProperty("user.dir", p.toAbsolutePath().toString());
    }
  }

  @BeforeEach
  void setUp() throws Exception {
    File workDir = new File("../work");


  }

  protected abstract String setTestDir();

  private String getTestDir() {
    return TEST_FILE_BASE_DIR + setTestDir() + "/";
  }

  protected void copy(String dir) throws TestException {

    log.debug("debug");

    try {
      File f = new File(getTestDir() + dir);

      FileUtils.copyDirectory(f.getAbsoluteFile(), new File("./"));
      log.debug("END");
    } catch (Exception e) {

      log.error("error" + e);
      throw new TestException();
    }

  }
}
