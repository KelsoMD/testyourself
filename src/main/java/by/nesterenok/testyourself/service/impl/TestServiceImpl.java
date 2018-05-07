package by.nesterenok.testyourself.service.impl;

import java.util.List;

import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.TestService;

public class TestServiceImpl implements TestService {

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

	@Override
	public List<Test> searchTests(String theme, Integer lvl) {
		List<Test> searchedList = null;
		if (theme != null) {
			if (lvl != null) {
				searchedList = testDao.searchThemeLvl(theme, lvl);
			} else {
				searchedList = testDao.searchTheme(theme);
			}
		} else {
			if(lvl!=null) {
				searchedList = testDao.searchLvl(lvl);
			} else {
				searchedList = testDao.readAll();
			}
		}
		return searchedList;
	}

	@Override
	public void createTest(Test test) {
		testDao.create(test);
	}

}
