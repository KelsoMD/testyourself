package by.nesterenok.testyourself.web.action.implmvc.start;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.StartService;
import by.nesterenok.testyourself.service.UserService;

@Controller
@RequestMapping("mentor")
public class StartMentor {

    @Autowired
    StartService startService;
    @Autowired
    UserService userService;

    public void setStartService(StartService startService) {
        this.startService = startService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String executeAction(ModelMap model) {
        User user = userService.readByLogin(SecurityContextHolder.getContext()
            .getAuthentication()
            .getName());
        model.addAttribute(REQUEST_PARAM_QUESTION_COUNT, startService.getQuestionCount());
        model.addAttribute(REQUEST_PARAM_TASK, startService.getComplete4Task(user));
        model.addAttribute(REQUEST_PARAM_TESTS, startService.getStartTests());
        return PAGE_MENTOR_MAIN;
    }
}
