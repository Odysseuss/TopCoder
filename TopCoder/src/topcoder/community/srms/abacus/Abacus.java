package topcoder.community.srms.abacus;

/**
 * <a href="https://community.topcoder.com/stat?c=problem_statement&pm=4512">Problem Statement</a>
 */
public class Abacus {

    private static String separator = "---";
    private static char beadChar = 'o';
    private static char separatorChar = '-';
    private static int base = 10;

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

        for (int idx = (abbacus.length - 1); idx >= 0; idx--, remaining /= base) { // Starting at the least significant
                                                                                   // digit, parse each digit and
                                                                                   // "chop" the digit off by dividing
                                                                                   // by the base

            // Mod by base will return the least significant digit
            int valueForLine = remaining % base;

            // Create a string for the value
            abbacus[idx] = lineOfValue(valueForLine);

        }

        return abbacus;
    }

    private String lineOfValue(int value) {
        char[] lineChars = new char[12];

        // This index will be used in multiple for loops
        // to keep the place of where we are on the line.
        int idx = 11;

        // Add beads for the value of the line
        for (; idx >= 0 && (value > 0); idx--) {
            if (value > 0) {
                lineChars[idx] = beadChar;
                value--;
            }
        }

        // Add the seperator
        for (int separator = 0; separator < 3; separator++, idx--) {
            lineChars[idx] = separatorChar;
        }

        // Add the beads that are unused on the line.
        for (; idx >= 0; idx--) {
            lineChars[idx] = beadChar;
        }

        return new String(lineChars);
    }

    private int valueOnAbbacus(String[] state) {
        int value = 0;
        for (int idx = 0; idx < state.length; idx++) {
            int valueOfLine = (valueOnLine(state[idx]) * (int) java.lang.Math.pow(base, ((state.length - 1) - idx)));
            value += valueOfLine;
        }

        return value;
    }

    private int valueOnLine(String line) {

        String[] split = line.split(separator);

        int value = 0;

        if (split.length > 1) { // If there are more than one string in the split, determine the value. If there
                                // is no left side after the split. The line is a zero.

            // The value is the number of bead on the right side line.
            // This is represented in the right side of the split, or index 1
            value = split[1].lastIndexOf(beadChar) - split[1].indexOf(beadChar) + 1;
        }

        return value;
    }

}
