package Calculator;

public class Calculator {
    private double operand = 0.0;
    private char operator = ' ';
    private double result = 0.0;

    public Calculator() {
    }

    public void setOperand(double operand) {
        this.operand = operand;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public double calculate(double secondOperand) {
        switch (this.operator) {
            case '*':
                this.result = this.operand * secondOperand;
                break;
            case '+':
                this.result = this.operand + secondOperand;
            case ',':
            case '.':
            default:
                break;
            case '-':
                this.result = this.operand - secondOperand;
                break;
            case '/':
                this.result = this.operand / secondOperand;
        }

        return this.result;
    }
}
