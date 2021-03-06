package by.nesterenok.testyourself.dao;

import java.util.List;

import by.nesterenok.testyourself.domain.Question;

public interface QuestionDao extends BaseDao<Question>{
	
	int counter();
	
	List<Question> readTestQuestions(int id);
	
	List<Question> readQuestionsForTest(String theme, int lvl);
	
	List<Question> readNotAprooved();
	
	int newQuestionsCount();

}
