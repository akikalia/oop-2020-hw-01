// TabooTest.java
// Taboo class tests -- nothing provided.

import java.util.*;

import junit.framework.TestCase;

public class TabooTest extends TestCase {
    private List<String> stringToList(String s) {
        List<String> list = new ArrayList<String>();
        for (int i=0; i<s.length(); i++) {
            list.add(String.valueOf(s.charAt(i)));
            // note: String.valueOf() converts lots of things to string form
        }
        return list;
    }

    public void testTabooNoFollow1() {
        Taboo<String> tab = new Taboo(stringToList("ababc"));
        Set<String> aSet = new HashSet<String>();
        aSet.add("b");

        assertEquals(Collections.emptySet(), tab.noFollow("c"));
        assertEquals(Collections.emptySet(), tab.noFollow("d"));
        assertEquals(aSet, tab.noFollow("a"));
    }


    public void testTabooNoFollow2() {
        Taboo<String> tab = new Taboo(stringToList("acab"));
        Set<String> aSet = new HashSet<String>();
        aSet.add("c");
        aSet.add("b");

        assertEquals(Collections.emptySet(), tab.noFollow("x"));
        assertEquals(aSet, tab.noFollow("a"));
    }


    public void testTabooNoFollow3() {

        Taboo<String> tab = new Taboo(Arrays.asList("a", "b", null, "c", "d"));
        Set<String> aSet = new HashSet<String>();
        aSet.add("b");
        Set<String> cSet = new HashSet<String>();
        cSet.add("d");

        assertEquals(Collections.emptySet(), tab.noFollow("b"));
        assertEquals(Collections.emptySet(), tab.noFollow("d"));
        assertEquals(aSet, tab.noFollow("a"));
        assertEquals(cSet, tab.noFollow("c"));
    }
    public void testTabooNoFollow4() {

        Taboo<String> tab = new Taboo(Arrays.asList("a", "b", null, "c", "d"));
        Set<String> aSet = new HashSet<String>();
        aSet.add("b");
        Set<String> cSet = new HashSet<String>();
        cSet.add("d");

        assertEquals(Collections.emptySet(), tab.noFollow(null));
        assertEquals(Collections.emptySet(), tab.noFollow(""));
    }
    public void testTabooNoFollow5() {

        Taboo<String> tab = new Taboo(Arrays.asList());

        assertEquals(Collections.emptySet(), tab.noFollow(null));
        assertEquals(Collections.emptySet(), tab.noFollow(""));
        assertEquals(Collections.emptySet(), tab.noFollow("a"));
        assertEquals(Collections.emptySet(), tab.noFollow("b"));
        assertEquals(Collections.emptySet(), tab.noFollow("g"));
    }
    public void testTabooNoFollow6() {

        Taboo<Integer> tab = new Taboo(Arrays.asList(1, 2, null, 3, 4));
        Set<Integer> aSet = new HashSet<Integer>();
        aSet.add(2);
        Set<Integer> cSet = new HashSet<Integer>();
        cSet.add(4);

        assertEquals(Collections.emptySet(), tab.noFollow(null));
        assertEquals(Collections.emptySet(), tab.noFollow(0));
        assertEquals(Collections.emptySet(), tab.noFollow(2));
        assertEquals(Collections.emptySet(), tab.noFollow(4));
        assertEquals(aSet, tab.noFollow(1));
        assertEquals(cSet, tab.noFollow(3));
    }

    public void testReduce1() {
        Taboo<String> tab = new Taboo(Arrays.asList("a", "c", "a", "b"));
        List<String> in = new ArrayList<String>(Arrays.asList("a", "c", "b", "x", "c", "a"));
        List<String> out = new ArrayList<String>(Arrays.asList("a", "x", "c"));

        List<String> in1 = new ArrayList<String>(Arrays.asList("a", "c", "b", "x", "c", "a", "a", "a", "a"));
        List<String> out1 =  new ArrayList<String>(Arrays.asList("a", "x", "c"));

        tab.reduce(in);
        tab.reduce(in1);
        assertEquals(out, in);
        assertEquals(out1, in1);
    }

