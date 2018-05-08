package by.nesterenok.testyourself.service.impl;

import java.util.List;

import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.dao.ThemeDao;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.StartService;

public class StartServiceImpl implements StartService{
	
	private QuestionDao questionDao;
	private TestDao testDao;
	private ThemeDao themeDao;
	
	public StartServiceImpl(QuestionDao questionDao, TestDao testDao, ThemeDao themeDao) {
		super();
		this.questionDao = questionDao;
		this.testDao = testDao;
		this.themeDao = themeDao;
	}

	@Override
	public int getQuestionCount() {
		return questionDao.counter();
		
	}

	@Override
	public List<Test> getStartTests() {	
		return testDao.readLast();
	}

	@Override
	public List<Test> getStartSubscribedTests(String theme) {
		
		return testDao.readSubscribed(theme);
	}

	@Override
	public int getNewQuestionsCount() {
		return questionDao.newQuestionsCount();
	}
	
	@Override
	public int getNewTestsCount() {
		return testDao.newTestsCount();
	}
	
	@Override
	public int getNewThemeCount() {
		return themeDao.newThemeCount();
	}
	
}
