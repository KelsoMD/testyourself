package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.User;

public class GroupDaoHibernateImpl implements GroupDao{

	@Override
	public void create(Group t) {
		
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
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

	@Override
	public List<Group> readMentorGroups(User user) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Group.class).createCriteria("mentor").add(Restrictions.eq("id", user.getId()));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Group> groupList = criteria.list();
		session.close();
		return groupList;
	}

}
