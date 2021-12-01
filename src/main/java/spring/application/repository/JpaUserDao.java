package spring.application.repository;

import org.springframework.stereotype.Repository;
import spring.application.entity.Operation;
import spring.application.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public User findByLogAndPass(String log, String pass) {
        try {
            return entityManager.createNamedQuery("User.findByLogAndPass", User.class)
                    .setParameter("log", log)
                    .setParameter("pass", pass)
                    .getSingleResult();
        }catch (NoResultException ignored){
            return null;
        }
    }

    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public List<User> findAll() {
        return entityManager
                .createNamedQuery("User.findAll", User.class)
                .getResultList();
    }

    public void update(int id, String password) {
        entityManager.createNamedQuery("User.update", User.class)
                .setParameter("pass", password)
                .setParameter("id", id)
                .executeUpdate();
    }

    public void saveOperation(Operation operation) {
        entityManager.persist(operation);
    }
}
