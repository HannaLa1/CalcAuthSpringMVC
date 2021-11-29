package spring.application.service;

import org.springframework.stereotype.Service;
import spring.application.entity.User;
import spring.application.repository.UserDAO;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorizationService {
    private final UserDAO userDAO;

    public AuthorizationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void insertData(User user) {
        userDAO.insertData(user);
    }

    public User getData(String log, String pass) {
        return userDAO.getData(log, pass);
    }

    public void deleteData(int id) {
        userDAO.deleteData(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public void update(int id, String password) {
        userDAO.update(id, password);
    }
}
