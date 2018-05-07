package by.nesterenok.testyourself.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Question;

public interface QuestionService {
	
	Question readQuestion(int id);
	
	List<Question> readTestQuestions(int testId);
	
	List<Question> initializeQuestion(List<Question> questionList);
	
	Question buildQuestion(HttpServletRequest request);
	
	void createQuestion(Question question);

}
