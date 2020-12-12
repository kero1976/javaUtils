package kero.domain.repositories;

import kero.domain.entities.Exe;
import kero.domain.exceptions.base.AppException;

public interface IexeControl {

  int execute(Exe exe) throws AppException;
}
