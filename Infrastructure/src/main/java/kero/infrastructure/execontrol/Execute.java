package kero.infrastructure.execontrol;

import kero.domain.entities.Exe;
import kero.domain.exceptions.base.AppException;
import kero.domain.repositories.IexeControl;
import kero.infrastructure.execontrol.exceptions.ExeControlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 実行クラス.
 *
 * @author kero
 *
 */
public class Execute implements IexeControl {
  private static Logger log = LoggerFactory.getLogger(Execute.class);

  /**
   * 実行.
   *
   * @throws AppException 例外
   */
  public static void execute2() throws AppException {

    ProcessBuilder pb = new ProcessBuilder("java", "-version");
    try {
      Process process = pb.start();


      // InputStreamのスレッド開始
      InputStreamThread it = new InputStreamThread(process.getInputStream());
      InputStreamThread et = new InputStreamThread(process.getErrorStream());
      it.start();
      et.start();

      // プロセスの終了待ち
      process.waitFor();

      // InputStreamのスレッド終了待ち
      it.join();
      et.join();

      System.out.println("戻り値：" + process.exitValue());

      // 標準出力の内容を出力
      for (String s : it.getStringList()) {
        System.out.println(s);
      }
      // 標準エラーの内容を出力
      for (String s : et.getStringList()) {
        System.err.println(s);
      }

    } catch (Exception e) {
      // TODO 自動生成された catch ブロック
      e.printStackTrace();
    }
  }

  @Override
  public int execute(Exe exe) throws AppException {
    log.debug("START=====================================================================");
    log.debug("Exe:" + exe);

    ProcessBuilder pb = CreateProcess.create(exe);
    try {
      Process process = pb.start();


      // InputStreamのスレッド開始
      InputStreamThread it = new InputStreamThread(process.getInputStream(), "SJIS");
      InputStreamThread et = new InputStreamThread(process.getErrorStream(), "SJIS");
      it.start();
      et.start();

      // プロセスの終了待ち
      process.waitFor();

      // InputStreamのスレッド終了待ち
      it.join();
      et.join();

      int result = process.exitValue();
      System.out.println("戻り値：" + result);
      log.debug("戻り値：" + result);
      // 標準出力の内容を出力
      System.out.println("STDOUT");
      log.debug("STDOUT");
      for (String s : it.getStringList()) {
        System.out.println(s);
        log.debug(s);
      }
      System.out.println("STDERR");
      log.debug("STDERR");
      // 標準エラーの内容を出力
      for (String s : et.getStringList()) {
        System.err.println(s);
        log.debug(s);
      }
      log.debug("END=======================================================================");
      return result;
    } catch (Exception e) {
      log.debug("Exception:" + e);
      e.printStackTrace();
      throw new ExeControlException("");
    }
  }


}
