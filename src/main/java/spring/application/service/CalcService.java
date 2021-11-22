package spring.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.application.entity.Operation;
import spring.application.repository.OperationDAO;

import java.util.List;

@Service
public class CalcService {
    private final OperationDAO operationDAO;

    @Autowired
    public CalcService(OperationDAO operationDAO) {
        this.operationDAO = operationDAO;
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

    public double doOperation(double num1, double num2, String operation){
        double result = 0;

        switch (operation) {
            case "+" ->
                result = sum(num1, num2);
            case "-" ->
                result = sub(num1, num2);
            case "*" ->
                result = mul(num1, num2);
            case "/" ->
                result = div(num1, num2);
        }

        return result;
    }

    public void insertData(Operation operation) {
        operationDAO.insertData(operation);
    }

    public List<Operation> getData(int userId) {
        return operationDAO.getData(userId);
    }

    public void deleteData(int id){
        operationDAO.deleteData(id);
    }

    public void deleteByUserId(int id) {
        operationDAO.deleteByUserId(id);
    }
}
