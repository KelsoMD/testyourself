package by.nesterenok.testyourself.web.action.implmvc;

import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_LIST;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTION_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TASK;
import static by.nesterenok.testyourself.web.util.WebConstantPool.SESSION_PARAM_USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.StartService;
import by.nesterenok.testyourself.service.TaskService;
import by.nesterenok.testyourself.service.TestService;

@Controller
@RequestMapping("start_user_new")
@SessionAttributes(SESSION_PARAM_USER)
public class StartUser{

	@Autowired
	private StartService ss;
	@Autowired
	private TestService ts;
	@Autowired
	private TaskService taskService;

	public void setSs(StartService ss) {
		this.ss = ss;
	}
	public void setTs(TestService ts) {
		this.ts = ts;
	}
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String executeAction(@ModelAttribute User user, ModelMap model) {
		
		model.addAttribute(REQUEST_PARAM_QUESTION_COUNT, ss.getQuestionCount());

		if (user.getTheme() != null) {
			model.addAttribute(REQUEST_PARAM_LIST, ss.getStartSubscribedTests(user.getTheme()));
		} else {
			model.addAttribute(REQUEST_PARAM_LIST, ss.getStartTests());
		}
		if (!user.getGroup().isEmpty()) {
			
			model.addAttribute(REQUEST_PARAM_TASK, taskService.readUserTasks(user));
		}
		return "user_main";
	}

}
