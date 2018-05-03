package by.nesterenok.testyourself.service.impl;

import by.nesterenok.testyourself.dao.UserDao;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public void setUserDao(UserDao dao) {
		this.userDao = dao;
	}

	@Override
	public User readUser() {
		return userDao.read(2);
	}

}
