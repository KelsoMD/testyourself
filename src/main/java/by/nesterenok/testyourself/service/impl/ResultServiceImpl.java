package by.nesterenok.testyourself.service.impl;

import by.nesterenok.testyourself.dao.ResultDao;
import by.nesterenok.testyourself.domain.Result;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.ResultService;

public class ResultServiceImpl implements ResultService{
	
	ResultDao resultDao;
	public void setResultDao(ResultDao resultDao) {
		this.resultDao = resultDao;
	}



	@Override
	public void createResult(Result result) {
			resultDao.create(result);	
	}
	
	@Override
	public Result buildResult(int test, int mark, boolean pass, int user) {
		
		Result result = new Result();
		result.setTest(new Test(test));
		result.setMark(mark);
		result.setPassed(pass);
		result.setUser(new User(user));
		return result;
	}

}
