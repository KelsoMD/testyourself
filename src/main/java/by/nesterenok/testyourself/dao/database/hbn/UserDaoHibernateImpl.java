package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import org.hibernate.Session;

import by.nesterenok.testyourself.dao.UserDao;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;

public class UserDaoHibernateImpl implements UserDao{

	@Override
	public void create(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User read(int id) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
