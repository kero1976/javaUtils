package kero.domain.helpers;

import java.io.File;
import java.nio.file.Path;

import kero.domain.exceptions.base.AppIllegalArgumentException;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public final class PathHelper {

  /**
   * 作業フォルダの絶対パスを取得する.
   *
   * @return 作業フォルダの絶対パス
   */
  public static String getCurrentDirFullPath() {
    String s = null;
    try {
      s = toAbsolute(".").toString();
    } catch (AppIllegalArgumentException e) {
      // 例外は発生することは無いので、呼び出し元に例外は戻さない
      log.error(e.getDeveloperMessage());
    }
    return s;
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
   * @param path 相対・絶対のファイルパス
   * @return 指定したファイルパスを絶対パスに変更しFileクラス
   * @throws AppIllegalArgumentException パスが不正
   */
  public static File getAbsoluteFile(String path) throws AppIllegalArgumentException {
    log.debug("dir:" + path);
    File f = toAbsolute(path);
    log.debug("Path:" + f);
    return f;
  }

  /**
   * 不要なパスを削除した絶対パスへの変換.
   *
   * @param f 変換前のファイルパス文字列(相対パス、不要なパスを含む)
   * @return 変換後のFile(絶対パス、不要なパスを含まない()
   * @throws AppIllegalArgumentException パスが不正
   */
  static File toAbsolute(String path) throws AppIllegalArgumentException {
    try {
      File f = new File(path);
      Path p = f.getAbsoluteFile().toPath().normalize();
      return p.toFile();
    } catch (Exception e) {
      throw new AppIllegalArgumentException("PathHelper.toAbsoluteメソッドでエラー。path:" + path, e);
    }
  }
}
