package systementor.cidemo1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTwoTest {




    @Test
    void testAdd(){
        CalculatorTwo calc = new CalculatorTwo();
        assertEquals(5, calc.calculate("add", 2,3));
    }


    @Test
    void testSubtract(){
        CalculatorTwo calc = new CalculatorTwo();
        assertEquals(2, calc.calculate("subtract", 4,2));
    }




}