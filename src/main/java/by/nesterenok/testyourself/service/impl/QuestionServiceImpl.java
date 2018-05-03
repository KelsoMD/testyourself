package by.nesterenok.testyourself.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.service.QuestionService;

public class QuestionServiceImpl implements QuestionService{
	
	private QuestionDao dao;
	
	public QuestionServiceImpl(QuestionDao dao) {
		super();
		this.dao = dao;
	}



	@Override
	public Question readQuestion(int id) {
		return dao.read(id);
	}



	@Override
	public List<Question> readTestQuestions(int testId) {
		List<Question> list = null;
		list = dao.readTestQuestions(testId);
		return list;
	}

	@Override
	public List<Question> initializeQuestion(List<Question> questionList) {
		List<Question> tempList = new ArrayList<>();
		for (Question question : questionList) {
			int questionId = question.getId();
			tempList.add(dao.read(questionId));
			
		}
		return tempList;
	}
}
