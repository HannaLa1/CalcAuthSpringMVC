package spring.application.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.application.entity.Operation;

import java.util.List;

@Repository
public class OperationDAO {
    private final SessionFactory sessionFactory;

    public OperationDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertData(Operation operation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(operation);
    }

    public List<Operation> getData(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Operation where userId = :id", Operation.class)
                .setParameter("id", userId)
                .getResultList();
    }

    public void deleteData(int id) {
        Session session = sessionFactory.getCurrentSession();
        Operation operation = session.find(Operation.class, id);
        session.delete(operation);
    }

    public void deleteByUserId(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete Operation where userId = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
