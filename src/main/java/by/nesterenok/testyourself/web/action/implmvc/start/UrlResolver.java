package by.nesterenok.testyourself.web.action.implmvc.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.UserService;

@Controller
@RequestMapping(value = "urlResolver")
public class UrlResolver {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String redirectUrl() {
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.readByLogin(login);
		switch (user.getRole()) {
		case "ROLE_USER":
			return "redirect:/user";
		case "ROLE_MENTOR":
			return "redirect:/mentor";
		case "ROLE_MODERATOR":
			return "redirect:/moderator";
		case "ROLE_ADMIN":
			return "redirect:/admin";
		default:
			return "redirect:/guest";
		}
	}
}
