package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import by.nesterenok.testyourself.dao.UserDao;
import by.nesterenok.testyourself.domain.User;

@Repository
public class UserDaoHibernateImpl implements UserDao {

    @Override
    public void create(User t) {
        // TODO Auto-generated method stub

    }

    @Override
    public User read(int id) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    @Override
    public void update(User t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<User> readAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findByLogin(String login) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        return (User) session.createCriteria(User.class)
            .add(Restrictions.eq("login", login))
            .uniqueResult();
    }
}
