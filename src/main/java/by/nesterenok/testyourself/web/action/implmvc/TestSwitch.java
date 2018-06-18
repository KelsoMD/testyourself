package by.nesterenok.testyourself.web.action.implmvc;

import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_USER_TESTS_CREATE_QUESTION;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_USER_TESTS_CREATE_TEST_ONE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_USER_TESTS_CREATE_TEST_TWO;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_USER_TESTS_CREATE_THEME;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_LVL;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTIONS_TO_CHOOSE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_THEME;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_THEMES;
import static by.nesterenok.testyourself.web.util.WebConstantPool.SESSION_PARAM_TEST;
import static by.nesterenok.testyourself.web.util.WebConstantPool.SESSION_PARAM_USER;

import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.service.ThemeService;
import by.nesterenok.testyourself.service.UserService;

@Controller
@RequestMapping({"user/tests", "mentor/tests", "guest/tests"})
@SessionAttributes({SESSION_PARAM_USER, SESSION_PARAM_TEST})
public class TestSwitch implements RoleProcessor {

    @Autowired
    private ThemeService themeService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    public void setThemeService(ThemeService themeService) {
        this.themeService = themeService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_THEME, method = RequestMethod.GET)
    public void switchCreateTheme() {
        ModelAndView modelAndView = new ModelAndView(processPage("create_theme"));
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_QUESTION, method = RequestMethod.GET)
    public void switchCreateQuestion() {
        ModelAndView mvn = new ModelAndView(processPage("create_question"));
        mvn.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_TEST_ONE, method = RequestMethod.GET)
    public void switchCreateTestOne() {
        ModelAndView mvn = new ModelAndView(processPage("create_test_one"));
        mvn.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_TEST_TWO, method = RequestMethod.GET)
    public void switchCreateTestTwo(@RequestParam(REQUEST_PARAM_THEME) String theme,
                                            @RequestParam(REQUEST_PARAM_LVL) int lvl, HttpSession session) {
        ModelAndView mvn = new ModelAndView(processPage("create_test_two"));
        User user = userService.readByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        Test newTest = new Test();
        newTest.setTheme(theme);
        newTest.setLvl(lvl);
        newTest.setAuthor(user);
        Set<Question> set = new HashSet<>();
        newTest.setQuestions(set);
        session.setAttribute(SESSION_PARAM_TEST, newTest);
        mvn.addObject(REQUEST_PARAM_QUESTIONS_TO_CHOOSE, questionService.returnQuestionsForTest(theme, lvl));
    }
}
