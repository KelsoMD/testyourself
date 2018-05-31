package by.nesterenok.testyourself.web.action.implmvc.mentor;
import  static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.TestService;

@Controller
@RequestMapping(value = REQUEST_MAPPING_MENTOR_TESTS_ETC)
public class TestsController {
	
	@Autowired
	private TestService testService;
	
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@RequestMapping(value=REQUEST_MAPPING_MENTOR_TESTS_START_TEST)
	public ModelAndView startTest(@RequestParam(REQUEST_PARAM_TEST_ID) int testId) {
		ModelAndView mvn = new ModelAndView(PAGE_MENTOR_TESTS_TEST);
		Test test = testService.readTest(testId);
		testService.prepareShuffled(test);
		mvn.addObject(REQUEST_PARAM_TEST_QUESTIONS, test.getQuestions());
		mvn.addObject(REQUEST_PARAM_TEST, test.getId());
		return mvn;
	}
	
}
