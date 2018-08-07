package topcoder.community.srms.armysize;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Problem Statement: https://community.topcoder.com/stat?c=problem_statement&pm=14999

public class ArmySize {

	Map<String, Quantifier> mappedQuantifiers = Collections.emptyMap();
	
	public ArmySize() {
		mappedQuantifiers = mapQuantifiers();
	}
	
	public String[] getSum(String[] units) {
		
		// Early return if there is a Legion in the units. This also helps prevent some overflow
		// that could occur on checking Legions of max size.
		if (Arrays.stream(units).anyMatch(s -> "Legion".equals(s))) {
			return new String[]{"Legion"};
		}
		
		Queue<String> unitQuantifiers = new LinkedList<String>(Arrays.asList(units));
		
		Set<Integer> possibleElementNumbers = new HashSet<>();
		recurse(unitQuantifiers, 0, possibleElementNumbers);

		Set<String> finalQuantifiers = new HashSet<>();
		for (int num : possibleElementNumbers) {
			finalQuantifiers.add(mappedQuantifiers.entrySet().stream().filter(s -> s.getValue().isQuantity(num)).findFirst().get().getKey());
		}
		
		return finalQuantifiers.stream().toArray(String[]::new);
	}
	
	
	private Map<String, Quantifier> mapQuantifiers() {
		Map<String, Quantifier> quantifiers = new HashMap<>();
		quantifiers.put("Few", new Few());
		quantifiers.put("Several", new Several());
		quantifiers.put("Pack", new Pack());
		quantifiers.put("Lots", new Lots());
		quantifiers.put("Horde", new Horde());
		quantifiers.put("Throng", new Throng());
		quantifiers.put("Swarm", new Swarm());
		quantifiers.put("Zounds", new Zounds());
		quantifiers.put("Legion", new Legion());
		
		return quantifiers;
		
	}
	
	// I think this is a breadth first search algorithm. Used here to count all permutations of
	// unit quantities.
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
			super(1,4, "Few");
		}
	}
	
	private class Several extends Quantifier {
		public Several() {
			super(5,9, "Several");
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
