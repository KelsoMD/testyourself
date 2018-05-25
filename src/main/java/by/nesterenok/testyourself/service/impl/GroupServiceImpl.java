package by.nesterenok.testyourself.service.impl;

import java.util.List;

import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.GroupService;


//@Component
//@Service child of Component
public class GroupServiceImpl implements GroupService{
	
	private GroupDao groupDao;
	
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@Override
	public List<Group> readGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> readMentorGroups(User user) {
		return groupDao.readMentorGroups(user);
	}

	@Override
	public void createGroup(Group group) {
		groupDao.create(group);
	}

	@Override
	public Group readGroup(int id) {
		return groupDao.read(id);
	}

}
