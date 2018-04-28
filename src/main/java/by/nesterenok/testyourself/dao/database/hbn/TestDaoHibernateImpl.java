package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Test;

public class TestDaoHibernateImpl implements TestDao{

	@Override
	public void create(Test t){
		
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		
	}

	@Override
	public Test read(int id) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Test test = (Test) session.get(Test.class, id);
		return test;
	}

	@Override
	public void update(Test t){
		
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
		session.delete(new Test(id));
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public List<Test> readAll() {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Test.class);
		List<Test> testList = criteria.list();
		session.close();
		return testList;
	}

	@Override
	public List<Test> readLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> readSubscribed(String theme) {
		// TODO Auto-generated method stub
		return null;
	}

}