    public void testReduce2() {
        Taboo<String> tab = new Taboo(Arrays.asList("a", "b", null, "c", "d", "b", "a"));
        List<String> in = new ArrayList<String>(Arrays.asList("b","c","a", "c", "b", "x", "c", "a"));
        List<String> out = new ArrayList<String>(Arrays.asList("b","c", "a", "c", "b", "x", "c", "a"));

        List<String> in1 = new ArrayList<String>(Arrays.asList("b","a", "a","c","a", "b", "c", "d","b", "x", "c", "a"));
        List<String> out1 = new ArrayList<String>(Arrays.asList("b", "c", "a", "c", "b", "x", "c", "a"));

        tab.reduce(in);
        tab.reduce(in1);
        assertEquals(out, in);
        assertEquals(out1, in1);
    }

    public void testReduce3() {
        Taboo<String> tab = new Taboo(Arrays.asList("a"));
        List<String> in = new ArrayList<String>(Arrays.asList("b","c","a", "c", "b", "x", "c", "a"));
        List<String> out = new ArrayList<String>(Arrays.asList("b","c","a", "c", "b", "x", "c", "a"));

        List<String> in1 = new ArrayList<String>(Arrays.asList("b","a", "a","c","a", "b", "c", "d","b", "x", "c", "a"));
        List<String> out1 = new ArrayList<String>(Arrays.asList("b","a", "a","c","a", "b", "c", "d","b", "x", "c", "a"));

        tab.reduce(in);
        tab.reduce(in1);
        assertEquals(out, in);
        assertEquals(out1, in1);
    }
    public void testReduce4() {
        Taboo<String> tab = new Taboo(Arrays.asList());
        List<String> in = new ArrayList<String>(Arrays.asList("b","c","a", "c", "b", "x", "c", "a"));
        List<String> out = new ArrayList<String>(Arrays.asList("b","c","a", "c", "b", "x", "c", "a"));

        List<String> in1 = new ArrayList<String>(Arrays.asList("b","a", "a","c","a", "b", "c", "d","b", "x", "c", "a"));
        List<String> out1 = new ArrayList<String>(Arrays.asList("b","a", "a","c","a", "b", "c", "d","b", "x", "c", "a"));

        tab.reduce(in);
        tab.reduce(in1);
        assertEquals(out, in);
        assertEquals(out1, in1);
    }

    public void testReduce5() {
        Taboo<String> tab = new Taboo(Arrays.asList("y", "z", "9"));
        List<String> in = new ArrayList<String>(Arrays.asList("b","c","a", "c", "b", "x", "c", "a"));
        List<String> out = new ArrayList<String>(Arrays.asList("b","c","a", "c", "b", "x", "c", "a"));

        List<String> in1 = new ArrayList<String>(Arrays.asList("b","a", "a","c","a", "b", "c", "d","b", "x", "c", "a"));
        List<String> out1 = new ArrayList<String>(Arrays.asList("b","a", "a","c","a", "b", "c", "d","b", "x", "c", "a"));

        tab.reduce(in);
        tab.reduce(in1);
        assertEquals(out, in);
        assertEquals(out1, in1);
    }

    public void testReduce6() {
        Taboo<Integer> tab = new Taboo(Arrays.asList(1, 2, 3, 4, 5, null, 19));
        List<Integer> in = new ArrayList<Integer>(Arrays.asList(1,2,3,1,2,8,7,3,6,1,2,7,3,4,5,1,2,7,3));
        List<Integer> out = new ArrayList<Integer>(Arrays.asList(1,3,1,8,7,3,6,1,7,3,5,1,7,3));

        List<Integer> in1 = new ArrayList<Integer>(Arrays.asList(1,2,3,1,2,8,7,3,6,1,2,7,3,4,5,19,19,1,2,7,3));
        List<Integer> out1 = new ArrayList<Integer>(Arrays.asList(1,3,1,8,7,3,6,1,7,3,5,19,19,1,7,3));

        tab.reduce(in);
        tab.reduce(in1);
        assertEquals(out, in);
        assertEquals(out1, in1);
    }
}
