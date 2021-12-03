package spring.application.repository;

import org.springframework.stereotype.Repository;
import spring.application.entity.Operation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaOperationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Operation operation) {
        entityManager.persist(operation);
    }

    public List<Operation> findAll(long id) {
        return entityManager.createNamedQuery("Operation.findAll", Operation.class)
                .setParameter("id", id)
                .getResultList();
    }

    public void delete(long id) {
        Operation operation = entityManager.find(Operation.class, id);
        entityManager.remove(operation);
    }
}
