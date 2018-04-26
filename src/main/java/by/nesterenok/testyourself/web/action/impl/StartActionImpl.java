package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.PAGE_INDEX;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_LIST;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTION_COUNT;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.service.StartService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class StartActionImpl implements BaseAction{
	
	private StartService startService;

	public void setStartService(StartService startService) {
		this.startService = startService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		
		request.setAttribute(REQUEST_PARAM_QUESTION_COUNT, startService.getQuestionCount());
		request.setAttribute(REQUEST_PARAM_LIST, startService.getStartTests());
		
		return PAGE_INDEX;
	}

}
