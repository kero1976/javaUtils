package kero.infrastructure.execontrol;

import java.util.ArrayList;
import java.util.List;
import kero.domain.entities.Exe;
import kero.infrastructure.execontrol.exceptions.ExeControlException;

class CreateProcess {

  private Exe exe;
  private List<String> param = new ArrayList<String>();

  static ProcessBuilder create(Exe exe) throws ExeControlException {
    CreateProcess me = new CreateProcess(exe);
    me.check();
    ProcessBuilder pb = new ProcessBuilder(me.param);
    return pb;
  }

  CreateProcess(Exe exe) {
    this.exe = exe;
  }

  private void check() throws ExeControlException {
    String cmd = exe.getName();
    if (cmd == null || cmd.isEmpty()) {
      throw new ExeControlException("NULLです");
    }
    param.add(cmd);
    param.addAll(exe.getParams());
  }
}
