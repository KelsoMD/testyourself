package by.nesterenok.testyourself.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.dao.TaskDao;
import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.dao.ThemeDao;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.StartService;

@Service
public class StartServiceImpl implements StartService{
	
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private TestDao testDao;
	@Autowired
	private ThemeDao themeDao;
	@Autowired
	private GroupDao groupDao;
	@Autowired
	private TaskDao taskDao;

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
	public void setThemeDao(ThemeDao themeDao) {
		this.themeDao = themeDao;
	}
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}
	public void setTaskDao(TaskDao taskDao) {
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
