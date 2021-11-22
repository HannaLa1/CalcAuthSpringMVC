package spring.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
    private int id;
    private int userId;
    private double num1;
    private double num2;
    private double result;
    private String typeOfOperation;

    public Operation(int userId, double num1, double num2, double result, String typeOfOperation) {
        this.userId = userId;
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.typeOfOperation = typeOfOperation;
    }
}
