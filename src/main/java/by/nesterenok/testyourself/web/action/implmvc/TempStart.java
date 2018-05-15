package by.nesterenok.testyourself.web.action.implmvc;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.UserService;
import by.nesterenok.testyourself.web.action.BaseAction;
import by.nesterenok.testyourself.web.action.impl.StartModeratorActionImpl;
import by.nesterenok.testyourself.web.action.impl.StartUserActionImpl;

@Controller
@RequestMapping(REQUEST_MAPPING_TEMP_START)
@SessionAttributes(REQUEST_PARAM_USER)
public class TempStart{

	@Autowired
	private UserService us;
	@Autowired
	private StartUser tempUserStart;

	public void setUs(UserService us) {
		this.us = us;
	}

	public void setTempUserStart(StartUser tempUserStart) {
		this.tempUserStart = tempUserStart;
	}


	@RequestMapping(method = RequestMethod.GET)
	public String executeAction(@RequestParam(REQUEST_PARAM_ROLE) String role, HttpSession session, ModelMap model) {
		if (role != null) {
			User user = null;
			switch (role) {
			case "user":
				user = us.readUser();
				user.setRole("user");
				session.setAttribute("user", user);
				return tempUserStart.executeAction(user, model);
			case "mentor":
				user = us.readUser();
				user.setRole("mentor");
				session.setAttribute("user", user);
				return null;
			case "admin":
				user = us.readUser();
				user.setRole("admin");
				session.setAttribute("user", user);
				return null;
			case "moderator":
				user = us.readUser();
				user.setRole("moderator");
				session.setAttribute("user", user);
				return "not yet";
			default:
				return PAGE_INDEX_TEMP;
			}
		} else {
			return PAGE_INDEX_TEMP;
		}
	}
}
