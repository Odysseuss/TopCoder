package topcoder.community.srms.reddragoninn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * <a href="https://community.topcoder.com/stat?c=problem_statement&pm=14695">Problem Statement</a>
 */
class RedDragonInnTest {

    @Test
    void testCase0() {
        int N = 3;
        int X = 2;
        int epxectedReturn = 17;

        assertEquals(epxectedReturn, new RedDragonInn().maxGold(N, X));
    }

    @Test
    void testCase1() {
        int N = 8;
        int X = 13;
        int expectedReturn = 223;

        assertEquals(expectedReturn, new RedDragonInn().maxGold(N, X));
    }

    @Test
    void testCase2() {
        int N = 42;
        int X = 1234;
        int expectedReturn = 103739;

        assertEquals(expectedReturn, new RedDragonInn().maxGold(N, X));

    }

}
