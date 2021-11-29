package spring.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="operationId")
    private int id;

    private int userId;

    private double num1;

    private double num2;

    private double result;

    @Column(name="operation")
    private String typeOfOperation;

    public Operation(int userId, double num1, double num2, double result, String typeOfOperation) {
        this.userId = userId;
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.typeOfOperation = typeOfOperation;
    }
}
