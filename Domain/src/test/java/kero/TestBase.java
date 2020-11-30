package kero;

import java.io.File;
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
      System.setProperty("user.dir", "./src/test/work");
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
    log.trace("trace");
    log.debug("debug");
    log.info("info");
    log.error("error");
    try {
      File f = new File(getTestDir() + dir);
      FileUtils.copyDirectory(f, new File("./"));
    } catch (Exception e) {
      log.trace("trace" + e);
      log.debug("debug" + e);
      log.info("info" + e);
      log.error("error" + e);
      throw new TestException();
    }

  }
}
