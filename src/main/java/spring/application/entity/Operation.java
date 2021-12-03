package spring.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "operations")
@NamedQueries({
        @NamedQuery(name = "Operation.findAll", query = "select o from Operation o where o.user.id = :id"),
})
public class Operation {
    public Operation() {
    }

    public Operation(User user, double num1, double num2, String typeOfOperation, double result) {
        this.user = user;
        this.num1 = num1;
        this.num2 = num2;
        this.typeOfOperation = typeOfOperation;
        this.result = result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private double num1;

    private double num2;

    private String typeOfOperation;

    private double result;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(String typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
