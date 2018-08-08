package topcoder.community.srms.binarycalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


/**
 * <a href="https://community.topcoder.com/stat?c=problem_statement&pm=14930">Problem Statement</a>
 *
 */
class BinaryCalculatorTest {

    @Test
    void testCase0() {
        int a = 10;
        int b = 14;
        int expectedReturn = 3;
        
        assertEquals(expectedReturn, new BinaryCalculator().minimumSteps(a, b));
    }
    
    @Test
    void testCase1() {
        int a = 23;
        int b = 23;
        int expectedReturn = 0;
        
        assertEquals(expectedReturn, new BinaryCalculator().minimumSteps(a, b));
    }
    
    @Test
    void testCase2() {
        int a = 18;
        int b = 12;
        int expectedReturn = 3;
        
        assertEquals(expectedReturn, new BinaryCalculator().minimumSteps(a, b));
    }
    
    @Test
    void testCase3() {
        int a = 23;
        int b = 62;
        int expectedReturn = 13;
        
        assertEquals(expectedReturn, new BinaryCalculator().minimumSteps(a, b));
    }
    
    @Test
    void testCase4() {
        int a = 99;
        int b = 100;
        int expectedReturn = 2;
        
        assertEquals(expectedReturn, new BinaryCalculator().minimumSteps(a, b));
    }

    @Test
    void testCase5() {
        int a = 98;
        int b = 100;
        int expectedReturn = 4;
        
        assertEquals(expectedReturn, new BinaryCalculator().minimumSteps(a, b));
    }
}
