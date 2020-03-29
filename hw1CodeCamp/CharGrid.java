// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int area = 0;
		int hMax = 0, wMax = 0;
		int wMin = 0, hMin;
		int isPresent = 0;

		if (grid.length > 0)
			for (int i = 0; i< grid.length; i++)
				wMin = grid[i].length > wMin ? grid[i].length : wMin ;
		else
			return 0;
		hMin = grid.length;
		for (int h = 0;h < grid.length; h++)
		{
			for (int w = 0;w < grid[h].length; w++)
			{
				if (grid[h][w] == ch)
				{
					isPresent = 1;
					if (h > hMax)
						hMax = h;
					if (w > wMax)
						wMax = w;
					if (w < wMin)
						wMin = w;
					if (h < hMin)
						hMin = h;
				}
			}
		}
		if (isPresent == 0)
			return 0;
		else
			return (hMax - hMin + 1) * (wMax - wMin + 1); // YOUR CODE HERE
	}

	private boolean isPlus(int row, int col) {
		char ch = grid[row][col];
		int x = 0;
		int y = 0;
		int total = 0;
		int left;
		for (int i = 0; i < grid[row].length; i++) {
			if(i > 1 && grid[row][i - 1] != ch && i < col) {
				x = 0;
				total = 0;
			}
			if(grid[row][i] == ch && i < col){
				x++;
				total++;
			} else if (grid[row][i] == ch && i > col){
				x--;
				total++;
			}else if (grid[row][i] != ch && i > col)
				break;
		}
		if (total == 0)
			return false;
		left = total;
		for (int i = 0; i < grid.length; i++) {
			if(i > 1 && grid[i - 1][col] != ch && i < row) {
				y = 0;
				left = total;
			}
			if(grid[i][col] == ch && row > i) {
				y++;
				left--;
			}else if(grid[i][col] == ch && row < i) {
				y--;
				left--;
			}else if(grid[i][col] != ch && row < i)
				break;
		}

		if (y == 0 && x == 0 && left == 0)
			return true;
		else
			return false;
	}

	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int res = 0;
		for (int r = 1; r < grid.length - 1; r++ ){
			for (int c = 1; c < grid[r].length - 1; c++){
				res += isPlus(r, c) ? 1 : 0;
			}
		}
		return res; // YOUR CODE HERE
	}
	
}
