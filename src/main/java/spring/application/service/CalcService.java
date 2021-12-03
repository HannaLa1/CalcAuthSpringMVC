package spring.application.service;

import org.springframework.stereotype.Service;
import spring.application.entity.Operation;
import spring.application.entity.User;
import spring.application.repository.JpaOperationDAO;
import spring.application.repository.JpaUserDao;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CalcService {
    private final JpaOperationDAO jpaOperationDAO;

    public CalcService(JpaOperationDAO jpaOperationDAO) {
        this.jpaOperationDAO = jpaOperationDAO;
    }

    private double sum(double num1, double num2) {
        return num1 + num2;
    }

    private double sub(double num1, double num2) {
        return num1 - num2;
    }

    private double mul(double num1, double num2) {
        return num1 * num2;
    }

    private double div(double num1, double num2) {
        return num1 / num2;
    }

    public double doOperation(User user, double num1, double num2, String operation){
        double result = 0;

        switch (operation) {
            case "+" : {
                result = sum(num1, num2);
                save(new Operation(user, num1, num2, operation, result));
                break;
            }
            case "-" : {
                result = sub(num1, num2);
                save(new Operation(user, num1, num2, operation, result));
                break;
            }
            case "*" : {
                result = mul(num1, num2);
                save(new Operation(user, num1, num2, operation, result));
                break;
            }
            case "/" : {
                result = div(num1, num2);
                save(new Operation(user, num1, num2, operation, result));
                break;
            }
        }

        return result;
    }

    public void save(Operation operation) {
        jpaOperationDAO.save(operation);
    }

    public List<Operation> findAll(long id) {
        return jpaOperationDAO.findAll(id);
    }

    public void delete(long id){
        jpaOperationDAO.delete(id);
    }
}
