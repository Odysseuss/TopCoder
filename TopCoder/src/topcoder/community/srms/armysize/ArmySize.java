package topcoder.community.srms.armysize;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Problem Statement:
// https://community.topcoder.com/stat?c=problem_statement&pm=14999

public class ArmySize {

    Map<String, Quantifier> mappedQuantifiers = Collections.emptyMap();

    public ArmySize() {
        mappedQuantifiers = mapQuantifiers();
    }

    public String[] getSum(String[] units) {

        // Early return if there is a Legion in the units. This also helps prevent some
        // overflow that could occur on checking Legions of max size.
        if (Arrays.stream(units).anyMatch(s -> "Legion".equals(s))) {
            return new String[] { "Legion" };
        }

        Queue<String> unitQuantifiers = new LinkedList<String>(Arrays.asList(units));

        Set<Integer> possibleElementNumbers = new HashSet<>();
        recurse(unitQuantifiers, 0, possibleElementNumbers);

        Set<String> finalQuantifiers = new HashSet<>();
        for (int num : possibleElementNumbers) {
            
            // There's a lot going on here. There probably does not need to be but I'm
            // playing around with Streams here. We are looking through all of the quantifiers
            // trying to find the one for which this particular number matches and adding that
            // quantifier to the set of final quantifier classifications for this army.
            finalQuantifiers.add(mappedQuantifiers.entrySet().stream().filter(s -> s.getValue().isQuantity(num))
                                                  .findFirst().get().getKey());
        }

        return finalQuantifiers.stream().toArray(String[]::new);
    }

    private Map<String, Quantifier> mapQuantifiers() {
        Map<String, Quantifier> quantifiers = new HashMap<>();
        
        Quantifier few = new Few();
        quantifiers.put(few.getName(), few);
        
        Quantifier several = new Several();
        quantifiers.put(several.getName(), several);
        
        Quantifier pack = new Pack();
        quantifiers.put(pack.getName(), pack);
        
        Quantifier lots = new Lots();
        quantifiers.put(lots.getName(), lots);
        
        Quantifier horde = new Horde();
        quantifiers.put(horde.getName(), horde);
        
        Quantifier throng = new Throng();
        quantifiers.put(throng.getName(), throng);
        
        Quantifier swarm = new Swarm();
        quantifiers.put(swarm.getName(), swarm);
        
        Quantifier zounds = new Zounds();
        quantifiers.put(zounds.getName(), zounds);
        
        Quantifier legion = new Legion();
        quantifiers.put(legion.getName(), legion);

        return quantifiers;
    }

    // I think this is a breadth first search algorithm. Used here to count all
    // permutations of unit quantities for the input units. Nice.
    private void recurse(Queue<String> units, int count, Set<Integer> finalCounts) {
        if (units.isEmpty()) {
            finalCounts.add(count);
            return;
        }

        String unit = units.poll();
        int max = count + mappedQuantifiers.get(unit).getMax();
        recurse(new LinkedList<String>(units), max, finalCounts);

        int min = count + mappedQuantifiers.get(unit).getMin();
        recurse(new LinkedList<String>(units), min, finalCounts);

        return;
    }

    
    /**
     * The base class for all Quantifiers
     * 
     * Did I need to do a hierarchy for the quantifiers? No.
     * I could have just done a map of pairs or something but I wanted
     * to do this.
     * 
     */
    private abstract class Quantifier {
        private int min = 0;
        private int max = 0;
        private String name = "Quantifier";

        public Quantifier(int min, int max, String name) {
            this.min = min;
            this.max = max;
            this.name = name;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public boolean isQuantity(int num) {
            return (num >= getMin()) && (num <= getMax());
        }

        public String getName() {
            return name;
        }

    }

    private class Few extends Quantifier {
        public Few() {
            super(1, 4, "Few");
        }
    }

    private class Several extends Quantifier {
        public Several() {
            super(5, 9, "Several");
        }
    }

    public class Pack extends Quantifier {
        public Pack() {
            super(10, 19, "Pack");
        }
    }

    public class Lots extends Quantifier {
        public Lots() {
            super(20, 49, "Lots");
        }
    }

    public class Horde extends Quantifier {
        public Horde() {
            super(50, 99, "Horde");
        }
    }

    public class Throng extends Quantifier {
        public Throng() {
            super(100, 249, "Throng");
        }
    }

    public class Swarm extends Quantifier {
        public Swarm() {
            super(250, 499, "Swarm");
        }
    }

    public class Zounds extends Quantifier {
        public Zounds() {
            super(500, 999, "Zounds");
        }
    }

    public class Legion extends Quantifier {
        public Legion() {
            super(1000, Integer.MAX_VALUE, "Legion");

        }
    }
}
