package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import org.hibernate.Session;

import by.nesterenok.testyourself.dao.TaskDao;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Task;

public class TaskDaoHibernateImpl implements TaskDao{

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

}
