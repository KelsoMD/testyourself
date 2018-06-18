package by.nesterenok.testyourself.web.action.implmvc.user;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

//@Controller
//@RequestMapping(value = REQUEST_MAPPING_USER_TESTS_ETC)
//@SessionAttributes({SESSION_PARAM_USER, SESSION_PARAM_TEST})
public class UserTestsSwither {

    @Autowired
    private ThemeService themeService;

    @Autowired
    private QuestionService questionService;

    public void setThemeService(ThemeService themeService) {
        this.themeService = themeService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_THEME, method = RequestMethod.GET)
    public ModelAndView switchCreateTheme() {
        return new ModelAndView(PAGE_USER_TESTS_CREATE_THEME);
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_QUESTION, method = RequestMethod.GET)
    public ModelAndView switchCreateQuestion() {
        ModelAndView mvn = new ModelAndView(PAGE_USER_TESTS_CREATE_QUESTION);
        mvn.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return mvn;
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_TEST_ONE, method = RequestMethod.GET)
    public ModelAndView switchCreateTestOne() {
        ModelAndView mvn = new ModelAndView(PAGE_USER_TESTS_CREATE_TEST_ONE);
        mvn.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return mvn;
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_TEST_TWO, method = RequestMethod.GET)
    public ModelAndView switchCreateTestTwo(@RequestParam(REQUEST_PARAM_THEME) String theme,
                                            @RequestParam(REQUEST_PARAM_LVL) int lvl,
                                            @ModelAttribute User user,
                                            HttpSession session) {
        ModelAndView mvn = new ModelAndView(PAGE_USER_TESTS_CREATE_TEST_TWO);
        Test newTest = new Test();
        newTest.setTheme(theme);
        newTest.setLvl(lvl);
        newTest.setAuthor(user);
        Set<Question> set = new HashSet<>();
        newTest.setQuestions(set);
        session.setAttribute(SESSION_PARAM_TEST, newTest);
        mvn.addObject(REQUEST_PARAM_QUESTIONS_TO_CHOOSE, questionService.returnQuestionsForTest(theme, lvl));
        return mvn;
    }
}
