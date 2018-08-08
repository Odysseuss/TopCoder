package topcoder.community.srms.abba;


/**
 * 
 * <a href="https://community.topcoder.com/stat?c=problem_statement&pm=13918">Problem Statement</a>
 *
 */
public class ABBA {
    public static enum Possibility {
        POSSIBLE ("Possible"),
        IMPOSSIBLE ("Impossible");
        
        private final String value;
        public String value() {return value;}
        
        Possibility(String value) {
            this.value = value;
        }
    }
    
    public String canObtain(String initial, String target) {
        return recurse(new StringBuilder(initial), target).value();
    }
    
    public Possibility recurse(StringBuilder initial, String target) {
        
        if (target.equals(initial.toString())) { // Found the solution. Possible
            return Possibility.POSSIBLE;
        }
        
        if (target.length() < initial.length()) { // The string is too big without finding solution. Impossible.
            return Possibility.IMPOSSIBLE;
        }
        
        // Reverse and add B
        Possibility reverse = recurse(new StringBuilder(initial).reverse().append("B"), target);
        
        // Add A to end
        Possibility append = recurse(new StringBuilder(initial).append("A"), target);
        
        return (Possibility.POSSIBLE.equals(reverse) || Possibility.POSSIBLE.equals(append)) ? Possibility.POSSIBLE : Possibility.IMPOSSIBLE;
    }
}
