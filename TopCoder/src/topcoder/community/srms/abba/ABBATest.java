package topcoder.community.srms.abba;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * <a href="https://community.topcoder.com/stat?c=problem_statement&pm=13918">Problem Statement</a>
 *
 */
class ABBATest {

    @Test
    void testCase0() {
        String initial = "B";
        String target = "ABBA";
        
        String expectedReturn = ABBA.Possibility.POSSIBLE.value();
        
        assertEquals(expectedReturn, new ABBA().canObtain(initial, target));
    }

    @Test
    void testCase1() {
        String initial = "AB";
        String target = "ABB";
        
        String expectedReturn = ABBA.Possibility.IMPOSSIBLE.value();
        
        assertEquals(expectedReturn, new ABBA().canObtain(initial, target));
    }
    
    @Test
    void testCase2() {
        String initial = "BBAB";
        String target = "ABABABABB";
        
        String expectedReturn = ABBA.Possibility.IMPOSSIBLE.value();
        
        assertEquals(expectedReturn, new ABBA().canObtain(initial, target));
    }
    
    
    @Test
    void testCase3() {
        String initial = "BBBBABABBBBBBA";
        String target = "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA";
        
        String expectedReturn = ABBA.Possibility.POSSIBLE.value();
        
        assertEquals(expectedReturn, new ABBA().canObtain(initial, target));
    }
    
    
    @Test
    void testCase4() {
        String initial = "A";
        String target = "BB";
        
        String expectedReturn = ABBA.Possibility.IMPOSSIBLE.value();
        
        assertEquals(expectedReturn, new ABBA().canObtain(initial, target));
    }
    
}
