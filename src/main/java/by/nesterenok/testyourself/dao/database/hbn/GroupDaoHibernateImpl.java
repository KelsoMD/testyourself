package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import org.hibernate.Session;

import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Question;

public class GroupDaoHibernateImpl implements GroupDao{

	@Override
	public void create(Group t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Group read(int id) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Group group = (Group) session.get(Group.class, id);
		
		return group;
	}

	@Override
	public void update(Group t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Group> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> readUserGroups(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
