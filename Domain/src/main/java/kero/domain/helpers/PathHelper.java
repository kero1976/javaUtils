package kero.domain.helpers;

import java.io.File;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public final class PathHelper {

  private static Logger log = LoggerFactory.getLogger(PathHelper.class);

  public static String getCurrentDirName() {
    String path = new File(".").getAbsoluteFile().getParent();
    return path.substring(path.lastIndexOf(File.separatorChar) + 1, path.length());
  }


  /**
   * 指定した文字列の絶対パスのFileクラスを返す.
   *
   * @param dir 相対・絶対のファイルパス
   * @return
   */
  public static File getAbsoluteFile(String dir) {
    log.debug("dir:" + dir);
    File f = new File(dir);
    Path p = f.getAbsoluteFile().toPath().normalize();
    log.debug("Path:" + p);
    return p.toFile();
  }
}
