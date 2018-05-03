package by.nesterenok.testyourself.service.impl;

import java.util.List;

import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.TestService;

public class TestServiceImpl implements TestService{
	
	private TestDao testDao;

	
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

	@Override
	public Test readTest(int id) {
		return testDao.read(id);
	}

	@Override
	public List<Test> readAll() {
		return testDao.readAll();
	}

}
