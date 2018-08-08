package topcoder.community.srms.binarycalculator;

/**
 * <a href="https://community.topcoder.com/stat?c=problem_statement&pm=14930">Problem Statement</a>
 *
 */
public class BinaryCalculator {
    
    public int minimumSteps(int a, int b) {
        int steps = 0;

        while (b != a) {
            
            if ((b - a) > 0) { // Positive difference
                a += 3;
            } else { // Negative difference
                a -= 2;
            }
            
            // Increase steps after each iteration
            steps++;
        }
        
        return steps;
    }

}
