package by.nesterenok.testyourself.service;

import by.nesterenok.testyourself.domain.Result;

public interface ResultService {

	
	public void createResult(Result result);
	
	public Result buildResult(int test, int mark, boolean pass, int user);
}
