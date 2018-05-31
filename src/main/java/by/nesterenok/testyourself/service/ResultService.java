package by.nesterenok.testyourself.service;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Result;

import java.util.Map;

public interface ResultService {

	
	public void createResult(Result result);
	
	public Result buildResult(int test, int mark, boolean pass, int user);

	public Map<Question, String> parseAnswers(String[] answers);

	public int getMark(Map<Question, String> answers);

	public boolean isPassed(int mark);
}
