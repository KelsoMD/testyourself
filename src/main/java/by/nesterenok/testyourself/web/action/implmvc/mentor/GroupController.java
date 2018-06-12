package by.nesterenok.testyourself.web.action.implmvc.mentor;

import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_MENTOR_GROUPS_ETC;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_USER;

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
import by.nesterenok.testyourself.service.ThemeService;

@Controller
@RequestMapping(REQUEST_MAPPING_MENTOR_GROUPS_ETC)
@SessionAttributes(REQUEST_PARAM_USER)
public class GroupController {

	@Autowired
	private GroupService groupService;
	@Autowired
	private ThemeService themeService;
	@Autowired
	private MenuSwitcher switchMenu;
	
	public void setSwitchmenu(MenuSwitcher switchMenu) {
		this.switchMenu = switchMenu;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public void setThemeService(ThemeService themeService) {
		this.themeService = themeService;
	}

	@RequestMapping(value="/create_group",method=RequestMethod.POST)
	public ModelAndView createGroup(@ModelAttribute("group") Group group, @ModelAttribute User user) {
		group.setMentor(new User(user.getId()));
		groupService.createGroup(group);
		return switchMenu.switchGroupMenu(user);
	}
	
	

}
