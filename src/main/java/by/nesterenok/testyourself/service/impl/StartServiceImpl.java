package by.nesterenok.testyourself.service.impl;

import java.util.List;

import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.dao.TaskDao;
import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.dao.ThemeDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.StartService;

public class StartServiceImpl implements StartService{
	
	private QuestionDao questionDao;
	private TestDao testDao;
	private ThemeDao themeDao;
	private GroupDao groupDao;
	private TaskDao taskDao;
	
	public StartServiceImpl(QuestionDao questionDao, TestDao testDao, ThemeDao themeDao, GroupDao groupDao, TaskDao taskDao) {
		super();
		this.questionDao = questionDao;
		this.testDao = testDao;
		this.themeDao = themeDao;
		this.groupDao = groupDao;
		this.taskDao = taskDao;
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

	@Override
	public List<Task> getComplete4Task(User user) {
		List<Task> tasks = taskDao.readComplete4Tasks(user);
		return tasks;
	}
	
}
