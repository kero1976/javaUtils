package kero.infrastructure.execontrol;

import org.junit.jupiter.api.Test;

import kero.domain.exception.AppException;

class ExecuteTest {

	@Test
	void test() throws AppException {
		new Execute().execute();
	}

}
