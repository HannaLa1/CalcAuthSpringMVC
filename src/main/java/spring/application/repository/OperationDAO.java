package spring.application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.application.entity.Operation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OperationDAO {
    private final static String INSERT_DATA = "INSERT INTO operation(userId, num1, operation, num2, result) VALUES(?, ?, ?, ?, ?)";
    private final static String SELECT_DATA = "SELECT * FROM operation WHERE userId=?";
    private final static String DELETE_DATA = "DELETE FROM operation WHERE operationId = ?";
    private final static String DELETE_BY_USER_ID = "DELETE FROM operation WHERE userId = ?";
    private final DBConnection data;

    @Autowired
    public OperationDAO(DBConnection data) {
        this.data = data;
    }

    public void insertData(Operation operation) {
        try {
            PreparedStatement preparedStatement = data.getConnection().prepareStatement(INSERT_DATA);

            preparedStatement.setInt(1, operation.getUserId());
            preparedStatement.setDouble(2, operation.getNum1());
            preparedStatement.setString(3, operation.getTypeOfOperation());
            preparedStatement.setDouble(4, operation.getNum2());
            preparedStatement.setDouble(5, operation.getResult());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Operation> getData(int userId) {
        List<Operation> operationList = null;

        try {
            PreparedStatement preparedStatement = data.getConnection().prepareStatement(SELECT_DATA);

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            operationList = initializeFieldsOfOperation(resultSet);
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operationList;
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

    public void deleteByUserId(int id) {
        try {
            PreparedStatement preparedStatement = data.getConnection().prepareStatement(DELETE_BY_USER_ID);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Operation> initializeFieldsOfOperation(ResultSet resultSet) throws SQLException {
        List<Operation> operationList = new ArrayList<>();

        while (resultSet.next()){
            Operation operation = new Operation();

            operation.setId(resultSet.getInt("operationId"));
            operation.setUserId(resultSet.getInt("userId"));
            operation.setNum1(resultSet.getDouble("num1"));
            operation.setTypeOfOperation(resultSet.getString("operation"));
            operation.setNum2(resultSet.getDouble("num2"));
            operation.setResult(resultSet.getDouble("result"));

            operationList.add(operation);
        }
        return operationList;
    }
}
