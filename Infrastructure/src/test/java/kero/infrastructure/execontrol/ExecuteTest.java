package kero.infrastructure.execontrol;

import java.util.ArrayList;
import java.util.List;
import kero.domain.entities.Exe;
import kero.domain.exceptions.AppException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ExecuteTest {

  @Test
  void test() throws AppException {
    List<String> param = new ArrayList<String>();
    param.add("-version");
    Exe exe = new Exe("java", param);
    Execute execute = new Execute();
    int result = execute.execute(exe);
    Assertions.assertThat(result).isEqualTo(0);
  }

}
