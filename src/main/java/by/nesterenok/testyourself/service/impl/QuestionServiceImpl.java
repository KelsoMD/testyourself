package by.nesterenok.testyourself.service.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_ANSWER1;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_ANSWER2;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_ANSWER3;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_CORRECT_ANSWER;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_IMAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_LVL;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TEXT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_THEME;
import static by.nesterenok.testyourself.web.util.WebConstantPool.SESSION_PARAM_USER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.client.HttpServerErrorException;

import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.User;
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



	@Override
	public Question buildQuestion(HttpServletRequest request) {
		Question question = new Question();
		
		question.setTheme(request.getParameter(REQUEST_PARAM_THEME));
		question.setLvl(Integer.parseInt(request.getParameter(REQUEST_PARAM_LVL)));
		question.setText(request.getParameter(REQUEST_PARAM_TEXT));
		question.setCorrectAnswer(request.getParameter(REQUEST_PARAM_CORRECT_ANSWER));
		question.setAnswer1(request.getParameter(REQUEST_PARAM_ANSWER1));
		question.setAnswer2(request.getParameter(REQUEST_PARAM_ANSWER2));
		question.setAnswer3(request.getParameter(REQUEST_PARAM_ANSWER3));
		question.setAuthor((User)request.getSession().getAttribute(SESSION_PARAM_USER));
		String image = request.getParameter(REQUEST_PARAM_IMAGE);
		if(image!=null) {
			question.setImage(image);
		}
		question.setAprooved(false);
		return question;
	}



	@Override
	public void createQuestion(Question question) {
		dao.create(question);
	}
}
