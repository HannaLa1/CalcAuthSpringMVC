package spring.application.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.application.entity.User;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class UserDAO {
    private final SessionFactory sessionFactory;

    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertData(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public User getData(String log, String pass) {
        Session session = sessionFactory.getCurrentSession();

        try {
            return session.createQuery("from User where login = :log and password = :pass", User.class)
                    .setParameter("log", log)
                    .setParameter("pass", pass)
                    .getSingleResult();
        }catch (NoResultException ignored){
            return null;
        }
    }

    public void deleteData(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.find(User.class, id);
        session.delete(user);
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").getResultList();
    }

    public void update(int id, String password) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update User set password = :pass where id = :id")
                .setParameter("pass", password)
                .setParameter("id", id)
                .executeUpdate();
    }
}
