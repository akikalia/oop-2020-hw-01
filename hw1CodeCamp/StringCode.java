import java.util.*;
// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		char nextC = 0;
		char currC = 0;
		int curr;
		int res = 0;
		int size = str.length();

		if (size == 0)
			return 0;
		nextC = str.charAt(0);
		curr = 1;
		for (int i = 1; i < size; i++)
		{
			currC = nextC;
			nextC = str.charAt(i);
			if (currC == nextC)
				curr++;
			else if (currC != nextC)
			{
				if (curr > res)
					res = curr;
				curr = 1;
			}
		}

		return res; // YOUR CODE HERE
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		char c;
		char[] arr;
		StringBuilder res = new StringBuilder();

		int length = str.length();
		for (int i = 0; i< length; i++) {
			c = str.charAt(i);
			if (Character.isDigit(c)) {
				if (i + 1 != str.length()){
					arr = new char[Character.getNumericValue(c)];
					res.append((new String(arr)).replace('\0', str.charAt(i+1)));
				}
			}
			else {
				res.append(c);
			}
		}
		return new String(res); // YOUR CODE HERE
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 *
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		int size;
		HashSet<String> setA = new HashSet<String>();
		HashSet<String> setB = new HashSet<String>();

		size = a.length();
		for (int i = 0; i + len <= size ; i++)
		{
			setA.add(a.substring(i, i + len));
		}
		size = b.length();
		for (int i = 0; i + len  <= size; i++)
		{
			setB.add(b.substring(i, i + len));
		}

		setA.retainAll(setB);
		return !setA.isEmpty();
	}
}
