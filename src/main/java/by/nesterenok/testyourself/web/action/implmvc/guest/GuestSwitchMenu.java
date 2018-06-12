package by.nesterenok.testyourself.web.action.implmvc.guest;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import by.nesterenok.testyourself.service.StartService;
import by.nesterenok.testyourself.service.TestService;

@Controller
@RequestMapping(value = REQUEST_MAPPING_GUEST)
@SessionAttributes(SESSION_PARAM_USER)
public class GuestSwitchMenu {

	@Autowired
	private TestService testService;

	@Autowired
	private StartService startService;

	@RequestMapping(value = REQUEST_MAPPING_GUEST_TESTS)
	public ModelAndView switchTestsMenu() {
		ModelAndView mvn = new ModelAndView(PAGE_GUEST_TESTS);
		mvn.addObject(REQUEST_PARAM_TESTS, testService.readAll());
		return mvn;
	}

	@RequestMapping(value = REQUEST_MAPPING_INFO)
	public ModelAndView switchInfoMenu() {
		ModelAndView mvn = new ModelAndView(PAGE_GUEST_INFO);
		mvn.addObject(REQUEST_PARAM_QUESTION_COUNT, startService.getQuestionCount());
		return mvn;
	}

}
