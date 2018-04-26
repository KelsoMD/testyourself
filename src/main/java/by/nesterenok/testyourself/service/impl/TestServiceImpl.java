package by.nesterenok.testyourself.service.impl;

import java.util.List;

import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.TestService;

public class TestServiceImpl implements TestService{
	
	private TestDao testDao;
	private QuestionDao questionDao;
	
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	@Override
	public Test readTest(int id) {
		
		Test test = testDao.read(id);
		List<Question> questionList = questionDao.readTestQuestions(test.getId());
		for (Question q : questionList) {
			
			int questionId = q.getId();
			q = questionDao.read(questionId);
			
		}
		test.setQuestions(questionList);
		return test;
	}

}
