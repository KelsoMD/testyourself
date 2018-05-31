package by.nesterenok.testyourself.service.impl;
import static by.nesterenok.testyourself.service.util.ServiceConstantPool.*;

import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.dao.ResultDao;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Result;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultServiceImpl implements ResultService{

	private ResultDao resultDao;
	public void setResultDao(ResultDao resultDao) {
		this.resultDao = resultDao;
	}

	private QuestionDao questionDao;
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
	private QuestionService questionService;
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	@Override
	public void createResult(Result result) {
			resultDao.create(result);	
	}
	
	@Override
	public Result buildResult(int test, int mark, boolean pass, int user) {
		
		Result result = new Result();
		result.setTest(new Test(test));
		result.setMark(mark);
		result.setPassed(pass);
		result.setUser(new User(user));
		return result;
	}

	@Override
	public Map<Question, String> parseAnswers(String[] answers) {
		Map<Question, String> map = new HashMap<>();
		for (int i = 0; i < answers.length; i++) {
			String[] pair = answers[i].split(REGEX);
			Question question = questionService.readQuestion(Integer.parseInt(pair[1]));
			map.put(question, pair[0].trim());
		}
		return map;
	}

	@Override
	public int getMark(Map<Question, String> answers) {
		return 0;
	}

	@Override
	public boolean isPassed(int mark) {
		return false;
	}

}
