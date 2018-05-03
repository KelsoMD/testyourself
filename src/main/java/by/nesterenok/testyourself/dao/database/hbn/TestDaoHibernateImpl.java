package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.domain.Test;

public class TestDaoHibernateImpl implements TestDao{
	
	

	@Override
	public void create(Test t){
		
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Test read(int id) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		Test test = (Test) session.get(Test.class, id);
		session.getTransaction().commit();
		session.close();
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
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Test.class);
		criteria.addOrder(Order.desc("id"));
		criteria.setMaxResults(4);
		List<Test> testList = criteria.list();
		session.close();
		return testList;
	}

	@Override
	public List<Test> readSubscribed(String theme) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Test.class);
		criteria.addOrder(Order.desc("id"));
		criteria.setMaxResults(4);
		criteria.add(Restrictions.eq("theme", theme));
		List<Test> testList = criteria.list();
		session.close();
		return testList;
	}

}
