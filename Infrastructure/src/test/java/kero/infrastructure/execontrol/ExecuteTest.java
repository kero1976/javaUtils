package kero.infrastructure.execontrol;

import java.util.ArrayList;
import java.util.List;
import kero.TestBase;
import kero.domain.entities.Exe;
import kero.domain.exceptions.AppException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ExecuteTest extends TestBase {

  @Test
  void Javaバージョン正常系() throws AppException {
    List<String> param = new ArrayList<String>();
    param.add("-version");
    Exe exe = new Exe("java", param);
    Execute execute = new Execute();
    int result = execute.execute(exe);
    Assertions.assertThat(result).isEqualTo(0);
  }

  @Test
  void Javaバージョン異常系() throws AppException {
    List<String> param = new ArrayList<String>();
    param.add("-version2");
    Exe exe = new Exe("java", param);
    Execute execute = new Execute();
    int result = execute.execute(exe);
    Assertions.assertThat(result).isEqualTo(1);
  }

  @Test
  void BATテスト1() throws AppException {
    copy("test1");
    List<String> param = new ArrayList<String>();
    param.add("-version2");
    Exe exe = new Exe("test.bat", param);
    Execute execute = new Execute();
    int result = execute.execute(exe);
    Assertions.assertThat(result).isEqualTo(10);
  }

  protected String setTestDir() {
    return "ExeControl";
  }

}
