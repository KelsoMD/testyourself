package by.nesterenok.testyourself.service.impl;

import java.util.List;

import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.dao.UserDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	private GroupDao groupDao;
	
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}
	public void setUserDao(UserDao dao) {
		this.userDao = dao;
	}

	@Override
	public User readUser() {
		User user = userDao.read(2);
		List<Group> groupList = groupDao.readUserGroups(user.getId());
		user.setGroup(groupList);
		return user;
	}

}
