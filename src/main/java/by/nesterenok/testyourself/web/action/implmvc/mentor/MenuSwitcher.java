package by.nesterenok.testyourself.web.action.implmvc.mentor;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;
import static by.nesterenok.testyourself.web.util.WebConstantPool.PAGE_MENTOR_TESTS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.PAGE_USER_INFO;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_INFO;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_MENTOR;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_MENTOR_GROUPS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_MENTOR_TESTS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_GROUPS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTION_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TESTS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_THEMES;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.GroupService;
import by.nesterenok.testyourself.service.StartService;
import by.nesterenok.testyourself.service.TestService;
import by.nesterenok.testyourself.service.ThemeService;

@Controller
@RequestMapping(REQUEST_MAPPING_MENTOR)
@SessionAttributes(REQUEST_PARAM_USER)
public class MenuSwitcher {

    @Autowired
    private GroupService groupService;

    @Autowired
    private ThemeService themeService;

    @Autowired
    private TestService testService;
    
    @Autowired
    private StartService startService;

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public void setThemeService(ThemeService themeService) { this.themeService = themeService; }

    public void setTestService(TestService testService) { this.testService = testService; }

	public void setStartService(StartService startService) {
		this.startService = startService;
	}

	@RequestMapping(value = REQUEST_MAPPING_MENTOR_GROUPS, method = RequestMethod.GET)
    public ModelAndView switchGroupMenu(@ModelAttribute User user) {
        ModelAndView mvn = new ModelAndView(PAGE_MENTOR_GROUPS);
        mvn.addObject(REQUEST_PARAM_GROUPS, groupService.readMentorGroups(user));
        return mvn;
    }

    @RequestMapping(value = REQUEST_MAPPING_MENTOR_TESTS, method = RequestMethod.GET)
    public ModelAndView switchTestsMenu() {
        ModelAndView mvn = new ModelAndView(PAGE_MENTOR_TESTS);
        mvn.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        mvn.addObject(REQUEST_PARAM_TESTS, testService.readAll());
        return mvn;
    }
    
    @RequestMapping(value = REQUEST_MAPPING_INFO)
    public ModelAndView switchInfoMenu(){
        ModelAndView mvn = new ModelAndView(PAGE_MENTOR_INFO);
        mvn.addObject(REQUEST_PARAM_QUESTION_COUNT, startService.getQuestionCount());
        return mvn;
    }
}
