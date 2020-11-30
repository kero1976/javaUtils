package kero.domain.helpers;

import java.io.File;

public final class PathHelper {

  public static String getCurrentDirName() {
    String path = new File(".").getAbsoluteFile().getParent();
    return path.substring(path.lastIndexOf(File.separatorChar) + 1, path.length());
  }
}
