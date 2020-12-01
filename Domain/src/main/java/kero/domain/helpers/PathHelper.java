package kero.domain.helpers;

import java.io.File;
import java.nio.file.Path;

public final class PathHelper {

  public static String getCurrentDirName() {
    String path = new File(".").getAbsoluteFile().getParent();
    return path.substring(path.lastIndexOf(File.separatorChar) + 1, path.length());
  }

  public static File getAbsoluteFile(String dir) {
    File f = new File(dir);
    Path p = f.getAbsoluteFile().toPath().normalize();
    return p.toFile();
  }
}
