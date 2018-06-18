package by.nesterenok.testyourself.web.action.implmvc.start;

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
	@Autowired
	private StartModerator startModerator;
	@Autowired
	private StartMentor startMentor;

	public void setUs(UserService us) {
		this.us = us;
	}

	public void setTempUserStart(StartUser tempUserStart) {
		this.tempUserStart = tempUserStart;
	}
	
	public void setStartModerator(StartModerator startModerator) {
		this.startModerator = startModerator;
	}
	
	public void setStartMentor(StartMentor startMentor) {
		this.startMentor = startMentor;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String executeAction(@RequestParam(REQUEST_PARAM_ROLE) String role, HttpSession session, ModelMap model) {
		if (role != null) {
			User user = null;
			System.out.println(role);
			switch (role) {
			case "ROLE_USER":
				user = us.readUser();
				user.setRole("ROLE_USER");
				session.setAttribute("user", user);
				return tempUserStart.executeAction(model);
			case "ROLE_MENTOR":
				user = us.readUser();
				user.setRole("ROLE_MENTOR");
				session.setAttribute("user", user);
				return startMentor.executeAction(model);
			case "ROLE_ADMIN":
				user = us.readUser();
				user.setRole("ROLE_ADMIN");
				session.setAttribute("user", user);
				return null;
			case "ROLE_MODERATOR":
				user = us.readUser();
				user.setRole("ROLE_MODERATOR");
				session.setAttribute("user", user);
				return startModerator.executeAction(user, model);
			default:
				return PAGE_INDEX_TEMP;
			}
		} else {
			return PAGE_INDEX_TEMP;
		}
	}
}
