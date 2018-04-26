package by.nesterenok.testyourself.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import by.nesterenok.testyourself.web.action.ActionManagerContext;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ACTION_PARAM = "action";//move to constantpool
       
   
    public MainServlet() {
        super();
    }
	@Override
	public void init() throws ServletException {
				
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		String actionParam = request.getParameter(ACTION_PARAM);
		String page = ActionManagerContext.getAction(actionParam, webAppContext).executeAction(request);
		request.getRequestDispatcher(page).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		String actionParam = request.getParameter(ACTION_PARAM);
		String page = ActionManagerContext.getAction(actionParam, webAppContext).executeAction(request);
		response.sendRedirect(page);
	}

}
