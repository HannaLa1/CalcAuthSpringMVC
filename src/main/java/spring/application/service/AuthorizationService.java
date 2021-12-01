package spring.application.service;

import org.springframework.stereotype.Service;
import spring.application.entity.User;
import spring.application.repository.JpaUserDao;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorizationService {
    private final JpaUserDao jpaUserDao;

    public AuthorizationService(JpaUserDao jpaUserDao) {
        this.jpaUserDao = jpaUserDao;
    }

    public void save(User user) {
        jpaUserDao.save(user);
    }

    public User findByLogAndPass(String log, String pass) {
        return jpaUserDao.findByLogAndPass(log, pass);
    }

    public void delete(int id) {
        jpaUserDao.delete(id);
    }

    public List<User> findAll() {
        return jpaUserDao.findAll();
    }

    public void update(int id, String password) {
        jpaUserDao.update(id, password);
    }
}
