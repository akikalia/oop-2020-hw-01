import java.util.*;

public class Appearances {


	private static <T> void mapAll(Collection<T> elems, HashMap<T, Integer> countMap) {
		for (T elem : elems)
		{
			if(!countMap.containsKey(elem))
				countMap.put(elem, 0);
			else
				countMap.replace(elem, countMap.get(elem) + 1);
		}
	}

	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		int res = 0;
		if (a == null || b == null)
			return 0;
		HashMap<T, Integer> aCountMap = new HashMap<T, Integer>();
		HashMap<T, Integer> bCountMap = new HashMap<T, Integer>();

		mapAll(a, aCountMap);
		mapAll(b, bCountMap);

		for (T elem : aCountMap.keySet()) {
			if (aCountMap.get(elem) == bCountMap.get(elem))
				res++;
		}
		return res;
	}
	
}
