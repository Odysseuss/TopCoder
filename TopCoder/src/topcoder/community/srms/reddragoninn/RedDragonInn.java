package topcoder.community.srms.reddragoninn;

/**
 * <a href="https://community.topcoder.com/stat?c=problem_statement&pm=14695">Problem Statement</a>
 */
public class RedDragonInn {

    public int maxGold(int N, int X) {
        
        // Where N is the number of players and X is the amount of gold given to a
        // single player as per the problem statement. 
        // X*N*2 would be the least amount of gold needed for this turn as the inn
        // will take the first half of the gold.
        // 
        // Recall from the problem statement that inn will also take the ceiling of the 
        // first split as well as any gold left over that is unable to be equally distributed
        // among the players. 
        // Therefore, there could be at max another (N + (N - 1)) gold left as this
        // amount will be the max amount unable to be split among the players and will
        // also go to the inn.
        return (X * N) * 2 + (N + (N - 1));
    }

}
