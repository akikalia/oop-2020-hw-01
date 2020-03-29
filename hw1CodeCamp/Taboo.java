
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
	private HashMap<T, Set<T>> ruleMap;
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
	    T curr = null;
	    ruleMap = new HashMap<T, Set<T>>();
	    for (T next: rules)
	    {
	        if (curr != null && next != null){
	            if (ruleMap.containsKey(curr))
	                ruleMap.get(curr).add(next);
	            else {
                    ruleMap.put(curr,new HashSet<T>());
                    ruleMap.get(curr).add(next);
                }
            }
	        curr = next;
        }
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
	        return ruleMap.getOrDefault(elem, Collections.emptySet()); // fix for nonexistent pdf
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
	    for (int i = 0; i < list.size() - 1; i++)
        {
            T curr = list.get(i);
            T next = list.get(i + 1);
            if (ruleMap.containsKey(curr) && ruleMap.get(curr).contains(next)) {
                list.remove(i+1);
                i--;
            }
        }
	}
}
