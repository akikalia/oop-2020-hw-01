import junit.framework.TestCase;
import java.util.*;

public class TetrisGridTest extends TestCase {

	// Provided simple clearRows() test
	// width 2, height 3 grid
	public void testClear1() {
		boolean[][] before =
				{
						{true, true, false,},
						{false, true, true,}
				};

		boolean[][] after =
				{
						{true, false, false,},
						{false, true, false,}
				};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}

	public void testClear2() {
		boolean[][] before =
				{
						{true, true, false,},
						{true, true, true,}
				};

		boolean[][] after =
				{
						{false, false, false,},
						{true, false, false,}
				};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}

	public void testClear3() {
		boolean[][] before =
				{
						{true,  true, true, true,},
						{false, true, true, true,},
						{false, true, true, true,}

				};

		boolean[][] after =
				{
						{true,  false, false, false,},
						{false, false, false, false,},
						{false, false, false, false,}
				};
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}

	public void testClear4() {
		boolean[][] before =
				{
						{true,  true, true, true,},
						{true, true, true, true,},
						{true, true, true, false,}

				};

		boolean[][] after =
				{
						{true,  false, false, false,},
						{true, false, false, false,},
						{false, false, false, false,}
				};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}


	public void testClear5() {
		boolean[][] before =
				{
						{true,  true, true, true,},
						{true, true, true, true,},
						{true, true, true, true,},

				};

		boolean[][] after =
				{
						{false, false, false, false,},
						{false, false, false, false,},
						{false, false, false, false,},

				};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}


	public void testClear6() {
		boolean[][] before =
				{
						{true,  true, true, true,},
						{true, true, true, true,},
						{true, true, false, true,},

				};

		boolean[][] after =
				{
						{true, false, false, false,},
						{true, false, false, false,},
						{false, false, false, false,}

				};
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}



	public void testClear7() {
		boolean[][] before =
				{
						{true,}

				};

		boolean[][] after =
				{
						{false,}

				};
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}


	public void testClear8() {
		boolean[][] before =
				{
						{false,}

				};

		boolean[][] after =
				{
						{false,}

				};
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}


	public void testClear9() {
		boolean[][] before =
		{
		{true,  true, true, true,false, true, },
		{true, true, true, true,false, true, },
		{true, true, false, true,true, true, },

		};

		boolean[][] after =
		{
		{true, false, false, false,false, false, },
		{true, false, false, false,false, false,},
		{false, true, false, false,false, false,}

		};
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
		}

	public void testClear10() {
		boolean[][] before =
				{
						{true,  true, true, false, true, },
						{true, true, true, false, true, },
						{true, true, false, true, true, }

				};

		boolean[][] after =
				{
						{true, false, false, false, false, },
						{true, false, false, false, false,},
						{false, true, false, false, false,}

				};
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}
	public void testClear11() {
		boolean[][] before =
				{
						{false, false, false, false, false, },
						{false, false, false, false, false,},
						{false, false, false, false, false,}

				};

		boolean[][] after =
				{
						{false, false, false, false, false, },
						{false, false, false, false, false,},
						{false, false, false, false, false,}

				};
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}
	public void testClear12() {
		boolean[][] before =
				{
						{true, true, true, false, true, false, false,},
						{true, true, true, true, false,false, false,},
						{true, false, true, true, false,false, false,}

				};

		boolean[][] after =
				{
						{true, false, true, false, false, false, false,},
						{true, true, false, false, false,false, false,},
						{false,true, false, false, false,false, false,}
				};
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue(Arrays.deepEquals(after, tetris.getGrid()));
	}
}