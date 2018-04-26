package by.nesterenok.testyourself.service.impl;

import java.util.List;

import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.StartService;

public class StartServiceImpl implements StartService{
	
	private QuestionDao questionDao;
	private TestDao testDao;
	
	public StartServiceImpl(QuestionDao questionDao, TestDao testDao) {
		super();
		this.questionDao = questionDao;
		this.testDao = testDao;
	}

	@Override
	public int getQuestionCount() {
		return questionDao.counter();
		
	}

	@Override
	public List<Test> getStartTests() {	
		List<Test> testList = testDao.readLast();
		for(Test test : testList) {
			List<Question> questionList = questionDao.readTestQuestions(test.getId());
			test.setQuestions(questionList);
		}	
		return testList;
	}

	@Override
	public List<Test> getStartSubscribedTests(String theme) {
		
		return testDao.readSubscribed(theme);
	}
	
	

}
