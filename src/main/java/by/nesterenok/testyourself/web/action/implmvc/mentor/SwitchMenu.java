package by.nesterenok.testyourself.web.action.implmvc.mentor;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import by.nesterenok.testyourself.service.TestService;
import by.nesterenok.testyourself.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.GroupService;

@Controller
@RequestMapping(REQUEST_MAPPING_MENTOR)
@SessionAttributes(REQUEST_PARAM_USER)
public class SwitchMenu {

    @Autowired
    private GroupService groupService;

    @Autowired
    private ThemeService themeService;

    @Autowired
    private TestService testService;

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public void setThemeService(ThemeService themeService) { this.themeService = themeService; }

    public void setTestService(TestService testService) { this.testService = testService; }

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
}
