package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.domain.Question;

@Repository
public class QuestionDaoHibernateImpl implements QuestionDao {

	@Override
	public void create(Question t) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Question read(int id) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Question question = (Question) session.get(Question.class, id);
		session.close();
		return question;
	}

	@Override
	public void update(Question t){
		
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
		session.delete(new Question(id));
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public List<Question> readAll() {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Question.class);
		criteria.add(Restrictions.eq("aprooved", true));
		List<Question> questionList = criteria.list();
		session.close();
		return questionList;
	}

	@Override
	public int counter() {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Question.class);
		criteria.setProjection(Projections.property("id"));
		List<Integer> list = criteria.list();
		session.close();
		return list.size();
	}

	@Override
	public List<Question> readTestQuestions(int id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Question> readQuestionsForTest(String theme, int lvl) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Question.class);
		criteria.addOrder(Order.desc("id"));
		criteria.add(Restrictions.eq("theme", theme));
		criteria.add(Restrictions.eq("lvl", lvl));
		criteria.add(Restrictions.eq("aprooved", true));
		List<Question> questionList = criteria.list();
		session.close();
		return questionList;
	}

	@Override
	public List<Question> readNotAprooved() {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Question.class);
		criteria.add(Restrictions.eq("aprooved", false));
		List<Question> list = criteria.list();
		session.close();
		return list;
	}

	@Override
	public int newQuestionsCount() {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Question.class);
		criteria.setProjection(Projections.property("id"));
		criteria.setProjection(Projections.property("aprooved"));
		criteria.add(Restrictions.eq("aprooved", false));
		List<Integer> list = criteria.list();
		session.close();
		return list.size();
	}

}
