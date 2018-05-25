package by.nesterenok.testyourself.web.action.implmvc.mentor;

import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.GroupService;
import by.nesterenok.testyourself.service.ThemeService;

@Controller
@RequestMapping("mentor/groups")
@SessionAttributes(REQUEST_PARAM_USER)
public class GroupController {

	@Autowired
	private GroupService groupService;
	@Autowired
	private ThemeService themeService;
	@Autowired
	private SwitchMenu switchMenu;
	
	public void setSwitchmenu(SwitchMenu switchMenu) {
		this.switchMenu = switchMenu;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public void setThemeService(ThemeService themeService) {
		this.themeService = themeService;
	}

	@RequestMapping(value = "/create_page", method = RequestMethod.GET)
	public ModelAndView switchCreateGroup(@ModelAttribute User user) {
		ModelAndView mvn = new ModelAndView("jsp/mentor/create_group");
		Group group = new Group();
		mvn.addObject("group", group);
		mvn.addObject("themes", themeService.readThemes());
		return mvn;
	}

	@RequestMapping(value="/create_group",method=RequestMethod.POST)
	public ModelAndView createGroup(@ModelAttribute("group") Group group, @ModelAttribute User user) {
		group.setMentor(user);
		groupService.createGroup(group);
		return switchMenu.switchGroupMenu(user);
	}
	
	@RequestMapping(value="/group_info", method=RequestMethod.GET)
	public ModelAndView switchGroupInfo(@RequestParam("group_id") int groupId){
		ModelAndView mvn = new ModelAndView("jsp/mentor/group_info");
		Group group = groupService.readGroup(groupId);
		mvn.addObject("tasks", group.getTasks());
		mvn.addObject("members", group.getMembers());
		return mvn;
		
	}

}
