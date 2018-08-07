package topcoder.community.srms.abacus;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

//Problem Statement: https://community.topcoder.com/stat?c=problem_statement&pm=4512

class AbacusTest {


	@Test
	void testCase0() {
		String[] initialState = { "ooo---oooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "oo---ooooooo",
				"---ooooooooo" };

		int val = 5;

		String[] expectedFinalState = { "ooo---oooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "o---oooooooo",
				"ooooo---oooo" };

		assertArrayEquals(expectedFinalState, new Abacus().add(initialState, val));
	}

	@Test
	void testCase1() {
		String[] initialState = { "ooo---oooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "oo---ooooooo",
				"---ooooooooo" };
		int val = 21;
		String[] expectedFinalState = { "oo---ooooooo", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---",
				"ooooooooo---" };

		assertArrayEquals(expectedFinalState, new Abacus().add(initialState, val));
	}
	
	
	@Test
	void testCase2() {
		String[] initialState = { "ooooooooo---", "---ooooooooo", "ooooooooo---", "---ooooooooo", "oo---ooooooo",
				"---ooooooooo" };
		int val = 100000;
		
		String[] expectedFinalState = { "oooooooo---o", "---ooooooooo", "ooooooooo---", "---ooooooooo", "oo---ooooooo",
				"---ooooooooo" };
		
		assertArrayEquals(expectedFinalState, new Abacus().add(initialState, val));
	}
	
	@Test
	void testCase3() {
		String[] initialState = { "o---oooooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo",
				"---ooooooooo" };
		int val = 1;
		String[] expectedFinalState = { "---ooooooooo", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---",
				"ooooooooo---" };

		assertArrayEquals(expectedFinalState, new Abacus().add(initialState, val));

	}
	

}
