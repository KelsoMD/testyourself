package by.nesterenok.testyourself.web.action.implmvc.start;

import static by.nesterenok.testyourself.web.util.WebConstantPool.PAGE_GUEST_MAIN;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_GUEST;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_LIST;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTION_COUNT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.nesterenok.testyourself.service.StartService;

@Controller
@RequestMapping(REQUEST_MAPPING_GUEST)
public class GuestStart {

	@Autowired
	private StartService ss;

	public void setSs(StartService ss) {
		this.ss = ss;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String executeAction(ModelMap model) {
		
		model.addAttribute(REQUEST_PARAM_QUESTION_COUNT, ss.getQuestionCount());
			model.addAttribute(REQUEST_PARAM_LIST, ss.getStartTests());
		return PAGE_GUEST_MAIN;
	}
	
}
