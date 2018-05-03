package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.ResultTransformer;

import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.domain.Question;

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

}
