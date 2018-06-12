package by.nesterenok.testyourself.web.action.implmvc.mentor;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;
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
@RequestMapping(REQUEST_MAPPING_MENTOR_GROUPS_ETC)
@SessionAttributes(REQUEST_PARAM_USER)
public class MentorGroupSwither {
	
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
	
	@RequestMapping(value = REQUEST_MAPPING_MENTOR_GROUPS_CREATE_PAGE, method = RequestMethod.GET)
	public ModelAndView switchCreateGroup(@ModelAttribute User user) {
		ModelAndView mvn = new ModelAndView(PAGE_MENTOR_GROUPS_CREATE_GROUP);
		Group group = new Group();
		mvn.addObject(REQUEST_PARAM_GROUP, group);
		mvn.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
		return mvn;
	}
	
	@RequestMapping(value=REQUEST_MAPPING_MENTOR_GROUPS_INFO_TASK, method=RequestMethod.GET)
	public ModelAndView switchGroupInfoTasks(@RequestParam(REQUEST_PARAM_GROUP_ID) int groupId){
		ModelAndView mvn = new ModelAndView(PAGE_MENTOR_GROUPS_CREATE_INFO_TASKS);
		Group group = groupService.readGroup(groupId);
		mvn.addObject(REQUEST_PARAM_GROUP_ID, groupId);
		mvn.addObject(REQUEST_PARAM_TASKS, group.getTasks());
		return mvn;
		
	}
	
	@RequestMapping(value=REQUEST_MAPPING_MENTOR_GROUPS_INFO_MEMBERS, method=RequestMethod.GET)
	public ModelAndView switchGroupInfoMembers(@RequestParam(REQUEST_PARAM_GROUP_ID) int groupId){
		ModelAndView mvn = new ModelAndView(PAGE_MENTOR_GROUPS_CREATE_INFO_MEMBERS);
		Group group = groupService.readGroup(groupId);
		mvn.addObject(REQUEST_PARAM_GROUP_ID, groupId);
		mvn.addObject(REQUEST_PARAM_MEMBERS, group.getMembers());
		return mvn;
		
	}

}
