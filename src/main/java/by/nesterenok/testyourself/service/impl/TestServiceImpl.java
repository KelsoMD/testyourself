package by.nesterenok.testyourself.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.domain.Question;
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

	@Override
	public void prepareShuffled(Test test) {
		Set<Question> list = test.getQuestions();
		for(Question q : list) {
			List<String> qlist = new ArrayList<>();
			qlist.add(q.getCorrectAnswer());
			qlist.add(q.getAnswer1());
			qlist.add(q.getAnswer2());
			qlist.add(q.getAnswer3());
			Collections.shuffle(qlist);
			q.setShuffledAnswers(qlist);
		}
		
	}

}
