package by.nesterenok.testyourself.web.action.implmvc.user;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import by.nesterenok.testyourself.service.ThemeService;
import com.sun.media.sound.ModelIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
@RequestMapping(value = REQUEST_MAPPING_USER_TESTS_ETC)
public class TestsSwither {

    @Autowired
    private ThemeService themeService;

    public void setThemeService(ThemeService themeService) {
        this.themeService = themeService;
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_THEME)
    public ModelAndView switchCreateTheme() {
        return new ModelAndView(PAGE_USER_CREATE_THEME);
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_QUESTION)
    public ModelAndView switchCreateQuestion() {
        ModelAndView mvn = new ModelAndView(PAGE_USER_TESTS_CREATE_QUESTION);
        mvn.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return mvn;
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_TEST_ONE)
    public ModelAndView switchCreateTestOne(){
        ModelAndView mvn = new ModelAndView(PAGE_USER_TESTS_CREATE_TEST_ONE);
        mvn.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return mvn;
    }
}
