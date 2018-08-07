package topcoder.community.srms.armysize;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArmySizeTest {

    @Test
    void testCase0() {
        String[] units = { "Lots", "Lots" };

        String[] expectedReturn = { "Lots", "Horde" };
        Arrays.sort(expectedReturn);

        String[] actualReturned = new ArmySize().getSum(units);
        Arrays.sort(actualReturned);

        assertArrayEquals(expectedReturn, actualReturned);
    }

    @Test
    void testCase1() {

        String[] units = { "Throng", "Few", "Few" };

        String[] expectedReturn = { "Throng", "Swarm" };
        Arrays.sort(expectedReturn);

        String[] actualReturned = new ArmySize().getSum(units);
        Arrays.sort(actualReturned);

        assertArrayEquals(expectedReturn, actualReturned);
    }

    @Test
    void testCase2() {

        String[] units = { "Few", "Few", "Few", "Few", "Several" };

        String[] expectedReturn = { "Several", "Pack", "Lots" };
        Arrays.sort(expectedReturn);

        String[] actualReturned = new ArmySize().getSum(units);
        Arrays.sort(actualReturned);

        assertArrayEquals(expectedReturn, actualReturned);
    }

    @Test
    void testCase3() {

        String[] units = { "Swarm", "Pack", "Horde" };

        String[] expectedReturn = { "Swarm", "Zounds" };
        Arrays.sort(expectedReturn);

        String[] actualReturned = new ArmySize().getSum(units);
        Arrays.sort(actualReturned);

        assertArrayEquals(expectedReturn, actualReturned);
    }

    @Test
    void testCase4() {
        String[] units = { "Horde", "Horde", "Zounds", "Pack" };

        String[] expectedReturn = { "Zounds", "Legion" };
        Arrays.sort(expectedReturn);

        String[] actualReturned = new ArmySize().getSum(units);
        Arrays.sort(actualReturned);

        assertArrayEquals(expectedReturn, actualReturned);
    }

    @Test
    void testCase5() {
        String[] units = { "Legion", "Horde", "Swarm", "Several" };

        String[] expectedReturn = { "Legion" };
        Arrays.sort(expectedReturn);

        String[] actualReturned = new ArmySize().getSum(units);
        Arrays.sort(actualReturned);

        assertArrayEquals(expectedReturn, actualReturned);
    }
}
