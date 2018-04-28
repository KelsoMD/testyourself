package by.nesterenok.testyourself.service.impl;

import by.nesterenok.testyourself.dao.ResultDao;
import by.nesterenok.testyourself.domain.Result;
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

}
