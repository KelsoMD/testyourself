package by.nesterenok.testyourself.web.action.implmvc.mentor;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = REQUEST_MAPPING_MENTOR_TESTS_ETC)
public class TestsSwitcher {

    @Autowired
    private ThemeService themeService;

    public void setThemeService(ThemeService themeService) {
        this.themeService = themeService;
    }

    @RequestMapping(value = REQUEST_MAPPING_MENTOR_TESTS_CREATE_THEME)
    public ModelAndView switchCreateTheme() {
        return new ModelAndView(PAGE_MENTOR_TESTS_CREATE_THEME);
    }

    @RequestMapping(value = REQUEST_MAPPING_MENTOR_TESTS_CREATE_QUESTION)
    public ModelAndView switchCreateQuestion() {
        return new ModelAndView(PAGE_MENTOR_TESTS_CREATE_QUESTION);
    }

    @RequestMapping(value = REQUEST_MAPPING_MENTOR_TESTS_CREATE_TEST)
    public ModelAndView switchCreateTest() {
        ModelAndView mvn = new ModelAndView(PAGE_MENTOR_TESTS_CREATE_TEST);
        mvn.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return mvn;
    }

}