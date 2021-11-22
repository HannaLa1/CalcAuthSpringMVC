package spring.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.application.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {
    private final static String INSERT_DATA = "INSERT INTO user(login, password, userName, role) VALUES(?, ?, ?, ?)";
    private final static String SELECT_DATA = "SELECT * FROM user WHERE login=? AND password=?";
    private final static String SELECT_ALL_USERS = "SELECT * FROM user";
    private final static String DELETE_DATA = "DELETE FROM user WHERE userId = ?";
    private final static String UPDATE = "UPDATE user SET password = ? WHERE userId = ?";
    private final DBConnection data;

   @Autowired
    public UserDAO(DBConnection data) {
        this.data = data;
    }

    public void insertData(User user) {
        try {
            PreparedStatement preparedStatement = data.getConnection().prepareStatement(INSERT_DATA);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getRole());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getData(String log, String pass) {
       User user = null;

        try{
            PreparedStatement preparedStatement = data.getConnection().prepareStatement(SELECT_DATA);
            preparedStatement.setString(1, log);
            preparedStatement.setString(2, pass);

            ResultSet resultSet = preparedStatement.executeQuery();

            user = initializeFieldsOfUser(resultSet);

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void deleteData(int id) {
        try {
            PreparedStatement preparedStatement = data.getConnection().prepareStatement(DELETE_DATA);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = null;

        try{
            PreparedStatement preparedStatement = data.getConnection().prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();

            users = initializeFieldsOfUsers(resultSet);

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void update(int id, String password) {
        try {
            PreparedStatement preparedStatement =  data.getConnection().prepareStatement(UPDATE);
            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User initializeFieldsOfUser(ResultSet resultSet) throws SQLException {
        User user = new User();

        while (resultSet.next()){
            user.setId(resultSet.getInt("userId"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setUserName(resultSet.getString("userName"));
            user.setRole(resultSet.getString("role"));
        }
        return user;
    }

    private List<User> initializeFieldsOfUsers(ResultSet resultSet) throws SQLException {
       List<User> users = new ArrayList<>();

        while (resultSet.next()){
            User user = new User();

            user.setId(resultSet.getInt("userId"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setUserName(resultSet.getString("userName"));
            user.setRole(resultSet.getString("role"));

            users.add(user);
        }
        return users;
    }
}
