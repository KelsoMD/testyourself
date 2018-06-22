package by.nesterenok.testyourself.web.action.implmvc;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Result;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.service.ResultService;
import by.nesterenok.testyourself.service.TestService;
import by.nesterenok.testyourself.service.ThemeService;
import by.nesterenok.testyourself.service.UserService;
import by.nesterenok.testyourself.web.action.implmvc.user.UserSwitchMenu;

@SuppressWarnings("Duplicates")
@Controller
@RequestMapping(value = {"user/tests", "mentor/tests", "guest/tests"})
@SessionAttributes({SESSION_PARAM_TEST, SESSION_PARAM_USER})
public class TestController implements RoleProcessor{

    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestService testService;
    @Autowired
    private UserSwitchMenu switchMenu;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private UserService userService;

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public void setSwitchMenu(UserSwitchMenu switchMenu) {
        this.switchMenu = switchMenu;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public void setThemeService(ThemeService themeService) {
        this.themeService = themeService;
    }

    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void startTest(@RequestParam(REQUEST_PARAM_TEST_ID) int testId) {
        ModelAndView mvn = new ModelAndView(processPage("test_page"));
        Test test = testService.readTest(testId);
        testService.prepareShuffled(test);
        mvn.addObject(REQUEST_PARAM_TEST_QUESTIONS, test.getQuestions());
        mvn.addObject(REQUEST_PARAM_TEST, test.getId());
    }

    @RequestMapping(value = "/delete_question", method = RequestMethod.GET)
    public void deleteQuestion(@RequestParam(REQUEST_PARAM_QUESTIONS_ID) int questionId, @ModelAttribute Test test) {
        ModelAndView mvn = new ModelAndView(processPage("create_test_two"));
        Question question = null;
        try {
            question = questionService.readQuestion(questionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        test.getQuestions()
            .remove(question);
        mvn.addObject(REQUEST_PARAM_QUESTIONS_RECENT, test.getQuestions());
        mvn.addObject(REQUEST_PARAM_QUESTIONS_TO_CHOOSE,
            questionService.returnQuestionsForTest(test.getTheme(), test.getLvl()));
    }

    @RequestMapping(value = "/add_question", method = RequestMethod.GET)
    public void addQuestion(@ModelAttribute Test test, @RequestParam(REQUEST_PARAM_QUESTIONS_ID) int questionId) {
        ModelAndView mvn = new ModelAndView(processPage("create_test_two"));
        try {
            test.getQuestions()
                .add(questionService.readQuestion(questionId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        mvn.addObject(REQUEST_PARAM_QUESTIONS_RECENT, test.getQuestions());
        mvn.addObject(REQUEST_PARAM_QUESTIONS_TO_CHOOSE,
            questionService.returnQuestionsForTest(test.getTheme(), test.getLvl()));
    }

    @RequestMapping(value = "/create_test", method = RequestMethod.POST)
    public String createTest(@ModelAttribute Test test) {
        testService.createTest(test);
        return REDIRECT + processUrl();
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_SUJEST_THEME, method = RequestMethod.POST)
    public String sujestTheme(@RequestParam(REQUEST_PARAM_THEME) String theme) {
        List<String> themeList = themeService.readThemes();
        ModelAndView mvn = null;
        if (themeList.contains(theme)) {
            mvn = new ModelAndView(PAGE_USER_CREATE_THEME, REQUEST_PARAM_THEME_MSG, REQUEST_MSG_THEME_EXISTS);
            return processPage("create_theme");
        } else {
            themeService.createTheme(theme);
            return REDIRECT + processUrl();
        }
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_SUJEST_QUESTION, method = RequestMethod.POST)
    public String sujestQuestion(HttpServletRequest request) {
        Question question = questionService.buildQuestion(request);
        questionService.createQuestion(question);
        return REDIRECT + processUrl();
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_SEARCH_TEST, method = RequestMethod.GET)
    public void searchTests(@RequestParam(REQUEST_PARAM_THEME) String theme, @RequestParam(REQUEST_PARAM_LVL) int lvl) {
        ModelAndView mvn = new ModelAndView(processPage("tests"));
        mvn.addObject(REQUEST_PARAM_TESTS, testService.searchTests(theme, lvl));
        mvn.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_PREVIEW, method = RequestMethod.GET)
    public void preview(@RequestParam(REQUEST_PARAM_QUESTIONS_ID) int id) {
        ModelAndView mvn = new ModelAndView(processPage("preview"));
        Question question = null;
        try {
            question = questionService.readQuestion(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mvn.addObject(REQUEST_PARAM_TEXT, question.getText());
        if (question.getImage() != null) {
            mvn.addObject(REQUEST_PARAM_IMAGE, question.getImage());
        }
        questionService.shuffleAnswers(question);
        mvn.addObject(REQUEST_PARAM_SHUFFLED, question.getShuffledAnswers());
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_FINISH, method = RequestMethod.POST)
    public void finishTest(@RequestParam(REQUEST_PARAM_ANSWER) String[] answers,
                           @RequestParam(REQUEST_PARAM_TEST) int testId) {
        ModelAndView mvn = new ModelAndView(REDIRECT + processPage("result_page"));
        Result result = resultService.buildResult(testId, userService.readByLogin(SecurityContextHolder.getContext()
            .getAuthentication()
            .getName()), answers);
        resultService.createResult(result);
        mvn.addObject(REQUEST_PARAM_ANSWER_MAP, resultService.getAnswerMap(answers));
        mvn.addObject(REQUEST_PARAM_MARK, result.getMark());
        if (result.isPassed()) {
            mvn.addObject(REQUEST_PARAM_PASS_MSG, REQUEST_MSG_PASSED);
        } else {
            mvn.addObject(REQUEST_PARAM_PASS_MSG, REQUEST_MSG_NOT_PASSED);
        }
    }
}
