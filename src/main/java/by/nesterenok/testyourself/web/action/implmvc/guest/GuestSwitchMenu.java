package by.nesterenok.testyourself.web.action.implmvc.guest;

import static by.nesterenok.testyourself.web.util.WebConstantPool.PAGE_GUEST_INFO;
import static by.nesterenok.testyourself.web.util.WebConstantPool.PAGE_GUEST_TESTS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_GUEST;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_GUEST_TESTS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_INFO;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTION_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TESTS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.SESSION_PARAM_USER;

import com.fasterxml.jackson.core.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.service.QuestionService;
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

    @Autowired
    private QuestionService questionService;

//    @RequestMapping(value = REQUEST_MAPPING_GUEST_TESTS)
//    public ModelAndView switchTestsMenu() {
//        ModelAndView mvn = new ModelAndView(PAGE_GUEST_TESTS);
//        mvn.addObject(REQUEST_PARAM_TESTS, testService.readAll());
//        return mvn;
//    }

    @RequestMapping(value = REQUEST_MAPPING_INFO)
    public ModelAndView switchInfoMenu() {
        ModelAndView mvn = new ModelAndView(PAGE_GUEST_INFO);
        mvn.addObject(REQUEST_PARAM_QUESTION_COUNT, startService.getQuestionCount());
        return mvn;
    }


    /* Rest Test */
@RequestMapping(value = "/resttest", method = RequestMethod.GET)
@ResponseBody
    public String restTest() {
//    Question restTestQuestion = new Question(1);
//    restTestQuestion.setText("Test");
//    restTestQuestion.setCorrectAnswer("Ccorrect answer");
//    restTestQuestion.setAnswer1("1");
//    restTestQuestion.setAnswer2("2");
//    restTestQuestion.setAnswer3("3");
//    restTestQuestion.setAprooved(true);
//    restTestQuestion.setLvl(1);
//    restTestQuestion.setTheme("RestTest");
    try {
        Question question = questionService.readQuestion(1);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "";
    }
}
