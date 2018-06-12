package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import by.nesterenok.testyourself.dao.TaskDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.User;

@Repository
public class TaskDaoHibernateImpl implements TaskDao {

	@Override
	public void create(Task t) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Task read(int id) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Task task = (Task) session.get(Task.class, id);
		return task;
	}

	@Override
	public void update(Task t) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void delete(int id) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(new Task(id));
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public List<Task> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> readGroupTasks(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> readComplete4Tasks(User user) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Task.class).createCriteria("group").createCriteria("mentor")
				.add(Restrictions.eq("id", user.getId()));
		criteria.addOrder(Order.desc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Task> taskList = criteria.list();
		session.close();
		return taskList;
	}

}
