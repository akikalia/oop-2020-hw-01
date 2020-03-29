import junit.framework.TestCase;

import java.util.*;

public class AppearancesTest extends TestCase {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, b));
	}
	
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}

	public void testSameCount3() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList();
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList()));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1, 5, 6, 7, 8)));
	}

	public void testSameCount4() {
		//  List<Integer> cases
		List<Integer> a = Arrays.asList(1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3);
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(2, 3, 4, 5)));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(1, 1, 1, 1, 1, 1)));
		assertEquals(3, Appearances.sameCount(a, Arrays.asList(1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 5, 6, 7, 8)));
	}
	public void testSameCount5() {
		// List<Integer> cases
		List<String> a = Arrays.asList("abc", "hello", "abcd", "world", "world", "world");
		assertEquals(3, Appearances.sameCount(a, Arrays.asList("abc", "hello", "abcd", "world", "world")));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList("")));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList()));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(null, "abc")));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList("abc")));
	}
	public void testSameCount6() {
		// List<Integer> cases
		List<String> a = null;
		assertEquals(0, Appearances.sameCount(a, Arrays.asList("abc", "hello", "abcd", "world", "world")));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList("")));
		assertEquals(0, Appearances.sameCount(a, null));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList("abc")));
	}
}
