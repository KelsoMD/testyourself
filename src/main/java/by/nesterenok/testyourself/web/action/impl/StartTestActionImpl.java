package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TEST_ID;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TEST_QUESTIONS;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.service.TestService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class StartTestActionImpl implements BaseAction {

	private TestService testService;
	private QuestionService questionService;
	
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}



	@Override
	public String executeAction(HttpServletRequest request) {

		int testId = Integer.parseInt(request.getParameter(REQUEST_PARAM_TEST_ID));
		Test test = testService.readTest(testId);
		List<Question> questionList = questionService.readTestQuestions(test.getId());
		test.setQuestions(questionService.initializeQuestion(questionList));
		request.setAttribute(REQUEST_PARAM_TEST_QUESTIONS, test.getQuestions());
		request.setAttribute(REQUEST_PARAM_TEST, test.getId());
		return PAGE_TEST;
	}

}
