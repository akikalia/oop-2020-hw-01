
// Test cases for CharGrid -- a few basic tests are provided.

import junit.framework.TestCase;

public class CharGridTest extends TestCase {
	
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}
	public void testCharArea3() {
		char[][] grid = new char[][] {
				{' ',' ','p'},
				{' ',' ','p',' ',' ',' ','p','x'},
				{'p','p','p','p'},
				{' ',' ','p'},
				{' ',' ','p','k','y','y','y','p','l'},
				{'z','z','z','z','z','y','z','z','z'},
				{' ',' ','x','x',' ','y',' ',' ','p'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(63, cg.charArea('p'));
		assertEquals(9, cg.charArea('z'));
		assertEquals(9, cg.charArea('y'));
		assertEquals(36, cg.charArea('x'));
	}

	public void testCharArea4() {
		char[][] grid = new char[][] {
				{'n',' ','p'},
				{' ',' ','p',' ',' ',' ','f','x'},
				{'p','p','p','p'},
				{' ',' ',' '},
				{' ',' ',' ','k','y','y','f','p','l'},
				{'z','z','z','z','z','y','z','z','z'},
				{' ',' ','x','a',' ','y','a',' ','n'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(1, cg.charArea('k'));
		assertEquals(1, cg.charArea('l'));
		assertEquals(63, cg.charArea('n'));

	}

	public void testCharArea5() {
		char[][] grid = new char[][] {
				{' ',' ','p'},
				{' ',' ','p',' ',' ',' ','f','x'},
				{'p','p','p','p'},
				{' ',' ',' '},
				{' ',' ',' ','k','y','y','f','p','l'},
				{'z','z','z','z','z','y','z','z','z'},
				{' ',' ','x','a',' ','y','a',' ','p'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0, cg.charArea(':'));
		assertEquals(0, cg.charArea('%'));
		assertEquals(0, cg.charArea('m'));
		assertEquals(4, cg.charArea('f'));
		assertEquals(4, cg.charArea('a'));


	}

	public void testCharArea6() {
		char[][] grid = new char[][] {
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0, cg.charArea(':'));
		assertEquals(0, cg.charArea('%'));
		assertEquals(0, cg.charArea('m'));
		assertEquals(0, cg.charArea('f'));
		assertEquals(0, cg.charArea('a'));


	}


	public void testCountPlus1() {
		char[][] grid = new char[][] {
				{'c', 'a', 'a'},
				{'b', ' ', 'a'},
				{' ', ' ', 'a'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0, cg.countPlus());
	}
	public void testCountPlus2() {
		char[][] grid = new char[][] {
				{'c', 'a', 'a'},
				{'a', 'a', 'a'},
				{' ', 'a', ' '}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(1, cg.countPlus());
	}

	public void testCountPlus3() {
		char[][] grid = new char[][] {
				{' ',' ','p',' ',' ',' ',' ',' ',' '},
				{' ',' ','p',' ',' ',' ',' ','x',' '},
				{'p','p','p','p','p',' ','x','x','x'},
				{' ',' ','p',' ',' ','y',' ','x',' '},
				{' ',' ','p',' ','y','y','y',' ',' '},
				{'z','z','z','z','z','y','z','z','z'},
				{' ',' ','x','x',' ','y',' ',' ',' '}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(2, cg.countPlus());
	}


	public void testCountPlus4() {
		char[][] grid = new char[][] {
				{' ',' ',' ','o',' ',' ','x',' ','x'},
				{' ',' ','p',' ','l','x','x','x','x'},
				{'p','p','p','p','p',' ','x','x','x'},
				{' ',' ','p',' ',' ','y','x','x','x'},
				{' ',' ','p',' ','y','y','y',' ','x'},
				{'z','z','p','z','z','y','z','z','z'},
				{' ',' ',' ','x',' ','y',' ',' ',' '}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(1, cg.countPlus());
	}
	public void testCountPlus5() {
		char[][] grid = new char[][] {
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0, cg.countPlus());
	}
	public void testCountPlus6() {
		char[][] grid = new char[][] {
				{' ',' ',' ','p',' ',' ','x',' ','x'},
				{' ',' ','p','p','p','x','x','x',' '},
				{'p','p','p','p','p',' ','x','x','x'},
				{' ',' ','p',' ',' ','y',' ','x','x'},
				{' ',' ','p',' ','y','y','y',' ','x'},
				{'z','z','p','z','z','y','z','z','z'},
				{' ',' ',' ','x',' ','y',' ',' ',' '}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(3, cg.countPlus());
	}

	// testing for noncontinious
	public void testCountPlus7() {
		char[][] grid = new char[][] {
				{' ',' ','p',' ',' ',' ',' ',' ',' '},
				{' ',' ','p',' ',' ',' ',' ','x',' '},
				{'p','p','p','p','p',' ','x','x','x'},
				{' ',' ','p',' ',' ','y',' ','x',' '},
				{' ',' ',' ',' ','y','y','y',' ',' '},
				{'z','z','p','z','z','y','z','z','z'},
				{' ',' ','x','x',' ','y',' ',' ',' '}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(1, cg.countPlus());
	}


}
