package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class AcceptQuestionActionImpl implements BaseAction{
	
	private QuestionService questionService;

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	@Override
	public String executeAction(HttpServletRequest request) {
		Question question = questionService.readQuestion(Integer.parseInt(request.getParameter(REQUEST_PARAM_QUESTIONS_ID)));
		question.setAprooved(true);
		questionService.updateQuestion(question);
		return REDIRECT_URL_MODERATOR_QUESTIONS;
	}

}
