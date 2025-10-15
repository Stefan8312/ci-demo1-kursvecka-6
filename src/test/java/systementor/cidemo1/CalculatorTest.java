package systementor.cidemo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    private final int a = 1;
    private final int b = 2;



    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }




    @Test
    void add() {
        int result = calculator.add(a,b);
        assertEquals(3,result);

    }

    @Test
    void subtract() {
        int result = calculator.subtract(a,b);
        assertEquals(-1,result);
    }

    @Test
    void multiply() {
        int result = calculator.multiply(a,b);
        assertEquals(2,result);
    }


    @Test
    void divide() {
        int result = calculator.divide(a,b);
        assertEquals(0,result);
    }



}