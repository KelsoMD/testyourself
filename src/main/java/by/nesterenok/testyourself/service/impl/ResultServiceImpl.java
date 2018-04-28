package by.nesterenok.testyourself.service.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.nesterenok.testyourself.dao.ResultDao;
import by.nesterenok.testyourself.domain.Result;
import by.nesterenok.testyourself.service.ResultService;

public class ResultServiceImpl implements ResultService{
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	ResultDao resultDao;
	public void setResultDao(ResultDao resultDao) {
		this.resultDao = resultDao;
	}



	@Override
	public void createResult(Result result) {
		
			resultDao.create(result);	
	}

}
