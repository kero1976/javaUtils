package kero.domain.helpers;

import java.io.File;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public final class PathHelper {

  private static Logger log = LoggerFactory.getLogger(PathHelper.class);

  /**
   * 作業フォルダの絶対パスを取得する.
   *
   * @return 作業フォルダの絶対パス
   */
  public static String getCurrentDirFullPath() {
    return toAbsolute(new File(".")).toString();
  }

  /**
   * 作業フォルダのフォルダ名を取得する.
   *
   * @return 作業フォルダのフォルダ名
   */
  public static String getCurrentDirName() {
    String path = getCurrentDirFullPath();
    return path.substring(path.lastIndexOf(File.separatorChar) + 1, path.length());
  }

  /**
   * 指定した文字列の絶対パスのFileクラスを返す.
   *
   * @param dir 相対・絶対のファイルパス
   * @return 指定したファイルパスを絶対パスに変更しFileクラス
   */
  public static File getAbsoluteFile(String dir) {
    log.debug("dir:" + dir);
    File f = toAbsolute(new File(dir));
    log.debug("Path:" + f);
    return f;
  }

  /**
   * 不要なパスを削除した絶対パスへの変換.
   *
   * @param f 変換前のFile(相対パス、不要なパスを含む)
   * @return 変換後のFile(絶対パス、不要なパスを含まない()
   */
  static File toAbsolute(File f) {
    Path p = f.getAbsoluteFile().toPath().normalize();
    return p.toFile();
  }
}
