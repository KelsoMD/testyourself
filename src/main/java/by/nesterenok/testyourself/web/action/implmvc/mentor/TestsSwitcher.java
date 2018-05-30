package by.nesterenok.testyourself.web.action.implmvc.mentor;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = REQUEST_MAPPING_MENTOR_TESTS_ETC)
public class TestsSwitcher {

    @RequestMapping(value = REQUEST_MAPPING_MENTOR_TESTS_CREATE_THEME)
    public ModelAndView switchCreateTheme(){
        return new ModelAndView(PAGE_MENTOR_TESTS_CREATE_THEME);
    }

    @RequestMapping(value = REQUEST_MAPPING_MENTOR_TESTS_CREATE_QUESTION)
    public ModelAndView switchCreateQuestion(){
        return new ModelAndView(PAGE_MENTOR_TESTS_CREATE_QUESTION);
    }

}
