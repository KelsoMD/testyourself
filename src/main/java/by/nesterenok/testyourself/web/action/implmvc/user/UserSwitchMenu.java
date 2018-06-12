package by.nesterenok.testyourself.web.action.implmvc.user;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import by.nesterenok.testyourself.service.StartService;
import by.nesterenok.testyourself.service.TestService;
import by.nesterenok.testyourself.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = REQUEST_MAPPING_USER)
@SessionAttributes(SESSION_PARAM_USER)
public class UserSwitchMenu {

    @Autowired
    private TestService testService;

    @Autowired
    private ThemeService themeService;
    
    @Autowired
    private StartService startService;

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS)
    public ModelAndView switchTestsMenu(){
        ModelAndView mvn = new ModelAndView(PAGE_USER_TESTS);
        mvn.addObject(REQUEST_PARAM_TESTS, testService.readAll());
        mvn.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return mvn;
    }
    
    @RequestMapping(value = REQUEST_MAPPING_INFO)
    public ModelAndView switchInfoMenu(){
        ModelAndView mvn = new ModelAndView(PAGE_USER_INFO);
        mvn.addObject(REQUEST_PARAM_QUESTION_COUNT, startService.getQuestionCount());
        return mvn;
    }
    
}
