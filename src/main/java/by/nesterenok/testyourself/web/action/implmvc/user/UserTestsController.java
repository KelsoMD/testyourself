package by.nesterenok.testyourself.web.action.implmvc.user;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Result;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.service.ResultService;
import by.nesterenok.testyourself.service.TestService;
import by.nesterenok.testyourself.service.ThemeService;
import by.nesterenok.testyourself.web.util.ActionHelper;
import by.nesterenok.testyourself.web.util.WebConstantPool;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = REQUEST_MAPPING_USER_TESTS_ETC)
@SessionAttributes({SESSION_PARAM_TEST, SESSION_PARAM_USER})
public class UserTestsController {

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

    @RequestMapping(value = REQUEST_MAPPING_TEST_START_TEST)
    public ModelAndView startTest(@RequestParam(REQUEST_PARAM_TEST_ID) int testId) {
        ModelAndView mvn = new ModelAndView(PAGE_USER_TEST_PAGE);
        Test test = testService.readTest(testId);
        testService.prepareShuffled(test);
        mvn.addObject(REQUEST_PARAM_TEST_QUESTIONS, test.getQuestions());
        mvn.addObject(REQUEST_PARAM_TEST, test.getId());
        return mvn;
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_DELETE_QUESTION, method = RequestMethod.GET)
    public ModelAndView deleteQuestion(@RequestParam(REQUEST_PARAM_QUESTIONS_ID) int questionId, @ModelAttribute Test test) {
        ModelAndView mvn = new ModelAndView(PAGE_USER_TESTS_CREATE_TEST_TWO);
        Question question = questionService.readQuestion(questionId);
        test.getQuestions().remove(question);
        mvn.addObject(REQUEST_PARAM_QUESTIONS_RECENT, test.getQuestions());
        mvn.addObject(REQUEST_PARAM_QUESTIONS_TO_CHOOSE, questionService.returnQuestionsForTest(test.getTheme(), test.getLvl()));
        return mvn;
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_ADD_QUESTION, method = RequestMethod.GET)
    public ModelAndView addQuestion(@ModelAttribute Test test, @RequestParam(REQUEST_PARAM_QUESTIONS_ID) int questionId) {
        ModelAndView mvn = new ModelAndView(PAGE_USER_TESTS_CREATE_TEST_TWO);
        test.getQuestions().add(questionService.readQuestion(questionId));
        mvn.addObject(REQUEST_PARAM_QUESTIONS_RECENT, test.getQuestions());
        mvn.addObject(REQUEST_PARAM_QUESTIONS_TO_CHOOSE, questionService.returnQuestionsForTest(test.getTheme(), test.getLvl()));
        return mvn;
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_CREATE_TEST, method = RequestMethod.POST)
    public ModelAndView createTest(@ModelAttribute Test test) {
        testService.createTest(test);
        return switchMenu.switchTestsMenu();
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_SUJEST_THEME, method = RequestMethod.POST)
    public ModelAndView sujestTheme(@RequestParam(REQUEST_PARAM_THEME) String theme) {
        List<String> themeList = themeService.readThemes();
        ModelAndView mvn = null;
        if (themeList.contains(theme)) {
            mvn = new ModelAndView(PAGE_USER_CREATE_THEME, REQUEST_PARAM_THEME_MSG, REQUEST_MSG_THEME_EXISTS);
            return mvn;
        } else {
            themeService.createTheme(theme);
            return switchMenu.switchTestsMenu();
        }
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_SUJEST_QUESTION, method = RequestMethod.POST)
    public ModelAndView sujestQuestion(HttpServletRequest request) {
        Question question = questionService.buildQuestion(request);
        questionService.createQuestion(question);
        return switchMenu.switchTestsMenu();
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_SEARCH_TEST, method = RequestMethod.GET)
    public ModelAndView searchTests(@RequestParam(REQUEST_PARAM_THEME) String theme, @RequestParam(REQUEST_PARAM_LVL) int lvl) {
        ModelAndView mvn = new ModelAndView(PAGE_USER_TESTS);
        mvn.addObject(REQUEST_PARAM_TESTS, testService.searchTests(theme, lvl));
        mvn.addObject(REQUEST_PARAM_THEME, themeService.readThemes());
        return mvn;
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_PREVIEW, method = RequestMethod.GET)
    public ModelAndView preview(@RequestParam(REQUEST_PARAM_QUESTIONS_ID) int id) {
        ModelAndView mvn = new ModelAndView(PAGE_USER_TESTS_PREVIEW);
        Question question = questionService.readQuestion(id);
        mvn.addObject(REQUEST_PARAM_TEXT, question.getText());
        if (question.getImage() != null) {
            mvn.addObject(REQUEST_PARAM_IMAGE, question.getImage());
        }
        questionService.shuffleAnswers(question);
        mvn.addObject(REQUEST_PARAM_SHUFFLED, question.getShuffledAnswers());
        return mvn;
    }
    @RequestMapping(value = REQUEST_MAPPING_TEST_FINISH, method = RequestMethod.GET)
    public ModelAndView finishTest(@RequestParam(REQUEST_PARAM_ANSWER) String[] answers, @RequestParam(REQUEST_PARAM_TEST) int testId){
        ModelAndView mvn = new ModelAndView(PAGE_USER_TESTS_RESULT);
        Map<Question, String> answerMap = resultService.parseAnswers(answers);
        mvn.addObject(REQUEST_PARAM_ANSWER_MAP, answerMap);
        int mark = resultService.getMark(answerMap);
        mvn.addObject(REQUEST_PARAM_MARK, resultService.getMark(answerMap));
        if(resultService.isPassed(mark)){
            mvn.addObject(REQUEST_PARAM_PASS_MSG, REQUEST_MSG_PASSED);
        } else {
            mvn.addObject(REQUEST_PARAM_PASS_MSG, REQUEST_MSG_NOT_PASSED);
        }
        mvn.addObject(REQUEST_PARAM_TEST, testId);
        return mvn;
    }

    @RequestMapping(value = REQUEST_MAPPING_TEST_SAVE_RESULT, method = RequestMethod.POST)
    public ModelAndView saveResults(@RequestParam(REQUEST_PARAM_TEST) int testId, @RequestParam(REQUEST_PARAM_MARK) int mark, @ModelAttribute User user){
        Test test = new Test(testId);
        boolean pass = mark > 70;
        Result result = resultService.buildResult(test.getId(), mark, pass, user.getId());
        resultService.createResult(result);
        return switchMenu.switchTestsMenu();
    }
}