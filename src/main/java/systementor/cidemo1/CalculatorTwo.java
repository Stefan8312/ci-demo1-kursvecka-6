package systementor.cidemo1;

public class CalculatorTwo {

    public int calculate(String operator, int a, int b) {
        switch (operator) {
            case "add": return a + b;
            case "subtract": return a - b;
            case "multiply": return a * b;
            case "divide":
                if (b == 0) throw new IllegalArgumentException("Division by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator");
        }
    }



}
