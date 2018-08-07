package topcoder.community.srms.reddragoninn;
// Problem Statement: https://community.topcoder.com/stat?c=problem_statement&pm=14695

public class RedDragonInn {

	public int maxGold(int N, int X) {
		return (X*N) * 2 + (N + (N-1));
	}

}
