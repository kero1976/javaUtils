package kero.domain.helpers;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import kero.domain.exceptions.AppIOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CopyHelper {

  /**
   * 指定したフォルダにあるファイルとフォルダを上書きコピーする。
   *
   *
   * @param srcDir コピー元フォルダ。このフォルダ下のファイル・フォルダをすべてコピーしする。指定したフォルダは含まない。
   * @param destDir コピー先フォルダ。
   * @throws AppIOException
   */
  public static void Copy(String srcDir, String destDir) throws AppIOException {
    // TODO 自動生成されたメソッド・スタブ
    try {
      FileUtils.copyDirectory(new File(srcDir), new File(destDir));
    } catch (IOException e) {
      log.debug("IOエラー", e);
      throw new AppIOException("CopyHelperでエラー", e);
    }
  }

}
