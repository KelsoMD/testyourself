package by.nesterenok.testyourself.web.action.implmvc.mentor;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

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

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	@RequestMapping(value = REQUEST_MAPPING_MENTOR_GROUPS, method = RequestMethod.GET)
	public ModelAndView switchGroupMenu(@ModelAttribute User user) {
		ModelAndView mvn = new ModelAndView(PAGE_MENTOR_GROUPS);
		mvn.addObject(REQUEST_PARAM_GROUPS, groupService.readMentorGroups(user));
		return mvn;
	}

}
