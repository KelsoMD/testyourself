package by.nesterenok.testyourself.web.action.implmvc.start;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.StartService;

@Controller
@RequestMapping("mentor")
@SessionAttributes(REQUEST_PARAM_USER)
public class StartMentor {
	
	@Autowired
	StartService startService;
	
	public void setStartService(StartService startService) {
		this.startService = startService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String executeAction(@ModelAttribute User user, ModelMap model) {
		
		model.addAttribute(REQUEST_PARAM_QUESTION_COUNT, startService.getQuestionCount());
		model.addAttribute(REQUEST_PARAM_TASK, startService.getComplete4Task(user));
		model.addAttribute(REQUEST_PARAM_TESTS, startService.getStartTests());
		return PAGE_MENTOR_MAIN;
		
	}

}
