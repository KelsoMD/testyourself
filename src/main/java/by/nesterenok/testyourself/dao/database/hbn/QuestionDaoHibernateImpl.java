package by.nesterenok.testyourself.dao.database.hbn;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

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
	public void update(Question t) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Question> readAll() {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Question.class);
		List<Question> questionList = criteria.list();
		return questionList;
	}

	@Override
	public int counter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Question> readTestQuestions(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
