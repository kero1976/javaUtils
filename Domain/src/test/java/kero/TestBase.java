package kero;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import kero.domain.helpers.PathHelper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
  /**
   * 作業フォルダのセット
   *
   */
  static void setWorkDir() {
    log.debug("作業フォルダのセット.現在の値：{}", PathHelper.getCurrentDirName());
    if (!PathHelper.getCurrentDirName().equals("work")) {
      Path p = Paths.get("./src/test/work");
      System.setProperty("user.dir", p.toAbsolutePath().toString());
      log.debug("作業フォルダを変更.変更後の値：{}", PathHelper.getCurrentDirName());
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
      File f = PathHelper.getAbsoluteFile(getTestDir() + dir);

      FileUtils.copyDirectory(f, new File("./"));
      log.debug("END");
    } catch (Exception e) {

      log.error("error" + e);
      throw new TestException();
    }

  }
}
