package kero.domain.helpers;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import org.junit.jupiter.api.Test;
import kero.domain.exceptions.AppIOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CopyHelperTest {

  @Test
  void CopyTest() {
    log.debug("CopyTest");
    try {
      CopyHelper.copy("../resources/テストデータ/domain/helpers/CopyHelper/test1", "dest");
    } catch (AppIOException e) {
      fail();
    }

    File file = new File("dest/data1");
    assertTrue(file.exists());
  }
}
