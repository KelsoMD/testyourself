package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import org.hibernate.Session;

import by.nesterenok.testyourself.dao.TaskDao;
import by.nesterenok.testyourself.domain.Task;

public class TaskDaoHibernateImpl implements TaskDao{

	@Override
	public void create(Task t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task read(int id) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Task task = (Task) session.get(Task.class, id);
		return task;
	}

	@Override
	public void update(Task t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
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
