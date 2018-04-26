package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.PAGE_USER_MAIN;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_MARK;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TEST;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Result;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.ResultService;
import by.nesterenok.testyourself.web.action.BaseAction;
import by.nesterenok.testyourself.web.util.ActionHelper;

public class ExitResultsActionImpl implements BaseAction{
	
	ResultService rs;
	
	public void setRs(ResultService rs) {
		this.rs = rs;
	}



	@Override
	public String executeAction(HttpServletRequest request) {
		
		Test test = new Test(Integer.parseInt(request.getParameter(REQUEST_PARAM_TEST)));
		int mark = Integer.parseInt(request.getParameter(REQUEST_PARAM_MARK));
		boolean pass = mark > 70;
		User user = ActionHelper.getUser(request);
		Result result = new Result(test, mark, pass, user);
		rs.createResult(result);
		
		return PAGE_USER_MAIN;
	}
}
