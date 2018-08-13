package topcoder.community.srms.abacus;

/**
 * <a href="https://community.topcoder.com/stat?c=problem_statement&pm=4512">Problem Statement</a>
 */
public class Abacus {

    private static String SEPARATOR = "---";
    private static final char BEAD_CHAR = 'o';
    private static final char SEPARATOR_CHAR = '-';
    private static final int BASE = 10;
    private static final int MAX_LINE_VALUE = 9;
    private static final int MAX_CHARACTERS_PER_LINE = 12;

    public String[] add(String[] original, int val) {

        // Get the initial value of the abacus in integer form
        // and add the requested value.
        int currentValueOnAbbacus = valueOnAbbacus(original);
        int valueOfFinalAbbacus = currentValueOnAbbacus + val;

        // Create the new "state" of the abacus as an array the
        // same size as the original
        String[] abbacus = new String[original.length];

        // Copy the value for the final state of the abacus
        // just in case we need to keep the value around.
        // This one is going to be modified as we "move" the beads
        // on the abacus.
        int remaining = valueOfFinalAbbacus;

        for (int idx = (abbacus.length - 1); idx >= 0; idx--, remaining /= BASE) { // Starting at the least significant
                                                                                   // digit, parse each digit and
                                                                                   // "chop" the digit off by dividing
                                                                                   // by the base

            // Mod by base will return the least significant digit
            int valueForLine = remaining % BASE;

            // Create a string for the value
            abbacus[idx] = lineOfValue(valueForLine);

        }

        return abbacus;
    }

    private String lineOfValue(int value) {
        assert(value <= MAX_LINE_VALUE); // Max value of line

        StringBuilder abacusLine = new StringBuilder(12);

        for (int i = 1; i <= (MAX_LINE_VALUE - value); i++) { // The non-value beads
            abacusLine.append(BEAD_CHAR);
        }
        
        abacusLine.append(SEPARATOR);
        
        for(int i = 1; i <= value; i++) { // The value beads
            abacusLine.append(BEAD_CHAR);
        }

        return abacusLine.toString();

    }

    private int valueOnAbbacus(String[] state) {
        int value = 0;
        for (int idx = 0; idx < state.length; idx++) {
            int valueOfLine = (valueOnLine(state[idx]) * (int) java.lang.Math.pow(BASE, ((state.length - 1) - idx)));
            value += valueOfLine;
        }

        return value;
    }

    private int valueOnLine(String line) {

        String[] split = line.split(SEPARATOR);

        int value = 0;

        if (split.length > 1) { // If the string splits, there are beads in the value portion. If the string
                                // does not split there is non value portion of the line (zero).

            // The value is the number of beads on the right side line, or split index 1.
            value = split[1].lastIndexOf(BEAD_CHAR) - split[1].indexOf(BEAD_CHAR) + 1;
        }

        return value;
    }

}
